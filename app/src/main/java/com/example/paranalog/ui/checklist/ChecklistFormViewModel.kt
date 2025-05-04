package com.example.paranalog.ui.checklist

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.*
import com.example.paranalog.data.Checklist
import com.example.paranalog.data.ChecklistRepository
import com.example.paranalog.data.User
import com.example.paranalog.data.UserRepository
import com.example.paranalog.worker.EmailSendingWorker
import com.example.paranalog.worker.NativePdfGenerationWorker // Import the new worker
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID
import android.content.Context // Import Context
import android.util.Log
import androidx.lifecycle.Observer

class ChecklistFormViewModel(
    private val checklistRepository: ChecklistRepository,
    private val userRepository: UserRepository,
    private val workManager: WorkManager,
    private val context: Context // Inject Context for connectivity check
) : ViewModel() {

    // --- Result LiveData ---
    // Renamed to reflect its purpose: triggering navigation after initial save
    private val _navigateBackEvent = MutableLiveData<Boolean>()
    val navigateBackEvent: LiveData<Boolean> = _navigateBackEvent

    // Feedback for overall process status (Saving, PDF, Email)
    private val _processStatus = MutableLiveData<String>()
    val processStatus: LiveData<String> = _processStatus

    // --- User Info LiveData ---
    private val _currentUser = MutableLiveData<User?>()
    val currentUser: LiveData<User?> = _currentUser

    // --- Form Fields LiveData (Matching Checklist.kt) ---
    // Header
    val localColeta = MutableLiveData<String?>()
    val responsavel = MutableLiveData<String?>() // Auto-filled
    val data = MutableLiveData<String?>() // Auto-filled
    val placaCavalo = MutableLiveData<String?>() // Auto-filled from User.defaultPlateCavalo
    val placaCarreta = MutableLiveData<String?>() // Auto-filled from User.defaultPlateCarreta
    val motorista = MutableLiveData<String?>() // Auto-filled
    val diDueCrtMicDta = MutableLiveData<String?>()
    val nfE = MutableLiveData<String?>()
    val lacreEntrada = MutableLiveData<String?>()
    val lacreSaida = MutableLiveData<String?>()
    val pesoBruto = MutableLiveData<String?>()
    val tipoViagem = MutableLiveData<String?>()

    // Inspection Items (1-19)
    val item1_parachoque = MutableLiveData<String?>()
    val item1_comentario = MutableLiveData<String?>()
    val item2_motor = MutableLiveData<String?>()
    val item2_comentario = MutableLiveData<String?>()
    val item3_pneus = MutableLiveData<String?>()
    val item3_comentario = MutableLiveData<String?>()
    val item4_unidadeTratora = MutableLiveData<String?>()
    val item4_comentario = MutableLiveData<String?>()
    val item5_tanquesCombustivel = MutableLiveData<String?>()
    val item5_comentario = MutableLiveData<String?>()
    val item6_cabine = MutableLiveData<String?>()
    val item6_comentario = MutableLiveData<String?>()
    val item7_eixoElevatorioAr = MutableLiveData<String?>()
    val item7_comentario = MutableLiveData<String?>()
    val item8_eixoTransmissao = MutableLiveData<String?>()
    val item8_comentario = MutableLiveData<String?>()
    val item9_areaQuintaRoda = MutableLiveData<String?>()
    val item9_comentario = MutableLiveData<String?>()
    val item10_sistemaExaustao = MutableLiveData<String?>()
    val item10_comentario = MutableLiveData<String?>()
    val item11_chassi = MutableLiveData<String?>()
    val item11_comentario = MutableLiveData<String?>()
    val item12_portasTraseira = MutableLiveData<String?>()
    val item12_comentario = MutableLiveData<String?>()
    val item13_portaLateralDireita = MutableLiveData<String?>()
    val item13_comentario = MutableLiveData<String?>()
    val item14_portaLateralEsquerda = MutableLiveData<String?>()
    val item14_comentario = MutableLiveData<String?>()
    val item15_paredeFrontal = MutableLiveData<String?>()
    val item15_comentario = MutableLiveData<String?>()
    val item16_teto = MutableLiveData<String?>()
    val item16_comentario = MutableLiveData<String?>()
    val item17_pisoCompartimentoCarga = MutableLiveData<String?>()
    val item17_comentario = MutableLiveData<String?>()
    val item18_dutosAr = MutableLiveData<String?>()
    val item18_comentario = MutableLiveData<String?>()
    val item19_motorCamaraFria = MutableLiveData<String?>()
    val item19_comentario = MutableLiveData<String?>()

    // Additional Checks
    val odores = MutableLiveData<String?>()
    val odores_comentario = MutableLiveData<String?>()
    val pragasVisiveis = MutableLiveData<String?>()
    val pragas_comentario = MutableLiveData<String?>()
    val contaminacaoQuimica = MutableLiveData<String?>()
    val contaminacao_comentario = MutableLiveData<String?>()
    val fundoParedeFalsa = MutableLiveData<String?>()
    val fundoParede_comentario = MutableLiveData<String?>()
    val indiciosContaminacao = MutableLiveData<String?>()
    val indicios_comentario = MutableLiveData<String?>()
    val autoridadeNotificada = MutableLiveData<Boolean?>()
    val dataHoraNotificacao = MutableLiveData<String?>()
    val autoridade_comentario = MutableLiveData<String?>()

    // Item em Desacordo & Photo
    val itemEmDesacordo = MutableLiveData<Boolean>(false)
    val fotoItemDesacordoPath = MutableLiveData<String?>()
    val showPhotoUploadSection = MutableLiveData<Boolean>(false)
    val showAutoridadeNotificadaDetails = MutableLiveData<Boolean>(false)

    // Signatures & Footer
    val assinaturaVistoriador = MutableLiveData<String?>() // Auto-filled
    val assinaturaMotorista = MutableLiveData<String?>() // Auto-filled
    val dataHoraTermino = MutableLiveData<String?>() // Auto-filled on save

    // --- Initialization ---
    private var currentUserId: Long? = null

    // Observer to remove itself after observing worker status once
    private val workerObservers = mutableMapOf<UUID, Observer<WorkInfo>>()

    fun loadCurrentUser(userId: Long) {
        currentUserId = userId
        viewModelScope.launch {
            _currentUser.value = userRepository.getUserById(userId)
            prefillUserData(_currentUser.value)
        }
        prefillDateTime()
    }

    private fun prefillUserData(user: User?) {
        user?.let {
            responsavel.value = it.name
            motorista.value = it.name
            placaCavalo.value = it.defaultPlateCavalo
            placaCarreta.value = it.defaultPlateCarreta // Auto-fill trailer plate
            assinaturaVistoriador.value = it.name
            assinaturaMotorista.value = it.name
        }
    }

    private fun prefillDateTime() {
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        data.value = sdf.format(Date())
    }

    // --- UI Logic ---
    fun updateItemEmDesacordo(isSimSelected: Boolean) {
        itemEmDesacordo.value = isSimSelected
        showPhotoUploadSection.value = isSimSelected
        if (!isSimSelected) {
            fotoItemDesacordoPath.value = null
        }
    }

    fun updateAutoridadeNotificada(isSimSelected: Boolean) {
        autoridadeNotificada.value = isSimSelected
        showAutoridadeNotificadaDetails.value = isSimSelected
        if (!isSimSelected) {
            dataHoraNotificacao.value = null
        }
    }

    fun setPhotoPath(uriString: String?) {
        fotoItemDesacordoPath.value = uriString
    }

    // --- Save Logic ---
    fun saveChecklist() {
        val userId = currentUserId
        if (userId == null) {
            _processStatus.postValue("Erro: ID do usuário não encontrado.")
            return
        }

        // Basic Validations
        if (localColeta.value.isNullOrBlank()) {
            _processStatus.postValue("Erro: Local da Coleta é obrigatório.")
            return
        }
        if (itemEmDesacordo.value == true && fotoItemDesacordoPath.value.isNullOrBlank()) {
            _processStatus.postValue("Erro: Foto é obrigatória quando um item está em desacordo.")
            return
        }
        if (autoridadeNotificada.value == true && dataHoraNotificacao.value.isNullOrBlank()) {
            _processStatus.postValue("Erro: Data/Hora da notificação é obrigatória quando a autoridade foi notificada.")
            return
        }

        // Set final timestamp
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        dataHoraTermino.value = sdf.format(Date())

        val newChecklist = Checklist(
            userId = userId,
            localColeta = localColeta.value,
            responsavel = responsavel.value,
            data = data.value,
            placaCavalo = placaCavalo.value,
            placaCarreta = placaCarreta.value, // Save the (potentially auto-filled) trailer plate
            motorista = motorista.value,
            diDueCrtMicDta = diDueCrtMicDta.value,
            nfE = nfE.value,
            lacreEntrada = lacreEntrada.value,
            lacreSaida = lacreSaida.value,
            pesoBruto = pesoBruto.value,
            tipoViagem = tipoViagem.value,

            // Inspection Items (Copy all 19 items and comments)
            item1_parachoque = item1_parachoque.value, item1_comentario = item1_comentario.value,
            item2_motor = item2_motor.value, item2_comentario = item2_comentario.value,
            item3_pneus = item3_pneus.value, item3_comentario = item3_comentario.value,
            item4_unidadeTratora = item4_unidadeTratora.value, item4_comentario = item4_comentario.value,
            item5_tanquesCombustivel = item5_tanquesCombustivel.value, item5_comentario = item5_comentario.value,
            item6_cabine = item6_cabine.value, item6_comentario = item6_comentario.value,
            item7_eixoElevatorioAr = item7_eixoElevatorioAr.value, item7_comentario = item7_comentario.value,
            item8_eixoTransmissao = item8_eixoTransmissao.value, item8_comentario = item8_comentario.value,
            item9_areaQuintaRoda = item9_areaQuintaRoda.value, item9_comentario = item9_comentario.value,
            item10_sistemaExaustao = item10_sistemaExaustao.value, item10_comentario = item10_comentario.value,
            item11_chassi = item11_chassi.value, item11_comentario = item11_comentario.value,
            item12_portasTraseira = item12_portasTraseira.value, item12_comentario = item12_comentario.value,
            item13_portaLateralDireita = item13_portaLateralDireita.value, item13_comentario = item13_comentario.value,
            item14_portaLateralEsquerda = item14_portaLateralEsquerda.value, item14_comentario = item14_comentario.value,
            item15_paredeFrontal = item15_paredeFrontal.value, item15_comentario = item15_comentario.value,
            item16_teto = item16_teto.value, item16_comentario = item16_comentario.value,
            item17_pisoCompartimentoCarga = item17_pisoCompartimentoCarga.value, item17_comentario = item17_comentario.value,
            item18_dutosAr = item18_dutosAr.value, item18_comentario = item18_comentario.value,
            item19_motorCamaraFria = item19_motorCamaraFria.value, item19_comentario = item19_comentario.value,

            // Additional Checks
            odores = odores.value, odores_comentario = odores_comentario.value,
            pragasVisiveis = pragasVisiveis.value, pragas_comentario = pragas_comentario.value,
            contaminacaoQuimica = contaminacaoQuimica.value, contaminacao_comentario = contaminacao_comentario.value,
            fundoParedeFalsa = fundoParedeFalsa.value, fundoParede_comentario = fundoParede_comentario.value,
            indiciosContaminacao = indiciosContaminacao.value, indicios_comentario = indicios_comentario.value,
            autoridadeNotificada = autoridadeNotificada.value, dataHoraNotificacao = dataHoraNotificacao.value, autoridade_comentario = autoridade_comentario.value,

            itemEmDesacordo = itemEmDesacordo.value ?: false,
            fotoItemDesacordoPath = fotoItemDesacordoPath.value,
            dataHoraTermino = dataHoraTermino.value, // Save the final timestamp

            assinaturaVistoriador = assinaturaVistoriador.value, // Save the auto-filled name
            assinaturaMotorista = assinaturaMotorista.value, // Save the auto-filled name

            timestamp = System.currentTimeMillis(),
            status = "saving" // Initial status
        )

        // Post initial status
        _processStatus.postValue("Salvando checklist...")

        viewModelScope.launch {
            try {
                val insertedId = checklistRepository.insertChecklist(newChecklist)
                if (insertedId > 0) {
                    // Checklist saved to DB, now enqueue background work
                    _processStatus.postValue("Checklist salvo. Iniciando processos em segundo plano...")
                    enqueueBackgroundWork(insertedId)
                    // Trigger navigation back immediately after enqueueing
                    _navigateBackEvent.postValue(true)
                } else {
                    _processStatus.postValue("Erro ao salvar checklist no banco.")
                }
            } catch (e: Exception) {
                _processStatus.postValue("Erro ao salvar checklist: ${e.message}")
                Log.e("ChecklistFormVM", "Error saving checklist", e)
            }
        }
    }

    private fun enqueueBackgroundWork(checklistId: Long) {
        // 1. PDF Generation Request
        val pdfInputData = Data.Builder()
            .putLong(NativePdfGenerationWorker.KEY_CHECKLIST_ID, checklistId)
            .build()
        val pdfWorkRequest = OneTimeWorkRequestBuilder<NativePdfGenerationWorker>()
            .setInputData(pdfInputData)
            .addTag("pdf_$checklistId") // Tag for observation
            .build()

        // 2. Email Sending Request (depends on PDF)
        val emailConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        // Email worker needs checklistId and pdfPath (passed from pdfWorker)
        val emailWorkRequest = OneTimeWorkRequestBuilder<EmailSendingWorker>()
            .setConstraints(emailConstraints)
            // Input data (checklistId) will be merged + pdfPath from previous worker
            .setInputMerger(OverwritingInputMerger::class.java)
            .addTag("email_$checklistId") // Tag for observation
            .build()

        // Chain the work: Generate PDF -> Send Email
        workManager.beginUniqueWork("checklist_process_$checklistId", ExistingWorkPolicy.APPEND_OR_REPLACE, pdfWorkRequest)
            .then(emailWorkRequest)
            .enqueue()

        // Observe the final worker (EmailSendingWorker) for final status feedback
        observeEmailWorker(emailWorkRequest.id, checklistId)
    }

    // Observe Email Worker for final status
    private fun observeEmailWorker(workId: UUID, checklistId: Long) {
        val liveData = workManager.getWorkInfoByIdLiveData(workId)
        val observer = Observer<WorkInfo> { workInfo ->
            if (workInfo != null) {
                val isFinished = workInfo.state.isFinished
                val statusMessage = when (workInfo.state) {
                    WorkInfo.State.SUCCEEDED -> "Checklist $checklistId: Email enviado com sucesso!"
                    WorkInfo.State.FAILED -> "Checklist $checklistId: Falha ao enviar email."
                    WorkInfo.State.CANCELLED -> "Checklist $checklistId: Envio de email cancelado."
                    WorkInfo.State.BLOCKED -> "Checklist $checklistId: Envio de email aguardando conexão..."
                    WorkInfo.State.ENQUEUED -> "Checklist $checklistId: Envio de email na fila..."
                    WorkInfo.State.RUNNING -> "Checklist $checklistId: Enviando email..."
                }
                // Update status in DB (fire and forget)
                viewModelScope.launch {
                    try {
                        // *** CORRECTION: Use the correct repository method name ***
                        checklistRepository.updateStatus(checklistId, workInfo.state.name.lowercase())
                    } catch (e: Exception) {
                        Log.e("ChecklistFormVM", "Failed to update status for $checklistId", e)
                    }
                }
                Log.d("ChecklistFormVM", statusMessage) // Log status for debugging
                _processStatus.postValue(statusMessage) // Post status for potential UI feedback (e.g., Toast)

                // If finished, remove the observer
                if (isFinished) {
                    val removedObserver = workerObservers.remove(workId)
                    removedObserver?.let { liveData.removeObserver(it) }
                }
            }
        }
        workerObservers[workId] = observer
        liveData.observeForever(observer)
    }

    // --- Helper Functions ---
    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    // Call this when the ViewModel is cleared to remove observers
    override fun onCleared() {
        super.onCleared()
        workerObservers.forEach { (uuid, observer) ->
            workManager.getWorkInfoByIdLiveData(uuid).removeObserver(observer)
        }
        workerObservers.clear()
    }

    // Function to reset the navigation event (called from Fragment)
    fun onNavigationComplete() {
        _navigateBackEvent.value = false
    }
}

