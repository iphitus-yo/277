package com.example.paranalog.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// Represents the Checklist entity in the database
@Entity(
    tableName = "checklists",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE // If user is deleted, delete their checklists
    )],
    indices = [Index(value = ["userId"])]
)
data class Checklist(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userId: Long, // Foreign key linking to the User

    // Header Info (Aligned with new form)
    val localColeta: String?, // Filled by driver
    val responsavel: String?, // Auto-filled with driver name
    val data: String?, // Auto-filled with current date/time
    val placaCavalo: String?, // Auto-filled from user profile?
    val placaCarreta: String?,
    val motorista: String?, // Auto-filled with driver name
    val diDueCrtMicDta: String?, // Filled by driver
    val nfE: String?, // Filled by driver
    val lacreEntrada: String?, // Filled by driver (if applicable)
    val lacreSaida: String?, // Filled by driver (if applicable)
    val pesoBruto: String?, // Filled by driver
    val tipoViagem: String?, // Filled by driver: "Pernoite" or "Parada"

    // Inspection Items (19 items - "Sim", "Não", "N/A")
    val item1_parachoque: String?,
    val item1_comentario: String?,
    val item2_motor: String?,
    val item2_comentario: String?,
    val item3_pneus: String?, // Renamed from latariaPintura
    val item3_comentario: String?,
    val item4_unidadeTratora: String?, // Renamed from chassi
    val item4_comentario: String?,
    val item5_tanquesCombustivel: String?, // Renamed from assoalho
    val item5_comentario: String?,
    val item6_cabine: String?, // Renamed from teto
    val item6_comentario: String?,
    val item7_eixoElevatorioAr: String?, // Renamed from portas
    val item7_comentario: String?,
    val item8_eixoTransmissao: String?, // Renamed from vedacoes
    val item8_comentario: String?,
    val item9_areaQuintaRoda: String?, // Renamed from travasSeguranca
    val item9_comentario: String?,
    val item10_sistemaExaustao: String?, // Renamed from paralamas
    val item10_comentario: String?,
    val item11_chassi: String?, // Renamed from rodasPneus
    val item11_comentario: String?,
    val item12_portasTraseira: String?, // Renamed from tanqueCombustivel
    val item12_comentario: String?,
    val item13_portaLateralDireita: String?, // Renamed from sistemaEletrico
    val item13_comentario: String?,
    val item14_portaLateralEsquerda: String?, // Renamed from sistemaFreios
    val item14_comentario: String?,
    val item15_paredeFrontal: String?, // Renamed from suspensao
    val item15_comentario: String?,
    val item16_teto: String?, // Renamed from extintorIncendio
    val item16_comentario: String?,
    val item17_pisoCompartimentoCarga: String?, // Renamed from trianguloSinalizacao
    val item17_comentario: String?,
    val item18_dutosAr: String?, // Renamed from macacoChaveRoda
    val item18_comentario: String?,
    val item19_motorCamaraFria: String?,
    val item19_comentario: String?,

    // Additional Checks (From bottom section of the image)
    val odores: String?, // "SIM", "NAO"
    val odores_comentario: String?,
    val pragasVisiveis: String?, // "SIM", "NAO"
    val pragas_comentario: String?,
    val contaminacaoQuimica: String?, // "SIM", "NAO"
    val contaminacao_comentario: String?,
    val fundoParedeFalsa: String?, // "SIM", "NAO"
    val fundoParede_comentario: String?,
    val indiciosContaminacao: String?, // "SIM", "NAO"
    val indicios_comentario: String?,
    val autoridadeNotificada: Boolean?, // Was authority notified?
    val dataHoraNotificacao: String?, // Date/Time of notification
    val autoridade_comentario: String?,

    // New fields based on requirements
    val itemEmDesacordo: Boolean = false, // "Encontrou item em desacordo?" (Sim/Não)
    val fotoItemDesacordoPath: String? = null, // Path to the uploaded photo if itemEmDesacordo is true
    val dataHoraTermino: String?, // Auto-filled when checklist is saved

    // Signatures (Store paths or relevant data)
    val assinaturaVistoriador: String?, // Store driver's name or path to a generated image/file
    val assinaturaMotorista: String?, // Store driver's name or path

    // Metadata
    val timestamp: Long = System.currentTimeMillis(), // When the checklist was saved/created
    var status: String = "draft", // "draft", "pending_upload", "uploaded", "error"
    var pdfPath: String? = null // Path to the generated PDF file, if created
)

