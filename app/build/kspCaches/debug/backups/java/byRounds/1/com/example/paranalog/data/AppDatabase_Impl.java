package com.example.paranalog.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile VehicleDao _vehicleDao;

  private volatile ChecklistDao _checklistDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `cpf` TEXT NOT NULL, `passwordHash` TEXT NOT NULL, `defaultPlateCavalo` TEXT, `defaultPlateCarreta` TEXT)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_users_cpf` ON `users` (`cpf`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `vehicles` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `plate` TEXT NOT NULL, `description` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `checklists` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `localColeta` TEXT, `responsavel` TEXT, `data` TEXT, `placaCavalo` TEXT, `placaCarreta` TEXT, `motorista` TEXT, `diDueCrtMicDta` TEXT, `nfE` TEXT, `lacreEntrada` TEXT, `lacreSaida` TEXT, `pesoBruto` TEXT, `tipoViagem` TEXT, `item1_parachoque` TEXT, `item1_comentario` TEXT, `item2_motor` TEXT, `item2_comentario` TEXT, `item3_pneus` TEXT, `item3_comentario` TEXT, `item4_unidadeTratora` TEXT, `item4_comentario` TEXT, `item5_tanquesCombustivel` TEXT, `item5_comentario` TEXT, `item6_cabine` TEXT, `item6_comentario` TEXT, `item7_eixoElevatorioAr` TEXT, `item7_comentario` TEXT, `item8_eixoTransmissao` TEXT, `item8_comentario` TEXT, `item9_areaQuintaRoda` TEXT, `item9_comentario` TEXT, `item10_sistemaExaustao` TEXT, `item10_comentario` TEXT, `item11_chassi` TEXT, `item11_comentario` TEXT, `item12_portasTraseira` TEXT, `item12_comentario` TEXT, `item13_portaLateralDireita` TEXT, `item13_comentario` TEXT, `item14_portaLateralEsquerda` TEXT, `item14_comentario` TEXT, `item15_paredeFrontal` TEXT, `item15_comentario` TEXT, `item16_teto` TEXT, `item16_comentario` TEXT, `item17_pisoCompartimentoCarga` TEXT, `item17_comentario` TEXT, `item18_dutosAr` TEXT, `item18_comentario` TEXT, `item19_motorCamaraFria` TEXT, `item19_comentario` TEXT, `odores` TEXT, `odores_comentario` TEXT, `pragasVisiveis` TEXT, `pragas_comentario` TEXT, `contaminacaoQuimica` TEXT, `contaminacao_comentario` TEXT, `fundoParedeFalsa` TEXT, `fundoParede_comentario` TEXT, `indiciosContaminacao` TEXT, `indicios_comentario` TEXT, `autoridadeNotificada` INTEGER, `dataHoraNotificacao` TEXT, `autoridade_comentario` TEXT, `itemEmDesacordo` INTEGER NOT NULL, `fotoItemDesacordoPath` TEXT, `dataHoraTermino` TEXT, `assinaturaVistoriador` TEXT, `assinaturaMotorista` TEXT, `timestamp` INTEGER NOT NULL, `status` TEXT NOT NULL, `pdfPath` TEXT, FOREIGN KEY(`userId`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_checklists_userId` ON `checklists` (`userId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6db2b96db9a9c306b45e8529c8093637')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `vehicles`");
        db.execSQL("DROP TABLE IF EXISTS `checklists`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(6);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("cpf", new TableInfo.Column("cpf", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("passwordHash", new TableInfo.Column("passwordHash", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("defaultPlateCavalo", new TableInfo.Column("defaultPlateCavalo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("defaultPlateCarreta", new TableInfo.Column("defaultPlateCarreta", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(1);
        _indicesUsers.add(new TableInfo.Index("index_users_cpf", true, Arrays.asList("cpf"), Arrays.asList("ASC")));
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.example.paranalog.data.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsVehicles = new HashMap<String, TableInfo.Column>(3);
        _columnsVehicles.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVehicles.put("plate", new TableInfo.Column("plate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVehicles.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVehicles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVehicles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVehicles = new TableInfo("vehicles", _columnsVehicles, _foreignKeysVehicles, _indicesVehicles);
        final TableInfo _existingVehicles = TableInfo.read(db, "vehicles");
        if (!_infoVehicles.equals(_existingVehicles)) {
          return new RoomOpenHelper.ValidationResult(false, "vehicles(com.example.paranalog.data.Vehicle).\n"
                  + " Expected:\n" + _infoVehicles + "\n"
                  + " Found:\n" + _existingVehicles);
        }
        final HashMap<String, TableInfo.Column> _columnsChecklists = new HashMap<String, TableInfo.Column>(73);
        _columnsChecklists.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("localColeta", new TableInfo.Column("localColeta", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("responsavel", new TableInfo.Column("responsavel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("placaCavalo", new TableInfo.Column("placaCavalo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("placaCarreta", new TableInfo.Column("placaCarreta", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("motorista", new TableInfo.Column("motorista", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("diDueCrtMicDta", new TableInfo.Column("diDueCrtMicDta", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("nfE", new TableInfo.Column("nfE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("lacreEntrada", new TableInfo.Column("lacreEntrada", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("lacreSaida", new TableInfo.Column("lacreSaida", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("pesoBruto", new TableInfo.Column("pesoBruto", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("tipoViagem", new TableInfo.Column("tipoViagem", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item1_parachoque", new TableInfo.Column("item1_parachoque", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item1_comentario", new TableInfo.Column("item1_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item2_motor", new TableInfo.Column("item2_motor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item2_comentario", new TableInfo.Column("item2_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item3_pneus", new TableInfo.Column("item3_pneus", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item3_comentario", new TableInfo.Column("item3_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item4_unidadeTratora", new TableInfo.Column("item4_unidadeTratora", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item4_comentario", new TableInfo.Column("item4_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item5_tanquesCombustivel", new TableInfo.Column("item5_tanquesCombustivel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item5_comentario", new TableInfo.Column("item5_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item6_cabine", new TableInfo.Column("item6_cabine", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item6_comentario", new TableInfo.Column("item6_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item7_eixoElevatorioAr", new TableInfo.Column("item7_eixoElevatorioAr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item7_comentario", new TableInfo.Column("item7_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item8_eixoTransmissao", new TableInfo.Column("item8_eixoTransmissao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item8_comentario", new TableInfo.Column("item8_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item9_areaQuintaRoda", new TableInfo.Column("item9_areaQuintaRoda", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item9_comentario", new TableInfo.Column("item9_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item10_sistemaExaustao", new TableInfo.Column("item10_sistemaExaustao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item10_comentario", new TableInfo.Column("item10_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item11_chassi", new TableInfo.Column("item11_chassi", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item11_comentario", new TableInfo.Column("item11_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item12_portasTraseira", new TableInfo.Column("item12_portasTraseira", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item12_comentario", new TableInfo.Column("item12_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item13_portaLateralDireita", new TableInfo.Column("item13_portaLateralDireita", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item13_comentario", new TableInfo.Column("item13_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item14_portaLateralEsquerda", new TableInfo.Column("item14_portaLateralEsquerda", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item14_comentario", new TableInfo.Column("item14_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item15_paredeFrontal", new TableInfo.Column("item15_paredeFrontal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item15_comentario", new TableInfo.Column("item15_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item16_teto", new TableInfo.Column("item16_teto", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item16_comentario", new TableInfo.Column("item16_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item17_pisoCompartimentoCarga", new TableInfo.Column("item17_pisoCompartimentoCarga", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item17_comentario", new TableInfo.Column("item17_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item18_dutosAr", new TableInfo.Column("item18_dutosAr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item18_comentario", new TableInfo.Column("item18_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item19_motorCamaraFria", new TableInfo.Column("item19_motorCamaraFria", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("item19_comentario", new TableInfo.Column("item19_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("odores", new TableInfo.Column("odores", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("odores_comentario", new TableInfo.Column("odores_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("pragasVisiveis", new TableInfo.Column("pragasVisiveis", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("pragas_comentario", new TableInfo.Column("pragas_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("contaminacaoQuimica", new TableInfo.Column("contaminacaoQuimica", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("contaminacao_comentario", new TableInfo.Column("contaminacao_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("fundoParedeFalsa", new TableInfo.Column("fundoParedeFalsa", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("fundoParede_comentario", new TableInfo.Column("fundoParede_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("indiciosContaminacao", new TableInfo.Column("indiciosContaminacao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("indicios_comentario", new TableInfo.Column("indicios_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("autoridadeNotificada", new TableInfo.Column("autoridadeNotificada", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("dataHoraNotificacao", new TableInfo.Column("dataHoraNotificacao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("autoridade_comentario", new TableInfo.Column("autoridade_comentario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("itemEmDesacordo", new TableInfo.Column("itemEmDesacordo", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("fotoItemDesacordoPath", new TableInfo.Column("fotoItemDesacordoPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("dataHoraTermino", new TableInfo.Column("dataHoraTermino", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("assinaturaVistoriador", new TableInfo.Column("assinaturaVistoriador", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("assinaturaMotorista", new TableInfo.Column("assinaturaMotorista", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChecklists.put("pdfPath", new TableInfo.Column("pdfPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChecklists = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysChecklists.add(new TableInfo.ForeignKey("users", "CASCADE", "NO ACTION", Arrays.asList("userId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChecklists = new HashSet<TableInfo.Index>(1);
        _indicesChecklists.add(new TableInfo.Index("index_checklists_userId", false, Arrays.asList("userId"), Arrays.asList("ASC")));
        final TableInfo _infoChecklists = new TableInfo("checklists", _columnsChecklists, _foreignKeysChecklists, _indicesChecklists);
        final TableInfo _existingChecklists = TableInfo.read(db, "checklists");
        if (!_infoChecklists.equals(_existingChecklists)) {
          return new RoomOpenHelper.ValidationResult(false, "checklists(com.example.paranalog.data.Checklist).\n"
                  + " Expected:\n" + _infoChecklists + "\n"
                  + " Found:\n" + _existingChecklists);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6db2b96db9a9c306b45e8529c8093637", "228e3db5bc2bbb41e86aa7ae706b83c7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","vehicles","checklists");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `vehicles`");
      _db.execSQL("DELETE FROM `checklists`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(VehicleDao.class, VehicleDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChecklistDao.class, ChecklistDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public VehicleDao vehicleDao() {
    if (_vehicleDao != null) {
      return _vehicleDao;
    } else {
      synchronized(this) {
        if(_vehicleDao == null) {
          _vehicleDao = new VehicleDao_Impl(this);
        }
        return _vehicleDao;
      }
    }
  }

  @Override
  public ChecklistDao checklistDao() {
    if (_checklistDao != null) {
      return _checklistDao;
    } else {
      synchronized(this) {
        if(_checklistDao == null) {
          _checklistDao = new ChecklistDao_Impl(this);
        }
        return _checklistDao;
      }
    }
  }
}
