package com.example.paranalog.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChecklistDao_Impl implements ChecklistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Checklist> __insertionAdapterOfChecklist;

  private final EntityDeletionOrUpdateAdapter<Checklist> __deletionAdapterOfChecklist;

  private final EntityDeletionOrUpdateAdapter<Checklist> __updateAdapterOfChecklist;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePdfPath;

  public ChecklistDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChecklist = new EntityInsertionAdapter<Checklist>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `checklists` (`id`,`userId`,`localColeta`,`responsavel`,`data`,`placaCavalo`,`placaCarreta`,`motorista`,`diDueCrtMicDta`,`nfE`,`lacreEntrada`,`lacreSaida`,`pesoBruto`,`tipoViagem`,`item1_parachoque`,`item1_comentario`,`item2_motor`,`item2_comentario`,`item3_pneus`,`item3_comentario`,`item4_unidadeTratora`,`item4_comentario`,`item5_tanquesCombustivel`,`item5_comentario`,`item6_cabine`,`item6_comentario`,`item7_eixoElevatorioAr`,`item7_comentario`,`item8_eixoTransmissao`,`item8_comentario`,`item9_areaQuintaRoda`,`item9_comentario`,`item10_sistemaExaustao`,`item10_comentario`,`item11_chassi`,`item11_comentario`,`item12_portasTraseira`,`item12_comentario`,`item13_portaLateralDireita`,`item13_comentario`,`item14_portaLateralEsquerda`,`item14_comentario`,`item15_paredeFrontal`,`item15_comentario`,`item16_teto`,`item16_comentario`,`item17_pisoCompartimentoCarga`,`item17_comentario`,`item18_dutosAr`,`item18_comentario`,`item19_motorCamaraFria`,`item19_comentario`,`odores`,`odores_comentario`,`pragasVisiveis`,`pragas_comentario`,`contaminacaoQuimica`,`contaminacao_comentario`,`fundoParedeFalsa`,`fundoParede_comentario`,`indiciosContaminacao`,`indicios_comentario`,`autoridadeNotificada`,`dataHoraNotificacao`,`autoridade_comentario`,`itemEmDesacordo`,`fotoItemDesacordoPath`,`dataHoraTermino`,`assinaturaVistoriador`,`assinaturaMotorista`,`timestamp`,`status`,`pdfPath`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Checklist entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getLocalColeta() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLocalColeta());
        }
        if (entity.getResponsavel() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getResponsavel());
        }
        if (entity.getData() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getData());
        }
        if (entity.getPlacaCavalo() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPlacaCavalo());
        }
        if (entity.getPlacaCarreta() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPlacaCarreta());
        }
        if (entity.getMotorista() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getMotorista());
        }
        if (entity.getDiDueCrtMicDta() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDiDueCrtMicDta());
        }
        if (entity.getNfE() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getNfE());
        }
        if (entity.getLacreEntrada() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getLacreEntrada());
        }
        if (entity.getLacreSaida() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getLacreSaida());
        }
        if (entity.getPesoBruto() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getPesoBruto());
        }
        if (entity.getTipoViagem() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getTipoViagem());
        }
        if (entity.getItem1_parachoque() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getItem1_parachoque());
        }
        if (entity.getItem1_comentario() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getItem1_comentario());
        }
        if (entity.getItem2_motor() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getItem2_motor());
        }
        if (entity.getItem2_comentario() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getItem2_comentario());
        }
        if (entity.getItem3_pneus() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getItem3_pneus());
        }
        if (entity.getItem3_comentario() == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, entity.getItem3_comentario());
        }
        if (entity.getItem4_unidadeTratora() == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, entity.getItem4_unidadeTratora());
        }
        if (entity.getItem4_comentario() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getItem4_comentario());
        }
        if (entity.getItem5_tanquesCombustivel() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getItem5_tanquesCombustivel());
        }
        if (entity.getItem5_comentario() == null) {
          statement.bindNull(24);
        } else {
          statement.bindString(24, entity.getItem5_comentario());
        }
        if (entity.getItem6_cabine() == null) {
          statement.bindNull(25);
        } else {
          statement.bindString(25, entity.getItem6_cabine());
        }
        if (entity.getItem6_comentario() == null) {
          statement.bindNull(26);
        } else {
          statement.bindString(26, entity.getItem6_comentario());
        }
        if (entity.getItem7_eixoElevatorioAr() == null) {
          statement.bindNull(27);
        } else {
          statement.bindString(27, entity.getItem7_eixoElevatorioAr());
        }
        if (entity.getItem7_comentario() == null) {
          statement.bindNull(28);
        } else {
          statement.bindString(28, entity.getItem7_comentario());
        }
        if (entity.getItem8_eixoTransmissao() == null) {
          statement.bindNull(29);
        } else {
          statement.bindString(29, entity.getItem8_eixoTransmissao());
        }
        if (entity.getItem8_comentario() == null) {
          statement.bindNull(30);
        } else {
          statement.bindString(30, entity.getItem8_comentario());
        }
        if (entity.getItem9_areaQuintaRoda() == null) {
          statement.bindNull(31);
        } else {
          statement.bindString(31, entity.getItem9_areaQuintaRoda());
        }
        if (entity.getItem9_comentario() == null) {
          statement.bindNull(32);
        } else {
          statement.bindString(32, entity.getItem9_comentario());
        }
        if (entity.getItem10_sistemaExaustao() == null) {
          statement.bindNull(33);
        } else {
          statement.bindString(33, entity.getItem10_sistemaExaustao());
        }
        if (entity.getItem10_comentario() == null) {
          statement.bindNull(34);
        } else {
          statement.bindString(34, entity.getItem10_comentario());
        }
        if (entity.getItem11_chassi() == null) {
          statement.bindNull(35);
        } else {
          statement.bindString(35, entity.getItem11_chassi());
        }
        if (entity.getItem11_comentario() == null) {
          statement.bindNull(36);
        } else {
          statement.bindString(36, entity.getItem11_comentario());
        }
        if (entity.getItem12_portasTraseira() == null) {
          statement.bindNull(37);
        } else {
          statement.bindString(37, entity.getItem12_portasTraseira());
        }
        if (entity.getItem12_comentario() == null) {
          statement.bindNull(38);
        } else {
          statement.bindString(38, entity.getItem12_comentario());
        }
        if (entity.getItem13_portaLateralDireita() == null) {
          statement.bindNull(39);
        } else {
          statement.bindString(39, entity.getItem13_portaLateralDireita());
        }
        if (entity.getItem13_comentario() == null) {
          statement.bindNull(40);
        } else {
          statement.bindString(40, entity.getItem13_comentario());
        }
        if (entity.getItem14_portaLateralEsquerda() == null) {
          statement.bindNull(41);
        } else {
          statement.bindString(41, entity.getItem14_portaLateralEsquerda());
        }
        if (entity.getItem14_comentario() == null) {
          statement.bindNull(42);
        } else {
          statement.bindString(42, entity.getItem14_comentario());
        }
        if (entity.getItem15_paredeFrontal() == null) {
          statement.bindNull(43);
        } else {
          statement.bindString(43, entity.getItem15_paredeFrontal());
        }
        if (entity.getItem15_comentario() == null) {
          statement.bindNull(44);
        } else {
          statement.bindString(44, entity.getItem15_comentario());
        }
        if (entity.getItem16_teto() == null) {
          statement.bindNull(45);
        } else {
          statement.bindString(45, entity.getItem16_teto());
        }
        if (entity.getItem16_comentario() == null) {
          statement.bindNull(46);
        } else {
          statement.bindString(46, entity.getItem16_comentario());
        }
        if (entity.getItem17_pisoCompartimentoCarga() == null) {
          statement.bindNull(47);
        } else {
          statement.bindString(47, entity.getItem17_pisoCompartimentoCarga());
        }
        if (entity.getItem17_comentario() == null) {
          statement.bindNull(48);
        } else {
          statement.bindString(48, entity.getItem17_comentario());
        }
        if (entity.getItem18_dutosAr() == null) {
          statement.bindNull(49);
        } else {
          statement.bindString(49, entity.getItem18_dutosAr());
        }
        if (entity.getItem18_comentario() == null) {
          statement.bindNull(50);
        } else {
          statement.bindString(50, entity.getItem18_comentario());
        }
        if (entity.getItem19_motorCamaraFria() == null) {
          statement.bindNull(51);
        } else {
          statement.bindString(51, entity.getItem19_motorCamaraFria());
        }
        if (entity.getItem19_comentario() == null) {
          statement.bindNull(52);
        } else {
          statement.bindString(52, entity.getItem19_comentario());
        }
        if (entity.getOdores() == null) {
          statement.bindNull(53);
        } else {
          statement.bindString(53, entity.getOdores());
        }
        if (entity.getOdores_comentario() == null) {
          statement.bindNull(54);
        } else {
          statement.bindString(54, entity.getOdores_comentario());
        }
        if (entity.getPragasVisiveis() == null) {
          statement.bindNull(55);
        } else {
          statement.bindString(55, entity.getPragasVisiveis());
        }
        if (entity.getPragas_comentario() == null) {
          statement.bindNull(56);
        } else {
          statement.bindString(56, entity.getPragas_comentario());
        }
        if (entity.getContaminacaoQuimica() == null) {
          statement.bindNull(57);
        } else {
          statement.bindString(57, entity.getContaminacaoQuimica());
        }
        if (entity.getContaminacao_comentario() == null) {
          statement.bindNull(58);
        } else {
          statement.bindString(58, entity.getContaminacao_comentario());
        }
        if (entity.getFundoParedeFalsa() == null) {
          statement.bindNull(59);
        } else {
          statement.bindString(59, entity.getFundoParedeFalsa());
        }
        if (entity.getFundoParede_comentario() == null) {
          statement.bindNull(60);
        } else {
          statement.bindString(60, entity.getFundoParede_comentario());
        }
        if (entity.getIndiciosContaminacao() == null) {
          statement.bindNull(61);
        } else {
          statement.bindString(61, entity.getIndiciosContaminacao());
        }
        if (entity.getIndicios_comentario() == null) {
          statement.bindNull(62);
        } else {
          statement.bindString(62, entity.getIndicios_comentario());
        }
        final Integer _tmp = entity.getAutoridadeNotificada() == null ? null : (entity.getAutoridadeNotificada() ? 1 : 0);
        if (_tmp == null) {
          statement.bindNull(63);
        } else {
          statement.bindLong(63, _tmp);
        }
        if (entity.getDataHoraNotificacao() == null) {
          statement.bindNull(64);
        } else {
          statement.bindString(64, entity.getDataHoraNotificacao());
        }
        if (entity.getAutoridade_comentario() == null) {
          statement.bindNull(65);
        } else {
          statement.bindString(65, entity.getAutoridade_comentario());
        }
        final int _tmp_1 = entity.getItemEmDesacordo() ? 1 : 0;
        statement.bindLong(66, _tmp_1);
        if (entity.getFotoItemDesacordoPath() == null) {
          statement.bindNull(67);
        } else {
          statement.bindString(67, entity.getFotoItemDesacordoPath());
        }
        if (entity.getDataHoraTermino() == null) {
          statement.bindNull(68);
        } else {
          statement.bindString(68, entity.getDataHoraTermino());
        }
        if (entity.getAssinaturaVistoriador() == null) {
          statement.bindNull(69);
        } else {
          statement.bindString(69, entity.getAssinaturaVistoriador());
        }
        if (entity.getAssinaturaMotorista() == null) {
          statement.bindNull(70);
        } else {
          statement.bindString(70, entity.getAssinaturaMotorista());
        }
        statement.bindLong(71, entity.getTimestamp());
        statement.bindString(72, entity.getStatus());
        if (entity.getPdfPath() == null) {
          statement.bindNull(73);
        } else {
          statement.bindString(73, entity.getPdfPath());
        }
      }
    };
    this.__deletionAdapterOfChecklist = new EntityDeletionOrUpdateAdapter<Checklist>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `checklists` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Checklist entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfChecklist = new EntityDeletionOrUpdateAdapter<Checklist>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `checklists` SET `id` = ?,`userId` = ?,`localColeta` = ?,`responsavel` = ?,`data` = ?,`placaCavalo` = ?,`placaCarreta` = ?,`motorista` = ?,`diDueCrtMicDta` = ?,`nfE` = ?,`lacreEntrada` = ?,`lacreSaida` = ?,`pesoBruto` = ?,`tipoViagem` = ?,`item1_parachoque` = ?,`item1_comentario` = ?,`item2_motor` = ?,`item2_comentario` = ?,`item3_pneus` = ?,`item3_comentario` = ?,`item4_unidadeTratora` = ?,`item4_comentario` = ?,`item5_tanquesCombustivel` = ?,`item5_comentario` = ?,`item6_cabine` = ?,`item6_comentario` = ?,`item7_eixoElevatorioAr` = ?,`item7_comentario` = ?,`item8_eixoTransmissao` = ?,`item8_comentario` = ?,`item9_areaQuintaRoda` = ?,`item9_comentario` = ?,`item10_sistemaExaustao` = ?,`item10_comentario` = ?,`item11_chassi` = ?,`item11_comentario` = ?,`item12_portasTraseira` = ?,`item12_comentario` = ?,`item13_portaLateralDireita` = ?,`item13_comentario` = ?,`item14_portaLateralEsquerda` = ?,`item14_comentario` = ?,`item15_paredeFrontal` = ?,`item15_comentario` = ?,`item16_teto` = ?,`item16_comentario` = ?,`item17_pisoCompartimentoCarga` = ?,`item17_comentario` = ?,`item18_dutosAr` = ?,`item18_comentario` = ?,`item19_motorCamaraFria` = ?,`item19_comentario` = ?,`odores` = ?,`odores_comentario` = ?,`pragasVisiveis` = ?,`pragas_comentario` = ?,`contaminacaoQuimica` = ?,`contaminacao_comentario` = ?,`fundoParedeFalsa` = ?,`fundoParede_comentario` = ?,`indiciosContaminacao` = ?,`indicios_comentario` = ?,`autoridadeNotificada` = ?,`dataHoraNotificacao` = ?,`autoridade_comentario` = ?,`itemEmDesacordo` = ?,`fotoItemDesacordoPath` = ?,`dataHoraTermino` = ?,`assinaturaVistoriador` = ?,`assinaturaMotorista` = ?,`timestamp` = ?,`status` = ?,`pdfPath` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Checklist entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getLocalColeta() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLocalColeta());
        }
        if (entity.getResponsavel() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getResponsavel());
        }
        if (entity.getData() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getData());
        }
        if (entity.getPlacaCavalo() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPlacaCavalo());
        }
        if (entity.getPlacaCarreta() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPlacaCarreta());
        }
        if (entity.getMotorista() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getMotorista());
        }
        if (entity.getDiDueCrtMicDta() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDiDueCrtMicDta());
        }
        if (entity.getNfE() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getNfE());
        }
        if (entity.getLacreEntrada() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getLacreEntrada());
        }
        if (entity.getLacreSaida() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getLacreSaida());
        }
        if (entity.getPesoBruto() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getPesoBruto());
        }
        if (entity.getTipoViagem() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getTipoViagem());
        }
        if (entity.getItem1_parachoque() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getItem1_parachoque());
        }
        if (entity.getItem1_comentario() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getItem1_comentario());
        }
        if (entity.getItem2_motor() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getItem2_motor());
        }
        if (entity.getItem2_comentario() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getItem2_comentario());
        }
        if (entity.getItem3_pneus() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getItem3_pneus());
        }
        if (entity.getItem3_comentario() == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, entity.getItem3_comentario());
        }
        if (entity.getItem4_unidadeTratora() == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, entity.getItem4_unidadeTratora());
        }
        if (entity.getItem4_comentario() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getItem4_comentario());
        }
        if (entity.getItem5_tanquesCombustivel() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getItem5_tanquesCombustivel());
        }
        if (entity.getItem5_comentario() == null) {
          statement.bindNull(24);
        } else {
          statement.bindString(24, entity.getItem5_comentario());
        }
        if (entity.getItem6_cabine() == null) {
          statement.bindNull(25);
        } else {
          statement.bindString(25, entity.getItem6_cabine());
        }
        if (entity.getItem6_comentario() == null) {
          statement.bindNull(26);
        } else {
          statement.bindString(26, entity.getItem6_comentario());
        }
        if (entity.getItem7_eixoElevatorioAr() == null) {
          statement.bindNull(27);
        } else {
          statement.bindString(27, entity.getItem7_eixoElevatorioAr());
        }
        if (entity.getItem7_comentario() == null) {
          statement.bindNull(28);
        } else {
          statement.bindString(28, entity.getItem7_comentario());
        }
        if (entity.getItem8_eixoTransmissao() == null) {
          statement.bindNull(29);
        } else {
          statement.bindString(29, entity.getItem8_eixoTransmissao());
        }
        if (entity.getItem8_comentario() == null) {
          statement.bindNull(30);
        } else {
          statement.bindString(30, entity.getItem8_comentario());
        }
        if (entity.getItem9_areaQuintaRoda() == null) {
          statement.bindNull(31);
        } else {
          statement.bindString(31, entity.getItem9_areaQuintaRoda());
        }
        if (entity.getItem9_comentario() == null) {
          statement.bindNull(32);
        } else {
          statement.bindString(32, entity.getItem9_comentario());
        }
        if (entity.getItem10_sistemaExaustao() == null) {
          statement.bindNull(33);
        } else {
          statement.bindString(33, entity.getItem10_sistemaExaustao());
        }
        if (entity.getItem10_comentario() == null) {
          statement.bindNull(34);
        } else {
          statement.bindString(34, entity.getItem10_comentario());
        }
        if (entity.getItem11_chassi() == null) {
          statement.bindNull(35);
        } else {
          statement.bindString(35, entity.getItem11_chassi());
        }
        if (entity.getItem11_comentario() == null) {
          statement.bindNull(36);
        } else {
          statement.bindString(36, entity.getItem11_comentario());
        }
        if (entity.getItem12_portasTraseira() == null) {
          statement.bindNull(37);
        } else {
          statement.bindString(37, entity.getItem12_portasTraseira());
        }
        if (entity.getItem12_comentario() == null) {
          statement.bindNull(38);
        } else {
          statement.bindString(38, entity.getItem12_comentario());
        }
        if (entity.getItem13_portaLateralDireita() == null) {
          statement.bindNull(39);
        } else {
          statement.bindString(39, entity.getItem13_portaLateralDireita());
        }
        if (entity.getItem13_comentario() == null) {
          statement.bindNull(40);
        } else {
          statement.bindString(40, entity.getItem13_comentario());
        }
        if (entity.getItem14_portaLateralEsquerda() == null) {
          statement.bindNull(41);
        } else {
          statement.bindString(41, entity.getItem14_portaLateralEsquerda());
        }
        if (entity.getItem14_comentario() == null) {
          statement.bindNull(42);
        } else {
          statement.bindString(42, entity.getItem14_comentario());
        }
        if (entity.getItem15_paredeFrontal() == null) {
          statement.bindNull(43);
        } else {
          statement.bindString(43, entity.getItem15_paredeFrontal());
        }
        if (entity.getItem15_comentario() == null) {
          statement.bindNull(44);
        } else {
          statement.bindString(44, entity.getItem15_comentario());
        }
        if (entity.getItem16_teto() == null) {
          statement.bindNull(45);
        } else {
          statement.bindString(45, entity.getItem16_teto());
        }
        if (entity.getItem16_comentario() == null) {
          statement.bindNull(46);
        } else {
          statement.bindString(46, entity.getItem16_comentario());
        }
        if (entity.getItem17_pisoCompartimentoCarga() == null) {
          statement.bindNull(47);
        } else {
          statement.bindString(47, entity.getItem17_pisoCompartimentoCarga());
        }
        if (entity.getItem17_comentario() == null) {
          statement.bindNull(48);
        } else {
          statement.bindString(48, entity.getItem17_comentario());
        }
        if (entity.getItem18_dutosAr() == null) {
          statement.bindNull(49);
        } else {
          statement.bindString(49, entity.getItem18_dutosAr());
        }
        if (entity.getItem18_comentario() == null) {
          statement.bindNull(50);
        } else {
          statement.bindString(50, entity.getItem18_comentario());
        }
        if (entity.getItem19_motorCamaraFria() == null) {
          statement.bindNull(51);
        } else {
          statement.bindString(51, entity.getItem19_motorCamaraFria());
        }
        if (entity.getItem19_comentario() == null) {
          statement.bindNull(52);
        } else {
          statement.bindString(52, entity.getItem19_comentario());
        }
        if (entity.getOdores() == null) {
          statement.bindNull(53);
        } else {
          statement.bindString(53, entity.getOdores());
        }
        if (entity.getOdores_comentario() == null) {
          statement.bindNull(54);
        } else {
          statement.bindString(54, entity.getOdores_comentario());
        }
        if (entity.getPragasVisiveis() == null) {
          statement.bindNull(55);
        } else {
          statement.bindString(55, entity.getPragasVisiveis());
        }
        if (entity.getPragas_comentario() == null) {
          statement.bindNull(56);
        } else {
          statement.bindString(56, entity.getPragas_comentario());
        }
        if (entity.getContaminacaoQuimica() == null) {
          statement.bindNull(57);
        } else {
          statement.bindString(57, entity.getContaminacaoQuimica());
        }
        if (entity.getContaminacao_comentario() == null) {
          statement.bindNull(58);
        } else {
          statement.bindString(58, entity.getContaminacao_comentario());
        }
        if (entity.getFundoParedeFalsa() == null) {
          statement.bindNull(59);
        } else {
          statement.bindString(59, entity.getFundoParedeFalsa());
        }
        if (entity.getFundoParede_comentario() == null) {
          statement.bindNull(60);
        } else {
          statement.bindString(60, entity.getFundoParede_comentario());
        }
        if (entity.getIndiciosContaminacao() == null) {
          statement.bindNull(61);
        } else {
          statement.bindString(61, entity.getIndiciosContaminacao());
        }
        if (entity.getIndicios_comentario() == null) {
          statement.bindNull(62);
        } else {
          statement.bindString(62, entity.getIndicios_comentario());
        }
        final Integer _tmp = entity.getAutoridadeNotificada() == null ? null : (entity.getAutoridadeNotificada() ? 1 : 0);
        if (_tmp == null) {
          statement.bindNull(63);
        } else {
          statement.bindLong(63, _tmp);
        }
        if (entity.getDataHoraNotificacao() == null) {
          statement.bindNull(64);
        } else {
          statement.bindString(64, entity.getDataHoraNotificacao());
        }
        if (entity.getAutoridade_comentario() == null) {
          statement.bindNull(65);
        } else {
          statement.bindString(65, entity.getAutoridade_comentario());
        }
        final int _tmp_1 = entity.getItemEmDesacordo() ? 1 : 0;
        statement.bindLong(66, _tmp_1);
        if (entity.getFotoItemDesacordoPath() == null) {
          statement.bindNull(67);
        } else {
          statement.bindString(67, entity.getFotoItemDesacordoPath());
        }
        if (entity.getDataHoraTermino() == null) {
          statement.bindNull(68);
        } else {
          statement.bindString(68, entity.getDataHoraTermino());
        }
        if (entity.getAssinaturaVistoriador() == null) {
          statement.bindNull(69);
        } else {
          statement.bindString(69, entity.getAssinaturaVistoriador());
        }
        if (entity.getAssinaturaMotorista() == null) {
          statement.bindNull(70);
        } else {
          statement.bindString(70, entity.getAssinaturaMotorista());
        }
        statement.bindLong(71, entity.getTimestamp());
        statement.bindString(72, entity.getStatus());
        if (entity.getPdfPath() == null) {
          statement.bindNull(73);
        } else {
          statement.bindString(73, entity.getPdfPath());
        }
        statement.bindLong(74, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE checklists SET status = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePdfPath = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE checklists SET pdfPath = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertOrUpdate(final Checklist checklist,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfChecklist.insertAndReturnId(checklist);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Checklist checklist, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfChecklist.handle(checklist);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Checklist checklist, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfChecklist.handle(checklist);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStatus(final long id, final String newStatus,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatus.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, newStatus);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePdfPath(final long id, final String pdfPath,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePdfPath.acquire();
        int _argIndex = 1;
        if (pdfPath == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, pdfPath);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdatePdfPath.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getChecklistById(final long id, final Continuation<? super Checklist> $completion) {
    final String _sql = "SELECT * FROM checklists WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Checklist>() {
      @Override
      @Nullable
      public Checklist call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfLocalColeta = CursorUtil.getColumnIndexOrThrow(_cursor, "localColeta");
          final int _cursorIndexOfResponsavel = CursorUtil.getColumnIndexOrThrow(_cursor, "responsavel");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfPlacaCavalo = CursorUtil.getColumnIndexOrThrow(_cursor, "placaCavalo");
          final int _cursorIndexOfPlacaCarreta = CursorUtil.getColumnIndexOrThrow(_cursor, "placaCarreta");
          final int _cursorIndexOfMotorista = CursorUtil.getColumnIndexOrThrow(_cursor, "motorista");
          final int _cursorIndexOfDiDueCrtMicDta = CursorUtil.getColumnIndexOrThrow(_cursor, "diDueCrtMicDta");
          final int _cursorIndexOfNfE = CursorUtil.getColumnIndexOrThrow(_cursor, "nfE");
          final int _cursorIndexOfLacreEntrada = CursorUtil.getColumnIndexOrThrow(_cursor, "lacreEntrada");
          final int _cursorIndexOfLacreSaida = CursorUtil.getColumnIndexOrThrow(_cursor, "lacreSaida");
          final int _cursorIndexOfPesoBruto = CursorUtil.getColumnIndexOrThrow(_cursor, "pesoBruto");
          final int _cursorIndexOfTipoViagem = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoViagem");
          final int _cursorIndexOfItem1Parachoque = CursorUtil.getColumnIndexOrThrow(_cursor, "item1_parachoque");
          final int _cursorIndexOfItem1Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item1_comentario");
          final int _cursorIndexOfItem2Motor = CursorUtil.getColumnIndexOrThrow(_cursor, "item2_motor");
          final int _cursorIndexOfItem2Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item2_comentario");
          final int _cursorIndexOfItem3Pneus = CursorUtil.getColumnIndexOrThrow(_cursor, "item3_pneus");
          final int _cursorIndexOfItem3Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item3_comentario");
          final int _cursorIndexOfItem4UnidadeTratora = CursorUtil.getColumnIndexOrThrow(_cursor, "item4_unidadeTratora");
          final int _cursorIndexOfItem4Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item4_comentario");
          final int _cursorIndexOfItem5TanquesCombustivel = CursorUtil.getColumnIndexOrThrow(_cursor, "item5_tanquesCombustivel");
          final int _cursorIndexOfItem5Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item5_comentario");
          final int _cursorIndexOfItem6Cabine = CursorUtil.getColumnIndexOrThrow(_cursor, "item6_cabine");
          final int _cursorIndexOfItem6Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item6_comentario");
          final int _cursorIndexOfItem7EixoElevatorioAr = CursorUtil.getColumnIndexOrThrow(_cursor, "item7_eixoElevatorioAr");
          final int _cursorIndexOfItem7Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item7_comentario");
          final int _cursorIndexOfItem8EixoTransmissao = CursorUtil.getColumnIndexOrThrow(_cursor, "item8_eixoTransmissao");
          final int _cursorIndexOfItem8Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item8_comentario");
          final int _cursorIndexOfItem9AreaQuintaRoda = CursorUtil.getColumnIndexOrThrow(_cursor, "item9_areaQuintaRoda");
          final int _cursorIndexOfItem9Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item9_comentario");
          final int _cursorIndexOfItem10SistemaExaustao = CursorUtil.getColumnIndexOrThrow(_cursor, "item10_sistemaExaustao");
          final int _cursorIndexOfItem10Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item10_comentario");
          final int _cursorIndexOfItem11Chassi = CursorUtil.getColumnIndexOrThrow(_cursor, "item11_chassi");
          final int _cursorIndexOfItem11Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item11_comentario");
          final int _cursorIndexOfItem12PortasTraseira = CursorUtil.getColumnIndexOrThrow(_cursor, "item12_portasTraseira");
          final int _cursorIndexOfItem12Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item12_comentario");
          final int _cursorIndexOfItem13PortaLateralDireita = CursorUtil.getColumnIndexOrThrow(_cursor, "item13_portaLateralDireita");
          final int _cursorIndexOfItem13Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item13_comentario");
          final int _cursorIndexOfItem14PortaLateralEsquerda = CursorUtil.getColumnIndexOrThrow(_cursor, "item14_portaLateralEsquerda");
          final int _cursorIndexOfItem14Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item14_comentario");
          final int _cursorIndexOfItem15ParedeFrontal = CursorUtil.getColumnIndexOrThrow(_cursor, "item15_paredeFrontal");
          final int _cursorIndexOfItem15Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item15_comentario");
          final int _cursorIndexOfItem16Teto = CursorUtil.getColumnIndexOrThrow(_cursor, "item16_teto");
          final int _cursorIndexOfItem16Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item16_comentario");
          final int _cursorIndexOfItem17PisoCompartimentoCarga = CursorUtil.getColumnIndexOrThrow(_cursor, "item17_pisoCompartimentoCarga");
          final int _cursorIndexOfItem17Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item17_comentario");
          final int _cursorIndexOfItem18DutosAr = CursorUtil.getColumnIndexOrThrow(_cursor, "item18_dutosAr");
          final int _cursorIndexOfItem18Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item18_comentario");
          final int _cursorIndexOfItem19MotorCamaraFria = CursorUtil.getColumnIndexOrThrow(_cursor, "item19_motorCamaraFria");
          final int _cursorIndexOfItem19Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item19_comentario");
          final int _cursorIndexOfOdores = CursorUtil.getColumnIndexOrThrow(_cursor, "odores");
          final int _cursorIndexOfOdoresComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "odores_comentario");
          final int _cursorIndexOfPragasVisiveis = CursorUtil.getColumnIndexOrThrow(_cursor, "pragasVisiveis");
          final int _cursorIndexOfPragasComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "pragas_comentario");
          final int _cursorIndexOfContaminacaoQuimica = CursorUtil.getColumnIndexOrThrow(_cursor, "contaminacaoQuimica");
          final int _cursorIndexOfContaminacaoComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "contaminacao_comentario");
          final int _cursorIndexOfFundoParedeFalsa = CursorUtil.getColumnIndexOrThrow(_cursor, "fundoParedeFalsa");
          final int _cursorIndexOfFundoParedeComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "fundoParede_comentario");
          final int _cursorIndexOfIndiciosContaminacao = CursorUtil.getColumnIndexOrThrow(_cursor, "indiciosContaminacao");
          final int _cursorIndexOfIndiciosComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "indicios_comentario");
          final int _cursorIndexOfAutoridadeNotificada = CursorUtil.getColumnIndexOrThrow(_cursor, "autoridadeNotificada");
          final int _cursorIndexOfDataHoraNotificacao = CursorUtil.getColumnIndexOrThrow(_cursor, "dataHoraNotificacao");
          final int _cursorIndexOfAutoridadeComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "autoridade_comentario");
          final int _cursorIndexOfItemEmDesacordo = CursorUtil.getColumnIndexOrThrow(_cursor, "itemEmDesacordo");
          final int _cursorIndexOfFotoItemDesacordoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoItemDesacordoPath");
          final int _cursorIndexOfDataHoraTermino = CursorUtil.getColumnIndexOrThrow(_cursor, "dataHoraTermino");
          final int _cursorIndexOfAssinaturaVistoriador = CursorUtil.getColumnIndexOrThrow(_cursor, "assinaturaVistoriador");
          final int _cursorIndexOfAssinaturaMotorista = CursorUtil.getColumnIndexOrThrow(_cursor, "assinaturaMotorista");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPdfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "pdfPath");
          final Checklist _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpUserId;
            _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
            final String _tmpLocalColeta;
            if (_cursor.isNull(_cursorIndexOfLocalColeta)) {
              _tmpLocalColeta = null;
            } else {
              _tmpLocalColeta = _cursor.getString(_cursorIndexOfLocalColeta);
            }
            final String _tmpResponsavel;
            if (_cursor.isNull(_cursorIndexOfResponsavel)) {
              _tmpResponsavel = null;
            } else {
              _tmpResponsavel = _cursor.getString(_cursorIndexOfResponsavel);
            }
            final String _tmpData;
            if (_cursor.isNull(_cursorIndexOfData)) {
              _tmpData = null;
            } else {
              _tmpData = _cursor.getString(_cursorIndexOfData);
            }
            final String _tmpPlacaCavalo;
            if (_cursor.isNull(_cursorIndexOfPlacaCavalo)) {
              _tmpPlacaCavalo = null;
            } else {
              _tmpPlacaCavalo = _cursor.getString(_cursorIndexOfPlacaCavalo);
            }
            final String _tmpPlacaCarreta;
            if (_cursor.isNull(_cursorIndexOfPlacaCarreta)) {
              _tmpPlacaCarreta = null;
            } else {
              _tmpPlacaCarreta = _cursor.getString(_cursorIndexOfPlacaCarreta);
            }
            final String _tmpMotorista;
            if (_cursor.isNull(_cursorIndexOfMotorista)) {
              _tmpMotorista = null;
            } else {
              _tmpMotorista = _cursor.getString(_cursorIndexOfMotorista);
            }
            final String _tmpDiDueCrtMicDta;
            if (_cursor.isNull(_cursorIndexOfDiDueCrtMicDta)) {
              _tmpDiDueCrtMicDta = null;
            } else {
              _tmpDiDueCrtMicDta = _cursor.getString(_cursorIndexOfDiDueCrtMicDta);
            }
            final String _tmpNfE;
            if (_cursor.isNull(_cursorIndexOfNfE)) {
              _tmpNfE = null;
            } else {
              _tmpNfE = _cursor.getString(_cursorIndexOfNfE);
            }
            final String _tmpLacreEntrada;
            if (_cursor.isNull(_cursorIndexOfLacreEntrada)) {
              _tmpLacreEntrada = null;
            } else {
              _tmpLacreEntrada = _cursor.getString(_cursorIndexOfLacreEntrada);
            }
            final String _tmpLacreSaida;
            if (_cursor.isNull(_cursorIndexOfLacreSaida)) {
              _tmpLacreSaida = null;
            } else {
              _tmpLacreSaida = _cursor.getString(_cursorIndexOfLacreSaida);
            }
            final String _tmpPesoBruto;
            if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
              _tmpPesoBruto = null;
            } else {
              _tmpPesoBruto = _cursor.getString(_cursorIndexOfPesoBruto);
            }
            final String _tmpTipoViagem;
            if (_cursor.isNull(_cursorIndexOfTipoViagem)) {
              _tmpTipoViagem = null;
            } else {
              _tmpTipoViagem = _cursor.getString(_cursorIndexOfTipoViagem);
            }
            final String _tmpItem1_parachoque;
            if (_cursor.isNull(_cursorIndexOfItem1Parachoque)) {
              _tmpItem1_parachoque = null;
            } else {
              _tmpItem1_parachoque = _cursor.getString(_cursorIndexOfItem1Parachoque);
            }
            final String _tmpItem1_comentario;
            if (_cursor.isNull(_cursorIndexOfItem1Comentario)) {
              _tmpItem1_comentario = null;
            } else {
              _tmpItem1_comentario = _cursor.getString(_cursorIndexOfItem1Comentario);
            }
            final String _tmpItem2_motor;
            if (_cursor.isNull(_cursorIndexOfItem2Motor)) {
              _tmpItem2_motor = null;
            } else {
              _tmpItem2_motor = _cursor.getString(_cursorIndexOfItem2Motor);
            }
            final String _tmpItem2_comentario;
            if (_cursor.isNull(_cursorIndexOfItem2Comentario)) {
              _tmpItem2_comentario = null;
            } else {
              _tmpItem2_comentario = _cursor.getString(_cursorIndexOfItem2Comentario);
            }
            final String _tmpItem3_pneus;
            if (_cursor.isNull(_cursorIndexOfItem3Pneus)) {
              _tmpItem3_pneus = null;
            } else {
              _tmpItem3_pneus = _cursor.getString(_cursorIndexOfItem3Pneus);
            }
            final String _tmpItem3_comentario;
            if (_cursor.isNull(_cursorIndexOfItem3Comentario)) {
              _tmpItem3_comentario = null;
            } else {
              _tmpItem3_comentario = _cursor.getString(_cursorIndexOfItem3Comentario);
            }
            final String _tmpItem4_unidadeTratora;
            if (_cursor.isNull(_cursorIndexOfItem4UnidadeTratora)) {
              _tmpItem4_unidadeTratora = null;
            } else {
              _tmpItem4_unidadeTratora = _cursor.getString(_cursorIndexOfItem4UnidadeTratora);
            }
            final String _tmpItem4_comentario;
            if (_cursor.isNull(_cursorIndexOfItem4Comentario)) {
              _tmpItem4_comentario = null;
            } else {
              _tmpItem4_comentario = _cursor.getString(_cursorIndexOfItem4Comentario);
            }
            final String _tmpItem5_tanquesCombustivel;
            if (_cursor.isNull(_cursorIndexOfItem5TanquesCombustivel)) {
              _tmpItem5_tanquesCombustivel = null;
            } else {
              _tmpItem5_tanquesCombustivel = _cursor.getString(_cursorIndexOfItem5TanquesCombustivel);
            }
            final String _tmpItem5_comentario;
            if (_cursor.isNull(_cursorIndexOfItem5Comentario)) {
              _tmpItem5_comentario = null;
            } else {
              _tmpItem5_comentario = _cursor.getString(_cursorIndexOfItem5Comentario);
            }
            final String _tmpItem6_cabine;
            if (_cursor.isNull(_cursorIndexOfItem6Cabine)) {
              _tmpItem6_cabine = null;
            } else {
              _tmpItem6_cabine = _cursor.getString(_cursorIndexOfItem6Cabine);
            }
            final String _tmpItem6_comentario;
            if (_cursor.isNull(_cursorIndexOfItem6Comentario)) {
              _tmpItem6_comentario = null;
            } else {
              _tmpItem6_comentario = _cursor.getString(_cursorIndexOfItem6Comentario);
            }
            final String _tmpItem7_eixoElevatorioAr;
            if (_cursor.isNull(_cursorIndexOfItem7EixoElevatorioAr)) {
              _tmpItem7_eixoElevatorioAr = null;
            } else {
              _tmpItem7_eixoElevatorioAr = _cursor.getString(_cursorIndexOfItem7EixoElevatorioAr);
            }
            final String _tmpItem7_comentario;
            if (_cursor.isNull(_cursorIndexOfItem7Comentario)) {
              _tmpItem7_comentario = null;
            } else {
              _tmpItem7_comentario = _cursor.getString(_cursorIndexOfItem7Comentario);
            }
            final String _tmpItem8_eixoTransmissao;
            if (_cursor.isNull(_cursorIndexOfItem8EixoTransmissao)) {
              _tmpItem8_eixoTransmissao = null;
            } else {
              _tmpItem8_eixoTransmissao = _cursor.getString(_cursorIndexOfItem8EixoTransmissao);
            }
            final String _tmpItem8_comentario;
            if (_cursor.isNull(_cursorIndexOfItem8Comentario)) {
              _tmpItem8_comentario = null;
            } else {
              _tmpItem8_comentario = _cursor.getString(_cursorIndexOfItem8Comentario);
            }
            final String _tmpItem9_areaQuintaRoda;
            if (_cursor.isNull(_cursorIndexOfItem9AreaQuintaRoda)) {
              _tmpItem9_areaQuintaRoda = null;
            } else {
              _tmpItem9_areaQuintaRoda = _cursor.getString(_cursorIndexOfItem9AreaQuintaRoda);
            }
            final String _tmpItem9_comentario;
            if (_cursor.isNull(_cursorIndexOfItem9Comentario)) {
              _tmpItem9_comentario = null;
            } else {
              _tmpItem9_comentario = _cursor.getString(_cursorIndexOfItem9Comentario);
            }
            final String _tmpItem10_sistemaExaustao;
            if (_cursor.isNull(_cursorIndexOfItem10SistemaExaustao)) {
              _tmpItem10_sistemaExaustao = null;
            } else {
              _tmpItem10_sistemaExaustao = _cursor.getString(_cursorIndexOfItem10SistemaExaustao);
            }
            final String _tmpItem10_comentario;
            if (_cursor.isNull(_cursorIndexOfItem10Comentario)) {
              _tmpItem10_comentario = null;
            } else {
              _tmpItem10_comentario = _cursor.getString(_cursorIndexOfItem10Comentario);
            }
            final String _tmpItem11_chassi;
            if (_cursor.isNull(_cursorIndexOfItem11Chassi)) {
              _tmpItem11_chassi = null;
            } else {
              _tmpItem11_chassi = _cursor.getString(_cursorIndexOfItem11Chassi);
            }
            final String _tmpItem11_comentario;
            if (_cursor.isNull(_cursorIndexOfItem11Comentario)) {
              _tmpItem11_comentario = null;
            } else {
              _tmpItem11_comentario = _cursor.getString(_cursorIndexOfItem11Comentario);
            }
            final String _tmpItem12_portasTraseira;
            if (_cursor.isNull(_cursorIndexOfItem12PortasTraseira)) {
              _tmpItem12_portasTraseira = null;
            } else {
              _tmpItem12_portasTraseira = _cursor.getString(_cursorIndexOfItem12PortasTraseira);
            }
            final String _tmpItem12_comentario;
            if (_cursor.isNull(_cursorIndexOfItem12Comentario)) {
              _tmpItem12_comentario = null;
            } else {
              _tmpItem12_comentario = _cursor.getString(_cursorIndexOfItem12Comentario);
            }
            final String _tmpItem13_portaLateralDireita;
            if (_cursor.isNull(_cursorIndexOfItem13PortaLateralDireita)) {
              _tmpItem13_portaLateralDireita = null;
            } else {
              _tmpItem13_portaLateralDireita = _cursor.getString(_cursorIndexOfItem13PortaLateralDireita);
            }
            final String _tmpItem13_comentario;
            if (_cursor.isNull(_cursorIndexOfItem13Comentario)) {
              _tmpItem13_comentario = null;
            } else {
              _tmpItem13_comentario = _cursor.getString(_cursorIndexOfItem13Comentario);
            }
            final String _tmpItem14_portaLateralEsquerda;
            if (_cursor.isNull(_cursorIndexOfItem14PortaLateralEsquerda)) {
              _tmpItem14_portaLateralEsquerda = null;
            } else {
              _tmpItem14_portaLateralEsquerda = _cursor.getString(_cursorIndexOfItem14PortaLateralEsquerda);
            }
            final String _tmpItem14_comentario;
            if (_cursor.isNull(_cursorIndexOfItem14Comentario)) {
              _tmpItem14_comentario = null;
            } else {
              _tmpItem14_comentario = _cursor.getString(_cursorIndexOfItem14Comentario);
            }
            final String _tmpItem15_paredeFrontal;
            if (_cursor.isNull(_cursorIndexOfItem15ParedeFrontal)) {
              _tmpItem15_paredeFrontal = null;
            } else {
              _tmpItem15_paredeFrontal = _cursor.getString(_cursorIndexOfItem15ParedeFrontal);
            }
            final String _tmpItem15_comentario;
            if (_cursor.isNull(_cursorIndexOfItem15Comentario)) {
              _tmpItem15_comentario = null;
            } else {
              _tmpItem15_comentario = _cursor.getString(_cursorIndexOfItem15Comentario);
            }
            final String _tmpItem16_teto;
            if (_cursor.isNull(_cursorIndexOfItem16Teto)) {
              _tmpItem16_teto = null;
            } else {
              _tmpItem16_teto = _cursor.getString(_cursorIndexOfItem16Teto);
            }
            final String _tmpItem16_comentario;
            if (_cursor.isNull(_cursorIndexOfItem16Comentario)) {
              _tmpItem16_comentario = null;
            } else {
              _tmpItem16_comentario = _cursor.getString(_cursorIndexOfItem16Comentario);
            }
            final String _tmpItem17_pisoCompartimentoCarga;
            if (_cursor.isNull(_cursorIndexOfItem17PisoCompartimentoCarga)) {
              _tmpItem17_pisoCompartimentoCarga = null;
            } else {
              _tmpItem17_pisoCompartimentoCarga = _cursor.getString(_cursorIndexOfItem17PisoCompartimentoCarga);
            }
            final String _tmpItem17_comentario;
            if (_cursor.isNull(_cursorIndexOfItem17Comentario)) {
              _tmpItem17_comentario = null;
            } else {
              _tmpItem17_comentario = _cursor.getString(_cursorIndexOfItem17Comentario);
            }
            final String _tmpItem18_dutosAr;
            if (_cursor.isNull(_cursorIndexOfItem18DutosAr)) {
              _tmpItem18_dutosAr = null;
            } else {
              _tmpItem18_dutosAr = _cursor.getString(_cursorIndexOfItem18DutosAr);
            }
            final String _tmpItem18_comentario;
            if (_cursor.isNull(_cursorIndexOfItem18Comentario)) {
              _tmpItem18_comentario = null;
            } else {
              _tmpItem18_comentario = _cursor.getString(_cursorIndexOfItem18Comentario);
            }
            final String _tmpItem19_motorCamaraFria;
            if (_cursor.isNull(_cursorIndexOfItem19MotorCamaraFria)) {
              _tmpItem19_motorCamaraFria = null;
            } else {
              _tmpItem19_motorCamaraFria = _cursor.getString(_cursorIndexOfItem19MotorCamaraFria);
            }
            final String _tmpItem19_comentario;
            if (_cursor.isNull(_cursorIndexOfItem19Comentario)) {
              _tmpItem19_comentario = null;
            } else {
              _tmpItem19_comentario = _cursor.getString(_cursorIndexOfItem19Comentario);
            }
            final String _tmpOdores;
            if (_cursor.isNull(_cursorIndexOfOdores)) {
              _tmpOdores = null;
            } else {
              _tmpOdores = _cursor.getString(_cursorIndexOfOdores);
            }
            final String _tmpOdores_comentario;
            if (_cursor.isNull(_cursorIndexOfOdoresComentario)) {
              _tmpOdores_comentario = null;
            } else {
              _tmpOdores_comentario = _cursor.getString(_cursorIndexOfOdoresComentario);
            }
            final String _tmpPragasVisiveis;
            if (_cursor.isNull(_cursorIndexOfPragasVisiveis)) {
              _tmpPragasVisiveis = null;
            } else {
              _tmpPragasVisiveis = _cursor.getString(_cursorIndexOfPragasVisiveis);
            }
            final String _tmpPragas_comentario;
            if (_cursor.isNull(_cursorIndexOfPragasComentario)) {
              _tmpPragas_comentario = null;
            } else {
              _tmpPragas_comentario = _cursor.getString(_cursorIndexOfPragasComentario);
            }
            final String _tmpContaminacaoQuimica;
            if (_cursor.isNull(_cursorIndexOfContaminacaoQuimica)) {
              _tmpContaminacaoQuimica = null;
            } else {
              _tmpContaminacaoQuimica = _cursor.getString(_cursorIndexOfContaminacaoQuimica);
            }
            final String _tmpContaminacao_comentario;
            if (_cursor.isNull(_cursorIndexOfContaminacaoComentario)) {
              _tmpContaminacao_comentario = null;
            } else {
              _tmpContaminacao_comentario = _cursor.getString(_cursorIndexOfContaminacaoComentario);
            }
            final String _tmpFundoParedeFalsa;
            if (_cursor.isNull(_cursorIndexOfFundoParedeFalsa)) {
              _tmpFundoParedeFalsa = null;
            } else {
              _tmpFundoParedeFalsa = _cursor.getString(_cursorIndexOfFundoParedeFalsa);
            }
            final String _tmpFundoParede_comentario;
            if (_cursor.isNull(_cursorIndexOfFundoParedeComentario)) {
              _tmpFundoParede_comentario = null;
            } else {
              _tmpFundoParede_comentario = _cursor.getString(_cursorIndexOfFundoParedeComentario);
            }
            final String _tmpIndiciosContaminacao;
            if (_cursor.isNull(_cursorIndexOfIndiciosContaminacao)) {
              _tmpIndiciosContaminacao = null;
            } else {
              _tmpIndiciosContaminacao = _cursor.getString(_cursorIndexOfIndiciosContaminacao);
            }
            final String _tmpIndicios_comentario;
            if (_cursor.isNull(_cursorIndexOfIndiciosComentario)) {
              _tmpIndicios_comentario = null;
            } else {
              _tmpIndicios_comentario = _cursor.getString(_cursorIndexOfIndiciosComentario);
            }
            final Boolean _tmpAutoridadeNotificada;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfAutoridadeNotificada)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfAutoridadeNotificada);
            }
            _tmpAutoridadeNotificada = _tmp == null ? null : _tmp != 0;
            final String _tmpDataHoraNotificacao;
            if (_cursor.isNull(_cursorIndexOfDataHoraNotificacao)) {
              _tmpDataHoraNotificacao = null;
            } else {
              _tmpDataHoraNotificacao = _cursor.getString(_cursorIndexOfDataHoraNotificacao);
            }
            final String _tmpAutoridade_comentario;
            if (_cursor.isNull(_cursorIndexOfAutoridadeComentario)) {
              _tmpAutoridade_comentario = null;
            } else {
              _tmpAutoridade_comentario = _cursor.getString(_cursorIndexOfAutoridadeComentario);
            }
            final boolean _tmpItemEmDesacordo;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfItemEmDesacordo);
            _tmpItemEmDesacordo = _tmp_1 != 0;
            final String _tmpFotoItemDesacordoPath;
            if (_cursor.isNull(_cursorIndexOfFotoItemDesacordoPath)) {
              _tmpFotoItemDesacordoPath = null;
            } else {
              _tmpFotoItemDesacordoPath = _cursor.getString(_cursorIndexOfFotoItemDesacordoPath);
            }
            final String _tmpDataHoraTermino;
            if (_cursor.isNull(_cursorIndexOfDataHoraTermino)) {
              _tmpDataHoraTermino = null;
            } else {
              _tmpDataHoraTermino = _cursor.getString(_cursorIndexOfDataHoraTermino);
            }
            final String _tmpAssinaturaVistoriador;
            if (_cursor.isNull(_cursorIndexOfAssinaturaVistoriador)) {
              _tmpAssinaturaVistoriador = null;
            } else {
              _tmpAssinaturaVistoriador = _cursor.getString(_cursorIndexOfAssinaturaVistoriador);
            }
            final String _tmpAssinaturaMotorista;
            if (_cursor.isNull(_cursorIndexOfAssinaturaMotorista)) {
              _tmpAssinaturaMotorista = null;
            } else {
              _tmpAssinaturaMotorista = _cursor.getString(_cursorIndexOfAssinaturaMotorista);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPdfPath;
            if (_cursor.isNull(_cursorIndexOfPdfPath)) {
              _tmpPdfPath = null;
            } else {
              _tmpPdfPath = _cursor.getString(_cursorIndexOfPdfPath);
            }
            _result = new Checklist(_tmpId,_tmpUserId,_tmpLocalColeta,_tmpResponsavel,_tmpData,_tmpPlacaCavalo,_tmpPlacaCarreta,_tmpMotorista,_tmpDiDueCrtMicDta,_tmpNfE,_tmpLacreEntrada,_tmpLacreSaida,_tmpPesoBruto,_tmpTipoViagem,_tmpItem1_parachoque,_tmpItem1_comentario,_tmpItem2_motor,_tmpItem2_comentario,_tmpItem3_pneus,_tmpItem3_comentario,_tmpItem4_unidadeTratora,_tmpItem4_comentario,_tmpItem5_tanquesCombustivel,_tmpItem5_comentario,_tmpItem6_cabine,_tmpItem6_comentario,_tmpItem7_eixoElevatorioAr,_tmpItem7_comentario,_tmpItem8_eixoTransmissao,_tmpItem8_comentario,_tmpItem9_areaQuintaRoda,_tmpItem9_comentario,_tmpItem10_sistemaExaustao,_tmpItem10_comentario,_tmpItem11_chassi,_tmpItem11_comentario,_tmpItem12_portasTraseira,_tmpItem12_comentario,_tmpItem13_portaLateralDireita,_tmpItem13_comentario,_tmpItem14_portaLateralEsquerda,_tmpItem14_comentario,_tmpItem15_paredeFrontal,_tmpItem15_comentario,_tmpItem16_teto,_tmpItem16_comentario,_tmpItem17_pisoCompartimentoCarga,_tmpItem17_comentario,_tmpItem18_dutosAr,_tmpItem18_comentario,_tmpItem19_motorCamaraFria,_tmpItem19_comentario,_tmpOdores,_tmpOdores_comentario,_tmpPragasVisiveis,_tmpPragas_comentario,_tmpContaminacaoQuimica,_tmpContaminacao_comentario,_tmpFundoParedeFalsa,_tmpFundoParede_comentario,_tmpIndiciosContaminacao,_tmpIndicios_comentario,_tmpAutoridadeNotificada,_tmpDataHoraNotificacao,_tmpAutoridade_comentario,_tmpItemEmDesacordo,_tmpFotoItemDesacordoPath,_tmpDataHoraTermino,_tmpAssinaturaVistoriador,_tmpAssinaturaMotorista,_tmpTimestamp,_tmpStatus,_tmpPdfPath);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Checklist>> getAllChecklists() {
    final String _sql = "SELECT * FROM checklists ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"checklists"}, new Callable<List<Checklist>>() {
      @Override
      @NonNull
      public List<Checklist> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfLocalColeta = CursorUtil.getColumnIndexOrThrow(_cursor, "localColeta");
          final int _cursorIndexOfResponsavel = CursorUtil.getColumnIndexOrThrow(_cursor, "responsavel");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfPlacaCavalo = CursorUtil.getColumnIndexOrThrow(_cursor, "placaCavalo");
          final int _cursorIndexOfPlacaCarreta = CursorUtil.getColumnIndexOrThrow(_cursor, "placaCarreta");
          final int _cursorIndexOfMotorista = CursorUtil.getColumnIndexOrThrow(_cursor, "motorista");
          final int _cursorIndexOfDiDueCrtMicDta = CursorUtil.getColumnIndexOrThrow(_cursor, "diDueCrtMicDta");
          final int _cursorIndexOfNfE = CursorUtil.getColumnIndexOrThrow(_cursor, "nfE");
          final int _cursorIndexOfLacreEntrada = CursorUtil.getColumnIndexOrThrow(_cursor, "lacreEntrada");
          final int _cursorIndexOfLacreSaida = CursorUtil.getColumnIndexOrThrow(_cursor, "lacreSaida");
          final int _cursorIndexOfPesoBruto = CursorUtil.getColumnIndexOrThrow(_cursor, "pesoBruto");
          final int _cursorIndexOfTipoViagem = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoViagem");
          final int _cursorIndexOfItem1Parachoque = CursorUtil.getColumnIndexOrThrow(_cursor, "item1_parachoque");
          final int _cursorIndexOfItem1Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item1_comentario");
          final int _cursorIndexOfItem2Motor = CursorUtil.getColumnIndexOrThrow(_cursor, "item2_motor");
          final int _cursorIndexOfItem2Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item2_comentario");
          final int _cursorIndexOfItem3Pneus = CursorUtil.getColumnIndexOrThrow(_cursor, "item3_pneus");
          final int _cursorIndexOfItem3Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item3_comentario");
          final int _cursorIndexOfItem4UnidadeTratora = CursorUtil.getColumnIndexOrThrow(_cursor, "item4_unidadeTratora");
          final int _cursorIndexOfItem4Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item4_comentario");
          final int _cursorIndexOfItem5TanquesCombustivel = CursorUtil.getColumnIndexOrThrow(_cursor, "item5_tanquesCombustivel");
          final int _cursorIndexOfItem5Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item5_comentario");
          final int _cursorIndexOfItem6Cabine = CursorUtil.getColumnIndexOrThrow(_cursor, "item6_cabine");
          final int _cursorIndexOfItem6Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item6_comentario");
          final int _cursorIndexOfItem7EixoElevatorioAr = CursorUtil.getColumnIndexOrThrow(_cursor, "item7_eixoElevatorioAr");
          final int _cursorIndexOfItem7Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item7_comentario");
          final int _cursorIndexOfItem8EixoTransmissao = CursorUtil.getColumnIndexOrThrow(_cursor, "item8_eixoTransmissao");
          final int _cursorIndexOfItem8Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item8_comentario");
          final int _cursorIndexOfItem9AreaQuintaRoda = CursorUtil.getColumnIndexOrThrow(_cursor, "item9_areaQuintaRoda");
          final int _cursorIndexOfItem9Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item9_comentario");
          final int _cursorIndexOfItem10SistemaExaustao = CursorUtil.getColumnIndexOrThrow(_cursor, "item10_sistemaExaustao");
          final int _cursorIndexOfItem10Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item10_comentario");
          final int _cursorIndexOfItem11Chassi = CursorUtil.getColumnIndexOrThrow(_cursor, "item11_chassi");
          final int _cursorIndexOfItem11Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item11_comentario");
          final int _cursorIndexOfItem12PortasTraseira = CursorUtil.getColumnIndexOrThrow(_cursor, "item12_portasTraseira");
          final int _cursorIndexOfItem12Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item12_comentario");
          final int _cursorIndexOfItem13PortaLateralDireita = CursorUtil.getColumnIndexOrThrow(_cursor, "item13_portaLateralDireita");
          final int _cursorIndexOfItem13Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item13_comentario");
          final int _cursorIndexOfItem14PortaLateralEsquerda = CursorUtil.getColumnIndexOrThrow(_cursor, "item14_portaLateralEsquerda");
          final int _cursorIndexOfItem14Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item14_comentario");
          final int _cursorIndexOfItem15ParedeFrontal = CursorUtil.getColumnIndexOrThrow(_cursor, "item15_paredeFrontal");
          final int _cursorIndexOfItem15Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item15_comentario");
          final int _cursorIndexOfItem16Teto = CursorUtil.getColumnIndexOrThrow(_cursor, "item16_teto");
          final int _cursorIndexOfItem16Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item16_comentario");
          final int _cursorIndexOfItem17PisoCompartimentoCarga = CursorUtil.getColumnIndexOrThrow(_cursor, "item17_pisoCompartimentoCarga");
          final int _cursorIndexOfItem17Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item17_comentario");
          final int _cursorIndexOfItem18DutosAr = CursorUtil.getColumnIndexOrThrow(_cursor, "item18_dutosAr");
          final int _cursorIndexOfItem18Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item18_comentario");
          final int _cursorIndexOfItem19MotorCamaraFria = CursorUtil.getColumnIndexOrThrow(_cursor, "item19_motorCamaraFria");
          final int _cursorIndexOfItem19Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item19_comentario");
          final int _cursorIndexOfOdores = CursorUtil.getColumnIndexOrThrow(_cursor, "odores");
          final int _cursorIndexOfOdoresComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "odores_comentario");
          final int _cursorIndexOfPragasVisiveis = CursorUtil.getColumnIndexOrThrow(_cursor, "pragasVisiveis");
          final int _cursorIndexOfPragasComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "pragas_comentario");
          final int _cursorIndexOfContaminacaoQuimica = CursorUtil.getColumnIndexOrThrow(_cursor, "contaminacaoQuimica");
          final int _cursorIndexOfContaminacaoComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "contaminacao_comentario");
          final int _cursorIndexOfFundoParedeFalsa = CursorUtil.getColumnIndexOrThrow(_cursor, "fundoParedeFalsa");
          final int _cursorIndexOfFundoParedeComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "fundoParede_comentario");
          final int _cursorIndexOfIndiciosContaminacao = CursorUtil.getColumnIndexOrThrow(_cursor, "indiciosContaminacao");
          final int _cursorIndexOfIndiciosComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "indicios_comentario");
          final int _cursorIndexOfAutoridadeNotificada = CursorUtil.getColumnIndexOrThrow(_cursor, "autoridadeNotificada");
          final int _cursorIndexOfDataHoraNotificacao = CursorUtil.getColumnIndexOrThrow(_cursor, "dataHoraNotificacao");
          final int _cursorIndexOfAutoridadeComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "autoridade_comentario");
          final int _cursorIndexOfItemEmDesacordo = CursorUtil.getColumnIndexOrThrow(_cursor, "itemEmDesacordo");
          final int _cursorIndexOfFotoItemDesacordoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoItemDesacordoPath");
          final int _cursorIndexOfDataHoraTermino = CursorUtil.getColumnIndexOrThrow(_cursor, "dataHoraTermino");
          final int _cursorIndexOfAssinaturaVistoriador = CursorUtil.getColumnIndexOrThrow(_cursor, "assinaturaVistoriador");
          final int _cursorIndexOfAssinaturaMotorista = CursorUtil.getColumnIndexOrThrow(_cursor, "assinaturaMotorista");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPdfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "pdfPath");
          final List<Checklist> _result = new ArrayList<Checklist>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Checklist _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpUserId;
            _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
            final String _tmpLocalColeta;
            if (_cursor.isNull(_cursorIndexOfLocalColeta)) {
              _tmpLocalColeta = null;
            } else {
              _tmpLocalColeta = _cursor.getString(_cursorIndexOfLocalColeta);
            }
            final String _tmpResponsavel;
            if (_cursor.isNull(_cursorIndexOfResponsavel)) {
              _tmpResponsavel = null;
            } else {
              _tmpResponsavel = _cursor.getString(_cursorIndexOfResponsavel);
            }
            final String _tmpData;
            if (_cursor.isNull(_cursorIndexOfData)) {
              _tmpData = null;
            } else {
              _tmpData = _cursor.getString(_cursorIndexOfData);
            }
            final String _tmpPlacaCavalo;
            if (_cursor.isNull(_cursorIndexOfPlacaCavalo)) {
              _tmpPlacaCavalo = null;
            } else {
              _tmpPlacaCavalo = _cursor.getString(_cursorIndexOfPlacaCavalo);
            }
            final String _tmpPlacaCarreta;
            if (_cursor.isNull(_cursorIndexOfPlacaCarreta)) {
              _tmpPlacaCarreta = null;
            } else {
              _tmpPlacaCarreta = _cursor.getString(_cursorIndexOfPlacaCarreta);
            }
            final String _tmpMotorista;
            if (_cursor.isNull(_cursorIndexOfMotorista)) {
              _tmpMotorista = null;
            } else {
              _tmpMotorista = _cursor.getString(_cursorIndexOfMotorista);
            }
            final String _tmpDiDueCrtMicDta;
            if (_cursor.isNull(_cursorIndexOfDiDueCrtMicDta)) {
              _tmpDiDueCrtMicDta = null;
            } else {
              _tmpDiDueCrtMicDta = _cursor.getString(_cursorIndexOfDiDueCrtMicDta);
            }
            final String _tmpNfE;
            if (_cursor.isNull(_cursorIndexOfNfE)) {
              _tmpNfE = null;
            } else {
              _tmpNfE = _cursor.getString(_cursorIndexOfNfE);
            }
            final String _tmpLacreEntrada;
            if (_cursor.isNull(_cursorIndexOfLacreEntrada)) {
              _tmpLacreEntrada = null;
            } else {
              _tmpLacreEntrada = _cursor.getString(_cursorIndexOfLacreEntrada);
            }
            final String _tmpLacreSaida;
            if (_cursor.isNull(_cursorIndexOfLacreSaida)) {
              _tmpLacreSaida = null;
            } else {
              _tmpLacreSaida = _cursor.getString(_cursorIndexOfLacreSaida);
            }
            final String _tmpPesoBruto;
            if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
              _tmpPesoBruto = null;
            } else {
              _tmpPesoBruto = _cursor.getString(_cursorIndexOfPesoBruto);
            }
            final String _tmpTipoViagem;
            if (_cursor.isNull(_cursorIndexOfTipoViagem)) {
              _tmpTipoViagem = null;
            } else {
              _tmpTipoViagem = _cursor.getString(_cursorIndexOfTipoViagem);
            }
            final String _tmpItem1_parachoque;
            if (_cursor.isNull(_cursorIndexOfItem1Parachoque)) {
              _tmpItem1_parachoque = null;
            } else {
              _tmpItem1_parachoque = _cursor.getString(_cursorIndexOfItem1Parachoque);
            }
            final String _tmpItem1_comentario;
            if (_cursor.isNull(_cursorIndexOfItem1Comentario)) {
              _tmpItem1_comentario = null;
            } else {
              _tmpItem1_comentario = _cursor.getString(_cursorIndexOfItem1Comentario);
            }
            final String _tmpItem2_motor;
            if (_cursor.isNull(_cursorIndexOfItem2Motor)) {
              _tmpItem2_motor = null;
            } else {
              _tmpItem2_motor = _cursor.getString(_cursorIndexOfItem2Motor);
            }
            final String _tmpItem2_comentario;
            if (_cursor.isNull(_cursorIndexOfItem2Comentario)) {
              _tmpItem2_comentario = null;
            } else {
              _tmpItem2_comentario = _cursor.getString(_cursorIndexOfItem2Comentario);
            }
            final String _tmpItem3_pneus;
            if (_cursor.isNull(_cursorIndexOfItem3Pneus)) {
              _tmpItem3_pneus = null;
            } else {
              _tmpItem3_pneus = _cursor.getString(_cursorIndexOfItem3Pneus);
            }
            final String _tmpItem3_comentario;
            if (_cursor.isNull(_cursorIndexOfItem3Comentario)) {
              _tmpItem3_comentario = null;
            } else {
              _tmpItem3_comentario = _cursor.getString(_cursorIndexOfItem3Comentario);
            }
            final String _tmpItem4_unidadeTratora;
            if (_cursor.isNull(_cursorIndexOfItem4UnidadeTratora)) {
              _tmpItem4_unidadeTratora = null;
            } else {
              _tmpItem4_unidadeTratora = _cursor.getString(_cursorIndexOfItem4UnidadeTratora);
            }
            final String _tmpItem4_comentario;
            if (_cursor.isNull(_cursorIndexOfItem4Comentario)) {
              _tmpItem4_comentario = null;
            } else {
              _tmpItem4_comentario = _cursor.getString(_cursorIndexOfItem4Comentario);
            }
            final String _tmpItem5_tanquesCombustivel;
            if (_cursor.isNull(_cursorIndexOfItem5TanquesCombustivel)) {
              _tmpItem5_tanquesCombustivel = null;
            } else {
              _tmpItem5_tanquesCombustivel = _cursor.getString(_cursorIndexOfItem5TanquesCombustivel);
            }
            final String _tmpItem5_comentario;
            if (_cursor.isNull(_cursorIndexOfItem5Comentario)) {
              _tmpItem5_comentario = null;
            } else {
              _tmpItem5_comentario = _cursor.getString(_cursorIndexOfItem5Comentario);
            }
            final String _tmpItem6_cabine;
            if (_cursor.isNull(_cursorIndexOfItem6Cabine)) {
              _tmpItem6_cabine = null;
            } else {
              _tmpItem6_cabine = _cursor.getString(_cursorIndexOfItem6Cabine);
            }
            final String _tmpItem6_comentario;
            if (_cursor.isNull(_cursorIndexOfItem6Comentario)) {
              _tmpItem6_comentario = null;
            } else {
              _tmpItem6_comentario = _cursor.getString(_cursorIndexOfItem6Comentario);
            }
            final String _tmpItem7_eixoElevatorioAr;
            if (_cursor.isNull(_cursorIndexOfItem7EixoElevatorioAr)) {
              _tmpItem7_eixoElevatorioAr = null;
            } else {
              _tmpItem7_eixoElevatorioAr = _cursor.getString(_cursorIndexOfItem7EixoElevatorioAr);
            }
            final String _tmpItem7_comentario;
            if (_cursor.isNull(_cursorIndexOfItem7Comentario)) {
              _tmpItem7_comentario = null;
            } else {
              _tmpItem7_comentario = _cursor.getString(_cursorIndexOfItem7Comentario);
            }
            final String _tmpItem8_eixoTransmissao;
            if (_cursor.isNull(_cursorIndexOfItem8EixoTransmissao)) {
              _tmpItem8_eixoTransmissao = null;
            } else {
              _tmpItem8_eixoTransmissao = _cursor.getString(_cursorIndexOfItem8EixoTransmissao);
            }
            final String _tmpItem8_comentario;
            if (_cursor.isNull(_cursorIndexOfItem8Comentario)) {
              _tmpItem8_comentario = null;
            } else {
              _tmpItem8_comentario = _cursor.getString(_cursorIndexOfItem8Comentario);
            }
            final String _tmpItem9_areaQuintaRoda;
            if (_cursor.isNull(_cursorIndexOfItem9AreaQuintaRoda)) {
              _tmpItem9_areaQuintaRoda = null;
            } else {
              _tmpItem9_areaQuintaRoda = _cursor.getString(_cursorIndexOfItem9AreaQuintaRoda);
            }
            final String _tmpItem9_comentario;
            if (_cursor.isNull(_cursorIndexOfItem9Comentario)) {
              _tmpItem9_comentario = null;
            } else {
              _tmpItem9_comentario = _cursor.getString(_cursorIndexOfItem9Comentario);
            }
            final String _tmpItem10_sistemaExaustao;
            if (_cursor.isNull(_cursorIndexOfItem10SistemaExaustao)) {
              _tmpItem10_sistemaExaustao = null;
            } else {
              _tmpItem10_sistemaExaustao = _cursor.getString(_cursorIndexOfItem10SistemaExaustao);
            }
            final String _tmpItem10_comentario;
            if (_cursor.isNull(_cursorIndexOfItem10Comentario)) {
              _tmpItem10_comentario = null;
            } else {
              _tmpItem10_comentario = _cursor.getString(_cursorIndexOfItem10Comentario);
            }
            final String _tmpItem11_chassi;
            if (_cursor.isNull(_cursorIndexOfItem11Chassi)) {
              _tmpItem11_chassi = null;
            } else {
              _tmpItem11_chassi = _cursor.getString(_cursorIndexOfItem11Chassi);
            }
            final String _tmpItem11_comentario;
            if (_cursor.isNull(_cursorIndexOfItem11Comentario)) {
              _tmpItem11_comentario = null;
            } else {
              _tmpItem11_comentario = _cursor.getString(_cursorIndexOfItem11Comentario);
            }
            final String _tmpItem12_portasTraseira;
            if (_cursor.isNull(_cursorIndexOfItem12PortasTraseira)) {
              _tmpItem12_portasTraseira = null;
            } else {
              _tmpItem12_portasTraseira = _cursor.getString(_cursorIndexOfItem12PortasTraseira);
            }
            final String _tmpItem12_comentario;
            if (_cursor.isNull(_cursorIndexOfItem12Comentario)) {
              _tmpItem12_comentario = null;
            } else {
              _tmpItem12_comentario = _cursor.getString(_cursorIndexOfItem12Comentario);
            }
            final String _tmpItem13_portaLateralDireita;
            if (_cursor.isNull(_cursorIndexOfItem13PortaLateralDireita)) {
              _tmpItem13_portaLateralDireita = null;
            } else {
              _tmpItem13_portaLateralDireita = _cursor.getString(_cursorIndexOfItem13PortaLateralDireita);
            }
            final String _tmpItem13_comentario;
            if (_cursor.isNull(_cursorIndexOfItem13Comentario)) {
              _tmpItem13_comentario = null;
            } else {
              _tmpItem13_comentario = _cursor.getString(_cursorIndexOfItem13Comentario);
            }
            final String _tmpItem14_portaLateralEsquerda;
            if (_cursor.isNull(_cursorIndexOfItem14PortaLateralEsquerda)) {
              _tmpItem14_portaLateralEsquerda = null;
            } else {
              _tmpItem14_portaLateralEsquerda = _cursor.getString(_cursorIndexOfItem14PortaLateralEsquerda);
            }
            final String _tmpItem14_comentario;
            if (_cursor.isNull(_cursorIndexOfItem14Comentario)) {
              _tmpItem14_comentario = null;
            } else {
              _tmpItem14_comentario = _cursor.getString(_cursorIndexOfItem14Comentario);
            }
            final String _tmpItem15_paredeFrontal;
            if (_cursor.isNull(_cursorIndexOfItem15ParedeFrontal)) {
              _tmpItem15_paredeFrontal = null;
            } else {
              _tmpItem15_paredeFrontal = _cursor.getString(_cursorIndexOfItem15ParedeFrontal);
            }
            final String _tmpItem15_comentario;
            if (_cursor.isNull(_cursorIndexOfItem15Comentario)) {
              _tmpItem15_comentario = null;
            } else {
              _tmpItem15_comentario = _cursor.getString(_cursorIndexOfItem15Comentario);
            }
            final String _tmpItem16_teto;
            if (_cursor.isNull(_cursorIndexOfItem16Teto)) {
              _tmpItem16_teto = null;
            } else {
              _tmpItem16_teto = _cursor.getString(_cursorIndexOfItem16Teto);
            }
            final String _tmpItem16_comentario;
            if (_cursor.isNull(_cursorIndexOfItem16Comentario)) {
              _tmpItem16_comentario = null;
            } else {
              _tmpItem16_comentario = _cursor.getString(_cursorIndexOfItem16Comentario);
            }
            final String _tmpItem17_pisoCompartimentoCarga;
            if (_cursor.isNull(_cursorIndexOfItem17PisoCompartimentoCarga)) {
              _tmpItem17_pisoCompartimentoCarga = null;
            } else {
              _tmpItem17_pisoCompartimentoCarga = _cursor.getString(_cursorIndexOfItem17PisoCompartimentoCarga);
            }
            final String _tmpItem17_comentario;
            if (_cursor.isNull(_cursorIndexOfItem17Comentario)) {
              _tmpItem17_comentario = null;
            } else {
              _tmpItem17_comentario = _cursor.getString(_cursorIndexOfItem17Comentario);
            }
            final String _tmpItem18_dutosAr;
            if (_cursor.isNull(_cursorIndexOfItem18DutosAr)) {
              _tmpItem18_dutosAr = null;
            } else {
              _tmpItem18_dutosAr = _cursor.getString(_cursorIndexOfItem18DutosAr);
            }
            final String _tmpItem18_comentario;
            if (_cursor.isNull(_cursorIndexOfItem18Comentario)) {
              _tmpItem18_comentario = null;
            } else {
              _tmpItem18_comentario = _cursor.getString(_cursorIndexOfItem18Comentario);
            }
            final String _tmpItem19_motorCamaraFria;
            if (_cursor.isNull(_cursorIndexOfItem19MotorCamaraFria)) {
              _tmpItem19_motorCamaraFria = null;
            } else {
              _tmpItem19_motorCamaraFria = _cursor.getString(_cursorIndexOfItem19MotorCamaraFria);
            }
            final String _tmpItem19_comentario;
            if (_cursor.isNull(_cursorIndexOfItem19Comentario)) {
              _tmpItem19_comentario = null;
            } else {
              _tmpItem19_comentario = _cursor.getString(_cursorIndexOfItem19Comentario);
            }
            final String _tmpOdores;
            if (_cursor.isNull(_cursorIndexOfOdores)) {
              _tmpOdores = null;
            } else {
              _tmpOdores = _cursor.getString(_cursorIndexOfOdores);
            }
            final String _tmpOdores_comentario;
            if (_cursor.isNull(_cursorIndexOfOdoresComentario)) {
              _tmpOdores_comentario = null;
            } else {
              _tmpOdores_comentario = _cursor.getString(_cursorIndexOfOdoresComentario);
            }
            final String _tmpPragasVisiveis;
            if (_cursor.isNull(_cursorIndexOfPragasVisiveis)) {
              _tmpPragasVisiveis = null;
            } else {
              _tmpPragasVisiveis = _cursor.getString(_cursorIndexOfPragasVisiveis);
            }
            final String _tmpPragas_comentario;
            if (_cursor.isNull(_cursorIndexOfPragasComentario)) {
              _tmpPragas_comentario = null;
            } else {
              _tmpPragas_comentario = _cursor.getString(_cursorIndexOfPragasComentario);
            }
            final String _tmpContaminacaoQuimica;
            if (_cursor.isNull(_cursorIndexOfContaminacaoQuimica)) {
              _tmpContaminacaoQuimica = null;
            } else {
              _tmpContaminacaoQuimica = _cursor.getString(_cursorIndexOfContaminacaoQuimica);
            }
            final String _tmpContaminacao_comentario;
            if (_cursor.isNull(_cursorIndexOfContaminacaoComentario)) {
              _tmpContaminacao_comentario = null;
            } else {
              _tmpContaminacao_comentario = _cursor.getString(_cursorIndexOfContaminacaoComentario);
            }
            final String _tmpFundoParedeFalsa;
            if (_cursor.isNull(_cursorIndexOfFundoParedeFalsa)) {
              _tmpFundoParedeFalsa = null;
            } else {
              _tmpFundoParedeFalsa = _cursor.getString(_cursorIndexOfFundoParedeFalsa);
            }
            final String _tmpFundoParede_comentario;
            if (_cursor.isNull(_cursorIndexOfFundoParedeComentario)) {
              _tmpFundoParede_comentario = null;
            } else {
              _tmpFundoParede_comentario = _cursor.getString(_cursorIndexOfFundoParedeComentario);
            }
            final String _tmpIndiciosContaminacao;
            if (_cursor.isNull(_cursorIndexOfIndiciosContaminacao)) {
              _tmpIndiciosContaminacao = null;
            } else {
              _tmpIndiciosContaminacao = _cursor.getString(_cursorIndexOfIndiciosContaminacao);
            }
            final String _tmpIndicios_comentario;
            if (_cursor.isNull(_cursorIndexOfIndiciosComentario)) {
              _tmpIndicios_comentario = null;
            } else {
              _tmpIndicios_comentario = _cursor.getString(_cursorIndexOfIndiciosComentario);
            }
            final Boolean _tmpAutoridadeNotificada;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfAutoridadeNotificada)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfAutoridadeNotificada);
            }
            _tmpAutoridadeNotificada = _tmp == null ? null : _tmp != 0;
            final String _tmpDataHoraNotificacao;
            if (_cursor.isNull(_cursorIndexOfDataHoraNotificacao)) {
              _tmpDataHoraNotificacao = null;
            } else {
              _tmpDataHoraNotificacao = _cursor.getString(_cursorIndexOfDataHoraNotificacao);
            }
            final String _tmpAutoridade_comentario;
            if (_cursor.isNull(_cursorIndexOfAutoridadeComentario)) {
              _tmpAutoridade_comentario = null;
            } else {
              _tmpAutoridade_comentario = _cursor.getString(_cursorIndexOfAutoridadeComentario);
            }
            final boolean _tmpItemEmDesacordo;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfItemEmDesacordo);
            _tmpItemEmDesacordo = _tmp_1 != 0;
            final String _tmpFotoItemDesacordoPath;
            if (_cursor.isNull(_cursorIndexOfFotoItemDesacordoPath)) {
              _tmpFotoItemDesacordoPath = null;
            } else {
              _tmpFotoItemDesacordoPath = _cursor.getString(_cursorIndexOfFotoItemDesacordoPath);
            }
            final String _tmpDataHoraTermino;
            if (_cursor.isNull(_cursorIndexOfDataHoraTermino)) {
              _tmpDataHoraTermino = null;
            } else {
              _tmpDataHoraTermino = _cursor.getString(_cursorIndexOfDataHoraTermino);
            }
            final String _tmpAssinaturaVistoriador;
            if (_cursor.isNull(_cursorIndexOfAssinaturaVistoriador)) {
              _tmpAssinaturaVistoriador = null;
            } else {
              _tmpAssinaturaVistoriador = _cursor.getString(_cursorIndexOfAssinaturaVistoriador);
            }
            final String _tmpAssinaturaMotorista;
            if (_cursor.isNull(_cursorIndexOfAssinaturaMotorista)) {
              _tmpAssinaturaMotorista = null;
            } else {
              _tmpAssinaturaMotorista = _cursor.getString(_cursorIndexOfAssinaturaMotorista);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPdfPath;
            if (_cursor.isNull(_cursorIndexOfPdfPath)) {
              _tmpPdfPath = null;
            } else {
              _tmpPdfPath = _cursor.getString(_cursorIndexOfPdfPath);
            }
            _item = new Checklist(_tmpId,_tmpUserId,_tmpLocalColeta,_tmpResponsavel,_tmpData,_tmpPlacaCavalo,_tmpPlacaCarreta,_tmpMotorista,_tmpDiDueCrtMicDta,_tmpNfE,_tmpLacreEntrada,_tmpLacreSaida,_tmpPesoBruto,_tmpTipoViagem,_tmpItem1_parachoque,_tmpItem1_comentario,_tmpItem2_motor,_tmpItem2_comentario,_tmpItem3_pneus,_tmpItem3_comentario,_tmpItem4_unidadeTratora,_tmpItem4_comentario,_tmpItem5_tanquesCombustivel,_tmpItem5_comentario,_tmpItem6_cabine,_tmpItem6_comentario,_tmpItem7_eixoElevatorioAr,_tmpItem7_comentario,_tmpItem8_eixoTransmissao,_tmpItem8_comentario,_tmpItem9_areaQuintaRoda,_tmpItem9_comentario,_tmpItem10_sistemaExaustao,_tmpItem10_comentario,_tmpItem11_chassi,_tmpItem11_comentario,_tmpItem12_portasTraseira,_tmpItem12_comentario,_tmpItem13_portaLateralDireita,_tmpItem13_comentario,_tmpItem14_portaLateralEsquerda,_tmpItem14_comentario,_tmpItem15_paredeFrontal,_tmpItem15_comentario,_tmpItem16_teto,_tmpItem16_comentario,_tmpItem17_pisoCompartimentoCarga,_tmpItem17_comentario,_tmpItem18_dutosAr,_tmpItem18_comentario,_tmpItem19_motorCamaraFria,_tmpItem19_comentario,_tmpOdores,_tmpOdores_comentario,_tmpPragasVisiveis,_tmpPragas_comentario,_tmpContaminacaoQuimica,_tmpContaminacao_comentario,_tmpFundoParedeFalsa,_tmpFundoParede_comentario,_tmpIndiciosContaminacao,_tmpIndicios_comentario,_tmpAutoridadeNotificada,_tmpDataHoraNotificacao,_tmpAutoridade_comentario,_tmpItemEmDesacordo,_tmpFotoItemDesacordoPath,_tmpDataHoraTermino,_tmpAssinaturaVistoriador,_tmpAssinaturaMotorista,_tmpTimestamp,_tmpStatus,_tmpPdfPath);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getChecklistsByStatus(final String status,
      final Continuation<? super List<Checklist>> $completion) {
    final String _sql = "SELECT * FROM checklists WHERE status = ? ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, status);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Checklist>>() {
      @Override
      @NonNull
      public List<Checklist> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfLocalColeta = CursorUtil.getColumnIndexOrThrow(_cursor, "localColeta");
          final int _cursorIndexOfResponsavel = CursorUtil.getColumnIndexOrThrow(_cursor, "responsavel");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfPlacaCavalo = CursorUtil.getColumnIndexOrThrow(_cursor, "placaCavalo");
          final int _cursorIndexOfPlacaCarreta = CursorUtil.getColumnIndexOrThrow(_cursor, "placaCarreta");
          final int _cursorIndexOfMotorista = CursorUtil.getColumnIndexOrThrow(_cursor, "motorista");
          final int _cursorIndexOfDiDueCrtMicDta = CursorUtil.getColumnIndexOrThrow(_cursor, "diDueCrtMicDta");
          final int _cursorIndexOfNfE = CursorUtil.getColumnIndexOrThrow(_cursor, "nfE");
          final int _cursorIndexOfLacreEntrada = CursorUtil.getColumnIndexOrThrow(_cursor, "lacreEntrada");
          final int _cursorIndexOfLacreSaida = CursorUtil.getColumnIndexOrThrow(_cursor, "lacreSaida");
          final int _cursorIndexOfPesoBruto = CursorUtil.getColumnIndexOrThrow(_cursor, "pesoBruto");
          final int _cursorIndexOfTipoViagem = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoViagem");
          final int _cursorIndexOfItem1Parachoque = CursorUtil.getColumnIndexOrThrow(_cursor, "item1_parachoque");
          final int _cursorIndexOfItem1Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item1_comentario");
          final int _cursorIndexOfItem2Motor = CursorUtil.getColumnIndexOrThrow(_cursor, "item2_motor");
          final int _cursorIndexOfItem2Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item2_comentario");
          final int _cursorIndexOfItem3Pneus = CursorUtil.getColumnIndexOrThrow(_cursor, "item3_pneus");
          final int _cursorIndexOfItem3Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item3_comentario");
          final int _cursorIndexOfItem4UnidadeTratora = CursorUtil.getColumnIndexOrThrow(_cursor, "item4_unidadeTratora");
          final int _cursorIndexOfItem4Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item4_comentario");
          final int _cursorIndexOfItem5TanquesCombustivel = CursorUtil.getColumnIndexOrThrow(_cursor, "item5_tanquesCombustivel");
          final int _cursorIndexOfItem5Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item5_comentario");
          final int _cursorIndexOfItem6Cabine = CursorUtil.getColumnIndexOrThrow(_cursor, "item6_cabine");
          final int _cursorIndexOfItem6Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item6_comentario");
          final int _cursorIndexOfItem7EixoElevatorioAr = CursorUtil.getColumnIndexOrThrow(_cursor, "item7_eixoElevatorioAr");
          final int _cursorIndexOfItem7Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item7_comentario");
          final int _cursorIndexOfItem8EixoTransmissao = CursorUtil.getColumnIndexOrThrow(_cursor, "item8_eixoTransmissao");
          final int _cursorIndexOfItem8Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item8_comentario");
          final int _cursorIndexOfItem9AreaQuintaRoda = CursorUtil.getColumnIndexOrThrow(_cursor, "item9_areaQuintaRoda");
          final int _cursorIndexOfItem9Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item9_comentario");
          final int _cursorIndexOfItem10SistemaExaustao = CursorUtil.getColumnIndexOrThrow(_cursor, "item10_sistemaExaustao");
          final int _cursorIndexOfItem10Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item10_comentario");
          final int _cursorIndexOfItem11Chassi = CursorUtil.getColumnIndexOrThrow(_cursor, "item11_chassi");
          final int _cursorIndexOfItem11Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item11_comentario");
          final int _cursorIndexOfItem12PortasTraseira = CursorUtil.getColumnIndexOrThrow(_cursor, "item12_portasTraseira");
          final int _cursorIndexOfItem12Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item12_comentario");
          final int _cursorIndexOfItem13PortaLateralDireita = CursorUtil.getColumnIndexOrThrow(_cursor, "item13_portaLateralDireita");
          final int _cursorIndexOfItem13Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item13_comentario");
          final int _cursorIndexOfItem14PortaLateralEsquerda = CursorUtil.getColumnIndexOrThrow(_cursor, "item14_portaLateralEsquerda");
          final int _cursorIndexOfItem14Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item14_comentario");
          final int _cursorIndexOfItem15ParedeFrontal = CursorUtil.getColumnIndexOrThrow(_cursor, "item15_paredeFrontal");
          final int _cursorIndexOfItem15Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item15_comentario");
          final int _cursorIndexOfItem16Teto = CursorUtil.getColumnIndexOrThrow(_cursor, "item16_teto");
          final int _cursorIndexOfItem16Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item16_comentario");
          final int _cursorIndexOfItem17PisoCompartimentoCarga = CursorUtil.getColumnIndexOrThrow(_cursor, "item17_pisoCompartimentoCarga");
          final int _cursorIndexOfItem17Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item17_comentario");
          final int _cursorIndexOfItem18DutosAr = CursorUtil.getColumnIndexOrThrow(_cursor, "item18_dutosAr");
          final int _cursorIndexOfItem18Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item18_comentario");
          final int _cursorIndexOfItem19MotorCamaraFria = CursorUtil.getColumnIndexOrThrow(_cursor, "item19_motorCamaraFria");
          final int _cursorIndexOfItem19Comentario = CursorUtil.getColumnIndexOrThrow(_cursor, "item19_comentario");
          final int _cursorIndexOfOdores = CursorUtil.getColumnIndexOrThrow(_cursor, "odores");
          final int _cursorIndexOfOdoresComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "odores_comentario");
          final int _cursorIndexOfPragasVisiveis = CursorUtil.getColumnIndexOrThrow(_cursor, "pragasVisiveis");
          final int _cursorIndexOfPragasComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "pragas_comentario");
          final int _cursorIndexOfContaminacaoQuimica = CursorUtil.getColumnIndexOrThrow(_cursor, "contaminacaoQuimica");
          final int _cursorIndexOfContaminacaoComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "contaminacao_comentario");
          final int _cursorIndexOfFundoParedeFalsa = CursorUtil.getColumnIndexOrThrow(_cursor, "fundoParedeFalsa");
          final int _cursorIndexOfFundoParedeComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "fundoParede_comentario");
          final int _cursorIndexOfIndiciosContaminacao = CursorUtil.getColumnIndexOrThrow(_cursor, "indiciosContaminacao");
          final int _cursorIndexOfIndiciosComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "indicios_comentario");
          final int _cursorIndexOfAutoridadeNotificada = CursorUtil.getColumnIndexOrThrow(_cursor, "autoridadeNotificada");
          final int _cursorIndexOfDataHoraNotificacao = CursorUtil.getColumnIndexOrThrow(_cursor, "dataHoraNotificacao");
          final int _cursorIndexOfAutoridadeComentario = CursorUtil.getColumnIndexOrThrow(_cursor, "autoridade_comentario");
          final int _cursorIndexOfItemEmDesacordo = CursorUtil.getColumnIndexOrThrow(_cursor, "itemEmDesacordo");
          final int _cursorIndexOfFotoItemDesacordoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoItemDesacordoPath");
          final int _cursorIndexOfDataHoraTermino = CursorUtil.getColumnIndexOrThrow(_cursor, "dataHoraTermino");
          final int _cursorIndexOfAssinaturaVistoriador = CursorUtil.getColumnIndexOrThrow(_cursor, "assinaturaVistoriador");
          final int _cursorIndexOfAssinaturaMotorista = CursorUtil.getColumnIndexOrThrow(_cursor, "assinaturaMotorista");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPdfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "pdfPath");
          final List<Checklist> _result = new ArrayList<Checklist>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Checklist _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpUserId;
            _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
            final String _tmpLocalColeta;
            if (_cursor.isNull(_cursorIndexOfLocalColeta)) {
              _tmpLocalColeta = null;
            } else {
              _tmpLocalColeta = _cursor.getString(_cursorIndexOfLocalColeta);
            }
            final String _tmpResponsavel;
            if (_cursor.isNull(_cursorIndexOfResponsavel)) {
              _tmpResponsavel = null;
            } else {
              _tmpResponsavel = _cursor.getString(_cursorIndexOfResponsavel);
            }
            final String _tmpData;
            if (_cursor.isNull(_cursorIndexOfData)) {
              _tmpData = null;
            } else {
              _tmpData = _cursor.getString(_cursorIndexOfData);
            }
            final String _tmpPlacaCavalo;
            if (_cursor.isNull(_cursorIndexOfPlacaCavalo)) {
              _tmpPlacaCavalo = null;
            } else {
              _tmpPlacaCavalo = _cursor.getString(_cursorIndexOfPlacaCavalo);
            }
            final String _tmpPlacaCarreta;
            if (_cursor.isNull(_cursorIndexOfPlacaCarreta)) {
              _tmpPlacaCarreta = null;
            } else {
              _tmpPlacaCarreta = _cursor.getString(_cursorIndexOfPlacaCarreta);
            }
            final String _tmpMotorista;
            if (_cursor.isNull(_cursorIndexOfMotorista)) {
              _tmpMotorista = null;
            } else {
              _tmpMotorista = _cursor.getString(_cursorIndexOfMotorista);
            }
            final String _tmpDiDueCrtMicDta;
            if (_cursor.isNull(_cursorIndexOfDiDueCrtMicDta)) {
              _tmpDiDueCrtMicDta = null;
            } else {
              _tmpDiDueCrtMicDta = _cursor.getString(_cursorIndexOfDiDueCrtMicDta);
            }
            final String _tmpNfE;
            if (_cursor.isNull(_cursorIndexOfNfE)) {
              _tmpNfE = null;
            } else {
              _tmpNfE = _cursor.getString(_cursorIndexOfNfE);
            }
            final String _tmpLacreEntrada;
            if (_cursor.isNull(_cursorIndexOfLacreEntrada)) {
              _tmpLacreEntrada = null;
            } else {
              _tmpLacreEntrada = _cursor.getString(_cursorIndexOfLacreEntrada);
            }
            final String _tmpLacreSaida;
            if (_cursor.isNull(_cursorIndexOfLacreSaida)) {
              _tmpLacreSaida = null;
            } else {
              _tmpLacreSaida = _cursor.getString(_cursorIndexOfLacreSaida);
            }
            final String _tmpPesoBruto;
            if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
              _tmpPesoBruto = null;
            } else {
              _tmpPesoBruto = _cursor.getString(_cursorIndexOfPesoBruto);
            }
            final String _tmpTipoViagem;
            if (_cursor.isNull(_cursorIndexOfTipoViagem)) {
              _tmpTipoViagem = null;
            } else {
              _tmpTipoViagem = _cursor.getString(_cursorIndexOfTipoViagem);
            }
            final String _tmpItem1_parachoque;
            if (_cursor.isNull(_cursorIndexOfItem1Parachoque)) {
              _tmpItem1_parachoque = null;
            } else {
              _tmpItem1_parachoque = _cursor.getString(_cursorIndexOfItem1Parachoque);
            }
            final String _tmpItem1_comentario;
            if (_cursor.isNull(_cursorIndexOfItem1Comentario)) {
              _tmpItem1_comentario = null;
            } else {
              _tmpItem1_comentario = _cursor.getString(_cursorIndexOfItem1Comentario);
            }
            final String _tmpItem2_motor;
            if (_cursor.isNull(_cursorIndexOfItem2Motor)) {
              _tmpItem2_motor = null;
            } else {
              _tmpItem2_motor = _cursor.getString(_cursorIndexOfItem2Motor);
            }
            final String _tmpItem2_comentario;
            if (_cursor.isNull(_cursorIndexOfItem2Comentario)) {
              _tmpItem2_comentario = null;
            } else {
              _tmpItem2_comentario = _cursor.getString(_cursorIndexOfItem2Comentario);
            }
            final String _tmpItem3_pneus;
            if (_cursor.isNull(_cursorIndexOfItem3Pneus)) {
              _tmpItem3_pneus = null;
            } else {
              _tmpItem3_pneus = _cursor.getString(_cursorIndexOfItem3Pneus);
            }
            final String _tmpItem3_comentario;
            if (_cursor.isNull(_cursorIndexOfItem3Comentario)) {
              _tmpItem3_comentario = null;
            } else {
              _tmpItem3_comentario = _cursor.getString(_cursorIndexOfItem3Comentario);
            }
            final String _tmpItem4_unidadeTratora;
            if (_cursor.isNull(_cursorIndexOfItem4UnidadeTratora)) {
              _tmpItem4_unidadeTratora = null;
            } else {
              _tmpItem4_unidadeTratora = _cursor.getString(_cursorIndexOfItem4UnidadeTratora);
            }
            final String _tmpItem4_comentario;
            if (_cursor.isNull(_cursorIndexOfItem4Comentario)) {
              _tmpItem4_comentario = null;
            } else {
              _tmpItem4_comentario = _cursor.getString(_cursorIndexOfItem4Comentario);
            }
            final String _tmpItem5_tanquesCombustivel;
            if (_cursor.isNull(_cursorIndexOfItem5TanquesCombustivel)) {
              _tmpItem5_tanquesCombustivel = null;
            } else {
              _tmpItem5_tanquesCombustivel = _cursor.getString(_cursorIndexOfItem5TanquesCombustivel);
            }
            final String _tmpItem5_comentario;
            if (_cursor.isNull(_cursorIndexOfItem5Comentario)) {
              _tmpItem5_comentario = null;
            } else {
              _tmpItem5_comentario = _cursor.getString(_cursorIndexOfItem5Comentario);
            }
            final String _tmpItem6_cabine;
            if (_cursor.isNull(_cursorIndexOfItem6Cabine)) {
              _tmpItem6_cabine = null;
            } else {
              _tmpItem6_cabine = _cursor.getString(_cursorIndexOfItem6Cabine);
            }
            final String _tmpItem6_comentario;
            if (_cursor.isNull(_cursorIndexOfItem6Comentario)) {
              _tmpItem6_comentario = null;
            } else {
              _tmpItem6_comentario = _cursor.getString(_cursorIndexOfItem6Comentario);
            }
            final String _tmpItem7_eixoElevatorioAr;
            if (_cursor.isNull(_cursorIndexOfItem7EixoElevatorioAr)) {
              _tmpItem7_eixoElevatorioAr = null;
            } else {
              _tmpItem7_eixoElevatorioAr = _cursor.getString(_cursorIndexOfItem7EixoElevatorioAr);
            }
            final String _tmpItem7_comentario;
            if (_cursor.isNull(_cursorIndexOfItem7Comentario)) {
              _tmpItem7_comentario = null;
            } else {
              _tmpItem7_comentario = _cursor.getString(_cursorIndexOfItem7Comentario);
            }
            final String _tmpItem8_eixoTransmissao;
            if (_cursor.isNull(_cursorIndexOfItem8EixoTransmissao)) {
              _tmpItem8_eixoTransmissao = null;
            } else {
              _tmpItem8_eixoTransmissao = _cursor.getString(_cursorIndexOfItem8EixoTransmissao);
            }
            final String _tmpItem8_comentario;
            if (_cursor.isNull(_cursorIndexOfItem8Comentario)) {
              _tmpItem8_comentario = null;
            } else {
              _tmpItem8_comentario = _cursor.getString(_cursorIndexOfItem8Comentario);
            }
            final String _tmpItem9_areaQuintaRoda;
            if (_cursor.isNull(_cursorIndexOfItem9AreaQuintaRoda)) {
              _tmpItem9_areaQuintaRoda = null;
            } else {
              _tmpItem9_areaQuintaRoda = _cursor.getString(_cursorIndexOfItem9AreaQuintaRoda);
            }
            final String _tmpItem9_comentario;
            if (_cursor.isNull(_cursorIndexOfItem9Comentario)) {
              _tmpItem9_comentario = null;
            } else {
              _tmpItem9_comentario = _cursor.getString(_cursorIndexOfItem9Comentario);
            }
            final String _tmpItem10_sistemaExaustao;
            if (_cursor.isNull(_cursorIndexOfItem10SistemaExaustao)) {
              _tmpItem10_sistemaExaustao = null;
            } else {
              _tmpItem10_sistemaExaustao = _cursor.getString(_cursorIndexOfItem10SistemaExaustao);
            }
            final String _tmpItem10_comentario;
            if (_cursor.isNull(_cursorIndexOfItem10Comentario)) {
              _tmpItem10_comentario = null;
            } else {
              _tmpItem10_comentario = _cursor.getString(_cursorIndexOfItem10Comentario);
            }
            final String _tmpItem11_chassi;
            if (_cursor.isNull(_cursorIndexOfItem11Chassi)) {
              _tmpItem11_chassi = null;
            } else {
              _tmpItem11_chassi = _cursor.getString(_cursorIndexOfItem11Chassi);
            }
            final String _tmpItem11_comentario;
            if (_cursor.isNull(_cursorIndexOfItem11Comentario)) {
              _tmpItem11_comentario = null;
            } else {
              _tmpItem11_comentario = _cursor.getString(_cursorIndexOfItem11Comentario);
            }
            final String _tmpItem12_portasTraseira;
            if (_cursor.isNull(_cursorIndexOfItem12PortasTraseira)) {
              _tmpItem12_portasTraseira = null;
            } else {
              _tmpItem12_portasTraseira = _cursor.getString(_cursorIndexOfItem12PortasTraseira);
            }
            final String _tmpItem12_comentario;
            if (_cursor.isNull(_cursorIndexOfItem12Comentario)) {
              _tmpItem12_comentario = null;
            } else {
              _tmpItem12_comentario = _cursor.getString(_cursorIndexOfItem12Comentario);
            }
            final String _tmpItem13_portaLateralDireita;
            if (_cursor.isNull(_cursorIndexOfItem13PortaLateralDireita)) {
              _tmpItem13_portaLateralDireita = null;
            } else {
              _tmpItem13_portaLateralDireita = _cursor.getString(_cursorIndexOfItem13PortaLateralDireita);
            }
            final String _tmpItem13_comentario;
            if (_cursor.isNull(_cursorIndexOfItem13Comentario)) {
              _tmpItem13_comentario = null;
            } else {
              _tmpItem13_comentario = _cursor.getString(_cursorIndexOfItem13Comentario);
            }
            final String _tmpItem14_portaLateralEsquerda;
            if (_cursor.isNull(_cursorIndexOfItem14PortaLateralEsquerda)) {
              _tmpItem14_portaLateralEsquerda = null;
            } else {
              _tmpItem14_portaLateralEsquerda = _cursor.getString(_cursorIndexOfItem14PortaLateralEsquerda);
            }
            final String _tmpItem14_comentario;
            if (_cursor.isNull(_cursorIndexOfItem14Comentario)) {
              _tmpItem14_comentario = null;
            } else {
              _tmpItem14_comentario = _cursor.getString(_cursorIndexOfItem14Comentario);
            }
            final String _tmpItem15_paredeFrontal;
            if (_cursor.isNull(_cursorIndexOfItem15ParedeFrontal)) {
              _tmpItem15_paredeFrontal = null;
            } else {
              _tmpItem15_paredeFrontal = _cursor.getString(_cursorIndexOfItem15ParedeFrontal);
            }
            final String _tmpItem15_comentario;
            if (_cursor.isNull(_cursorIndexOfItem15Comentario)) {
              _tmpItem15_comentario = null;
            } else {
              _tmpItem15_comentario = _cursor.getString(_cursorIndexOfItem15Comentario);
            }
            final String _tmpItem16_teto;
            if (_cursor.isNull(_cursorIndexOfItem16Teto)) {
              _tmpItem16_teto = null;
            } else {
              _tmpItem16_teto = _cursor.getString(_cursorIndexOfItem16Teto);
            }
            final String _tmpItem16_comentario;
            if (_cursor.isNull(_cursorIndexOfItem16Comentario)) {
              _tmpItem16_comentario = null;
            } else {
              _tmpItem16_comentario = _cursor.getString(_cursorIndexOfItem16Comentario);
            }
            final String _tmpItem17_pisoCompartimentoCarga;
            if (_cursor.isNull(_cursorIndexOfItem17PisoCompartimentoCarga)) {
              _tmpItem17_pisoCompartimentoCarga = null;
            } else {
              _tmpItem17_pisoCompartimentoCarga = _cursor.getString(_cursorIndexOfItem17PisoCompartimentoCarga);
            }
            final String _tmpItem17_comentario;
            if (_cursor.isNull(_cursorIndexOfItem17Comentario)) {
              _tmpItem17_comentario = null;
            } else {
              _tmpItem17_comentario = _cursor.getString(_cursorIndexOfItem17Comentario);
            }
            final String _tmpItem18_dutosAr;
            if (_cursor.isNull(_cursorIndexOfItem18DutosAr)) {
              _tmpItem18_dutosAr = null;
            } else {
              _tmpItem18_dutosAr = _cursor.getString(_cursorIndexOfItem18DutosAr);
            }
            final String _tmpItem18_comentario;
            if (_cursor.isNull(_cursorIndexOfItem18Comentario)) {
              _tmpItem18_comentario = null;
            } else {
              _tmpItem18_comentario = _cursor.getString(_cursorIndexOfItem18Comentario);
            }
            final String _tmpItem19_motorCamaraFria;
            if (_cursor.isNull(_cursorIndexOfItem19MotorCamaraFria)) {
              _tmpItem19_motorCamaraFria = null;
            } else {
              _tmpItem19_motorCamaraFria = _cursor.getString(_cursorIndexOfItem19MotorCamaraFria);
            }
            final String _tmpItem19_comentario;
            if (_cursor.isNull(_cursorIndexOfItem19Comentario)) {
              _tmpItem19_comentario = null;
            } else {
              _tmpItem19_comentario = _cursor.getString(_cursorIndexOfItem19Comentario);
            }
            final String _tmpOdores;
            if (_cursor.isNull(_cursorIndexOfOdores)) {
              _tmpOdores = null;
            } else {
              _tmpOdores = _cursor.getString(_cursorIndexOfOdores);
            }
            final String _tmpOdores_comentario;
            if (_cursor.isNull(_cursorIndexOfOdoresComentario)) {
              _tmpOdores_comentario = null;
            } else {
              _tmpOdores_comentario = _cursor.getString(_cursorIndexOfOdoresComentario);
            }
            final String _tmpPragasVisiveis;
            if (_cursor.isNull(_cursorIndexOfPragasVisiveis)) {
              _tmpPragasVisiveis = null;
            } else {
              _tmpPragasVisiveis = _cursor.getString(_cursorIndexOfPragasVisiveis);
            }
            final String _tmpPragas_comentario;
            if (_cursor.isNull(_cursorIndexOfPragasComentario)) {
              _tmpPragas_comentario = null;
            } else {
              _tmpPragas_comentario = _cursor.getString(_cursorIndexOfPragasComentario);
            }
            final String _tmpContaminacaoQuimica;
            if (_cursor.isNull(_cursorIndexOfContaminacaoQuimica)) {
              _tmpContaminacaoQuimica = null;
            } else {
              _tmpContaminacaoQuimica = _cursor.getString(_cursorIndexOfContaminacaoQuimica);
            }
            final String _tmpContaminacao_comentario;
            if (_cursor.isNull(_cursorIndexOfContaminacaoComentario)) {
              _tmpContaminacao_comentario = null;
            } else {
              _tmpContaminacao_comentario = _cursor.getString(_cursorIndexOfContaminacaoComentario);
            }
            final String _tmpFundoParedeFalsa;
            if (_cursor.isNull(_cursorIndexOfFundoParedeFalsa)) {
              _tmpFundoParedeFalsa = null;
            } else {
              _tmpFundoParedeFalsa = _cursor.getString(_cursorIndexOfFundoParedeFalsa);
            }
            final String _tmpFundoParede_comentario;
            if (_cursor.isNull(_cursorIndexOfFundoParedeComentario)) {
              _tmpFundoParede_comentario = null;
            } else {
              _tmpFundoParede_comentario = _cursor.getString(_cursorIndexOfFundoParedeComentario);
            }
            final String _tmpIndiciosContaminacao;
            if (_cursor.isNull(_cursorIndexOfIndiciosContaminacao)) {
              _tmpIndiciosContaminacao = null;
            } else {
              _tmpIndiciosContaminacao = _cursor.getString(_cursorIndexOfIndiciosContaminacao);
            }
            final String _tmpIndicios_comentario;
            if (_cursor.isNull(_cursorIndexOfIndiciosComentario)) {
              _tmpIndicios_comentario = null;
            } else {
              _tmpIndicios_comentario = _cursor.getString(_cursorIndexOfIndiciosComentario);
            }
            final Boolean _tmpAutoridadeNotificada;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfAutoridadeNotificada)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfAutoridadeNotificada);
            }
            _tmpAutoridadeNotificada = _tmp == null ? null : _tmp != 0;
            final String _tmpDataHoraNotificacao;
            if (_cursor.isNull(_cursorIndexOfDataHoraNotificacao)) {
              _tmpDataHoraNotificacao = null;
            } else {
              _tmpDataHoraNotificacao = _cursor.getString(_cursorIndexOfDataHoraNotificacao);
            }
            final String _tmpAutoridade_comentario;
            if (_cursor.isNull(_cursorIndexOfAutoridadeComentario)) {
              _tmpAutoridade_comentario = null;
            } else {
              _tmpAutoridade_comentario = _cursor.getString(_cursorIndexOfAutoridadeComentario);
            }
            final boolean _tmpItemEmDesacordo;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfItemEmDesacordo);
            _tmpItemEmDesacordo = _tmp_1 != 0;
            final String _tmpFotoItemDesacordoPath;
            if (_cursor.isNull(_cursorIndexOfFotoItemDesacordoPath)) {
              _tmpFotoItemDesacordoPath = null;
            } else {
              _tmpFotoItemDesacordoPath = _cursor.getString(_cursorIndexOfFotoItemDesacordoPath);
            }
            final String _tmpDataHoraTermino;
            if (_cursor.isNull(_cursorIndexOfDataHoraTermino)) {
              _tmpDataHoraTermino = null;
            } else {
              _tmpDataHoraTermino = _cursor.getString(_cursorIndexOfDataHoraTermino);
            }
            final String _tmpAssinaturaVistoriador;
            if (_cursor.isNull(_cursorIndexOfAssinaturaVistoriador)) {
              _tmpAssinaturaVistoriador = null;
            } else {
              _tmpAssinaturaVistoriador = _cursor.getString(_cursorIndexOfAssinaturaVistoriador);
            }
            final String _tmpAssinaturaMotorista;
            if (_cursor.isNull(_cursorIndexOfAssinaturaMotorista)) {
              _tmpAssinaturaMotorista = null;
            } else {
              _tmpAssinaturaMotorista = _cursor.getString(_cursorIndexOfAssinaturaMotorista);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPdfPath;
            if (_cursor.isNull(_cursorIndexOfPdfPath)) {
              _tmpPdfPath = null;
            } else {
              _tmpPdfPath = _cursor.getString(_cursorIndexOfPdfPath);
            }
            _item = new Checklist(_tmpId,_tmpUserId,_tmpLocalColeta,_tmpResponsavel,_tmpData,_tmpPlacaCavalo,_tmpPlacaCarreta,_tmpMotorista,_tmpDiDueCrtMicDta,_tmpNfE,_tmpLacreEntrada,_tmpLacreSaida,_tmpPesoBruto,_tmpTipoViagem,_tmpItem1_parachoque,_tmpItem1_comentario,_tmpItem2_motor,_tmpItem2_comentario,_tmpItem3_pneus,_tmpItem3_comentario,_tmpItem4_unidadeTratora,_tmpItem4_comentario,_tmpItem5_tanquesCombustivel,_tmpItem5_comentario,_tmpItem6_cabine,_tmpItem6_comentario,_tmpItem7_eixoElevatorioAr,_tmpItem7_comentario,_tmpItem8_eixoTransmissao,_tmpItem8_comentario,_tmpItem9_areaQuintaRoda,_tmpItem9_comentario,_tmpItem10_sistemaExaustao,_tmpItem10_comentario,_tmpItem11_chassi,_tmpItem11_comentario,_tmpItem12_portasTraseira,_tmpItem12_comentario,_tmpItem13_portaLateralDireita,_tmpItem13_comentario,_tmpItem14_portaLateralEsquerda,_tmpItem14_comentario,_tmpItem15_paredeFrontal,_tmpItem15_comentario,_tmpItem16_teto,_tmpItem16_comentario,_tmpItem17_pisoCompartimentoCarga,_tmpItem17_comentario,_tmpItem18_dutosAr,_tmpItem18_comentario,_tmpItem19_motorCamaraFria,_tmpItem19_comentario,_tmpOdores,_tmpOdores_comentario,_tmpPragasVisiveis,_tmpPragas_comentario,_tmpContaminacaoQuimica,_tmpContaminacao_comentario,_tmpFundoParedeFalsa,_tmpFundoParede_comentario,_tmpIndiciosContaminacao,_tmpIndicios_comentario,_tmpAutoridadeNotificada,_tmpDataHoraNotificacao,_tmpAutoridade_comentario,_tmpItemEmDesacordo,_tmpFotoItemDesacordoPath,_tmpDataHoraTermino,_tmpAssinaturaVistoriador,_tmpAssinaturaMotorista,_tmpTimestamp,_tmpStatus,_tmpPdfPath);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
