package com.example.paranalog.ui.checklist

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.paranalog.R
import com.example.paranalog.databinding.FragmentChecklistFormBinding
import com.example.paranalog.ui.ViewModelFactory
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChecklistFormFragment : Fragment() {

    private var _binding: FragmentChecklistFormBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ChecklistFormViewModel by viewModels {
        ViewModelFactory(requireActivity().application)
    }

    private var currentPhotoUri: Uri? = null

    // Activity Result Launcher for Camera
    private val takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            currentPhotoUri?.let {
                viewModel.setPhotoPath(it.toString()) // Save URI as String
            }
        } else {
            Toast.makeText(requireContext(), "Captura de foto cancelada ou falhou", Toast.LENGTH_SHORT).show()
            currentPhotoUri?.let { uri ->
                try {
                    // Attempt to delete empty file if capture failed/cancelled
                    val filePath = uri.path
                    if (filePath != null) {
                        val file = File(filePath)
                        if (file.exists() && file.length() == 0L) {
                            file.delete()
                        }
                    }
                } catch (e: Exception) { /* Ignore */ }
                currentPhotoUri = null
                viewModel.setPhotoPath(null) // Clear path in ViewModel too
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChecklistFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Get the actual logged-in user ID from arguments or shared ViewModel
        val loggedInUserId = 1L // Replace with actual logic
        viewModel.loadCurrentUser(loggedInUserId)

        setupInputBindings()
        setupObservers()
        setupClickListeners()
    }

    private fun setupInputBindings() {
        // --- Header Text Fields ---
        binding.localColetaEditText.doAfterTextChanged { viewModel.localColeta.value = it.toString() }
        binding.placaCarretaEditText.doAfterTextChanged { viewModel.placaCarreta.value = it.toString() }
        binding.diDueCrtMicDtaEditText.doAfterTextChanged { viewModel.diDueCrtMicDta.value = it.toString() }
        binding.nfEEditText.doAfterTextChanged { viewModel.nfE.value = it.toString() }
        binding.lacreEntradaEditText.doAfterTextChanged { viewModel.lacreEntrada.value = it.toString() }
        binding.lacreSaidaEditText.doAfterTextChanged { viewModel.lacreSaida.value = it.toString() }
        binding.pesoBrutoEditText.doAfterTextChanged { viewModel.pesoBruto.value = it.toString() }

        // --- Header RadioGroups ---
        binding.rgTipoViagem.setOnCheckedChangeListener { _, checkedId ->
            viewModel.tipoViagem.value = when (checkedId) {
                R.id.rb_pernoite -> "Pernoite"
                R.id.rb_parada -> "Parada"
                else -> null
            }
        }

        // --- Inspection Items (RadioGroups & Comments) ---
        setupItemRow(binding.rgItem1, binding.etItem1Comment, viewModel.item1_parachoque, viewModel.item1_comentario)
        setupItemRow(binding.rgItem2, binding.etItem2Comment, viewModel.item2_motor, viewModel.item2_comentario)
        setupItemRow(binding.rgItem3, binding.etItem3Comment, viewModel.item3_pneus, viewModel.item3_comentario)
        setupItemRow(binding.rgItem4, binding.etItem4Comment, viewModel.item4_unidadeTratora, viewModel.item4_comentario)
        setupItemRow(binding.rgItem5, binding.etItem5Comment, viewModel.item5_tanquesCombustivel, viewModel.item5_comentario)
        setupItemRow(binding.rgItem6, binding.etItem6Comment, viewModel.item6_cabine, viewModel.item6_comentario)
        setupItemRow(binding.rgItem7, binding.etItem7Comment, viewModel.item7_eixoElevatorioAr, viewModel.item7_comentario)
        setupItemRow(binding.rgItem8, binding.etItem8Comment, viewModel.item8_eixoTransmissao, viewModel.item8_comentario)
        setupItemRow(binding.rgItem9, binding.etItem9Comment, viewModel.item9_areaQuintaRoda, viewModel.item9_comentario)
        setupItemRow(binding.rgItem10, binding.etItem10Comment, viewModel.item10_sistemaExaustao, viewModel.item10_comentario)
        setupItemRow(binding.rgItem11, binding.etItem11Comment, viewModel.item11_chassi, viewModel.item11_comentario)
        setupItemRow(binding.rgItem12, binding.etItem12Comment, viewModel.item12_portasTraseira, viewModel.item12_comentario)
        setupItemRow(binding.rgItem13, binding.etItem13Comment, viewModel.item13_portaLateralDireita, viewModel.item13_comentario)
        setupItemRow(binding.rgItem14, binding.etItem14Comment, viewModel.item14_portaLateralEsquerda, viewModel.item14_comentario)
        setupItemRow(binding.rgItem15, binding.etItem15Comment, viewModel.item15_paredeFrontal, viewModel.item15_comentario)
        setupItemRow(binding.rgItem16, binding.etItem16Comment, viewModel.item16_teto, viewModel.item16_comentario)
        setupItemRow(binding.rgItem17, binding.etItem17Comment, viewModel.item17_pisoCompartimentoCarga, viewModel.item17_comentario)
        setupItemRow(binding.rgItem18, binding.etItem18Comment, viewModel.item18_dutosAr, viewModel.item18_comentario)
        setupItemRow(binding.rgItem19, binding.etItem19Comment, viewModel.item19_motorCamaraFria, viewModel.item19_comentario)

        // --- Additional Checks (RadioGroups & Comments) ---
        setupItemRow(binding.rgOdores, binding.etOdoresComment, viewModel.odores, viewModel.odores_comentario, isNaAvailable = false)
        setupItemRow(binding.rgPragas, binding.etPragasComment, viewModel.pragasVisiveis, viewModel.pragas_comentario, isNaAvailable = false)
        setupItemRow(binding.rgContaminacao, binding.etContaminacaoComment, viewModel.contaminacaoQuimica, viewModel.contaminacao_comentario, isNaAvailable = false)
        setupItemRow(binding.rgFundoParede, binding.etFundoParedeComment, viewModel.fundoParedeFalsa, viewModel.fundoParede_comentario, isNaAvailable = false)
        setupItemRow(binding.rgIndicios, binding.etIndiciosComment, viewModel.indiciosContaminacao, viewModel.indicios_comentario, isNaAvailable = false)

        // Autoridade Notificada
        binding.rgAutoridade.setOnCheckedChangeListener { _, checkedId ->
            val isSim = checkedId == R.id.rb_autoridade_sim
            viewModel.updateAutoridadeNotificada(isSim)
        }
        binding.dataHoraNotificacaoEditText.doAfterTextChanged { viewModel.dataHoraNotificacao.value = it.toString() }
        binding.etAutoridadeComment.doAfterTextChanged { viewModel.autoridade_comentario.value = it.toString() }

        // --- Item em Desacordo ---
        binding.rgItemDesacordo.setOnCheckedChangeListener { _, checkedId ->
            val isSim = checkedId == R.id.rb_item_desacordo_sim
            viewModel.updateItemEmDesacordo(isSim)
        }
    }

    // Helper function for setting up RadioGroup and EditText bindings
    private fun setupItemRow(
        radioGroup: RadioGroup,
        commentEditText: EditText,
        statusLiveData: MutableLiveData<String?>,
        commentLiveData: MutableLiveData<String?>,
        isNaAvailable: Boolean = true
    ) {
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById<RadioButton>(checkedId)
            statusLiveData.value = when (radioButton?.id) {
                // Assuming IDs follow pattern rb_itemX_sim, rb_itemX_nao, rb_itemX_na
                // This relies on the order in the XML layout (Sim=0, Nao=1, NA=2)
                group.getChildAt(0).id -> "Sim"
                group.getChildAt(1).id -> "Não"
                group.getChildAt(2)?.id -> if (isNaAvailable) "N/A" else null
                else -> null
            }
        }
        commentEditText.doAfterTextChanged { commentLiveData.value = it.toString() }
    }

    private fun setupClickListeners() {
        binding.saveButton.setOnClickListener {
            binding.saveButton.isEnabled = false // Disable button immediately
            binding.statusTextView.text = "Salvando checklist..." // Initial feedback
            binding.statusTextView.visibility = View.VISIBLE
            viewModel.saveChecklist()
        }

        binding.takePhotoButton.setOnClickListener {
            dispatchTakePictureIntent()
        }
    }

    private fun setupObservers() {
        // Observe User Data for Pre-filling
        viewModel.currentUser.observe(viewLifecycleOwner) { user ->
            user?.let {
                binding.responsavelTextView.text = "Responsável pela Inspeção: ${it.name}"
                binding.motoristaTextView.text = "Motorista: ${it.name}"
                binding.placaCavaloTextView.text = "Placa cavalo: ${it.defaultPlateCavalo ?: "N/A"}"
                // Also pre-fill the EditText for trailer plate if available
                if (binding.placaCarretaEditText.text.isNullOrEmpty()) {
                    binding.placaCarretaEditText.setText(it.defaultPlateCarreta ?: "")
                }
                binding.assinaturaVistoriadorTextView.text = it.name
                binding.assinaturaMotoristaTextView.text = it.name
            }
        }

        // Observe Date for Pre-filling
        viewModel.data.observe(viewLifecycleOwner) { date ->
            binding.dataTextView.text = "Data: ${date ?: "N/A"}"
        }

        // Observe Navigation Event (triggered after initial save)
        viewModel.navigateBackEvent.observe(viewLifecycleOwner) { navigate ->
            if (navigate == true) {
                Toast.makeText(requireContext(), "Checklist salvo. Processando em segundo plano...", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
                // Reset event to prevent re-triggering
                // viewModel.onNavigationComplete() // Add a method in ViewModel to reset the event
            }
        }

        // Observe Process Status (Background work: PDF Gen & Email)
        viewModel.processStatus.observe(viewLifecycleOwner) { statusMessage ->
            // Show status temporarily (e.g., using a Toast or Snackbar)
            // Avoid keeping the statusTextView visible indefinitely as navigation happens quickly
            if (!statusMessage.isNullOrBlank()) {
                 Toast.makeText(requireContext(), statusMessage, Toast.LENGTH_SHORT).show()
            }
            // The statusTextView is mainly for initial save feedback now
            // binding.statusTextView.text = statusMessage
            // binding.statusTextView.visibility = View.VISIBLE

            // Re-enable button only on initial save failure (handled by observing navigateBackEvent's absence)
            // If navigateBackEvent is not triggered, it means initial save failed.
            // We might need a separate LiveData for initial save failure feedback.
        }

        // Observe Visibility for Photo Upload Section
        viewModel.showPhotoUploadSection.observe(viewLifecycleOwner) { show ->
            binding.photoUploadSection.isVisible = show
        }

        // Observe Visibility for Autoridade Notificada Details
        viewModel.showAutoridadeNotificadaDetails.observe(viewLifecycleOwner) { show ->
            binding.dataHoraNotificacaoLayout.isVisible = show
        }

        // Observe Photo Path to update ImageView
        viewModel.fotoItemDesacordoPath.observe(viewLifecycleOwner) { pathString ->
            if (!pathString.isNullOrBlank()) {
                try {
                    val photoUri = Uri.parse(pathString)
                    Glide.with(this)
                        .load(photoUri)
                        .placeholder(R.drawable.ic_launcher_foreground_logo) // Use a placeholder
                        .error(android.R.drawable.ic_dialog_alert) // Use an error icon
                        .into(binding.itemDesacordoImageView)
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "Erro ao carregar imagem", Toast.LENGTH_SHORT).show()
                    binding.itemDesacordoImageView.setImageResource(android.R.drawable.ic_dialog_alert)
                }
            } else {
                // Set default image if path is null or blank
                binding.itemDesacordoImageView.setImageResource(android.R.drawable.ic_menu_camera)
            }
        }
    }

    // --- Camera Logic ---
    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        // Use app's internal cache directory for temporary photo files
        val storageDir: File = requireContext().cacheDir
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(requireActivity().packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    Toast.makeText(requireContext(), "Erro ao criar arquivo para foto", Toast.LENGTH_SHORT).show()
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        requireContext(),
                        "${requireContext().packageName}.provider", // Authority must match AndroidManifest
                        it
                    )
                    currentPhotoUri = photoURI
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    takePictureLauncher.launch(takePictureIntent)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

