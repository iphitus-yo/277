package com.example.paranalog.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `users` (`id`,`name`,`cpf`,`passwordHash`,`defaultPlateCavalo`,`defaultPlateCarreta`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getCpf());
        statement.bindString(4, entity.getPasswordHash());
        if (entity.getDefaultPlateCavalo() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDefaultPlateCavalo());
        }
        if (entity.getDefaultPlateCarreta() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDefaultPlateCarreta());
        }
      }
    };
  }

  @Override
  public Object insert(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUser.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserByCpf(final String cpf, final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM users WHERE cpf = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, cpf);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCpf = CursorUtil.getColumnIndexOrThrow(_cursor, "cpf");
          final int _cursorIndexOfPasswordHash = CursorUtil.getColumnIndexOrThrow(_cursor, "passwordHash");
          final int _cursorIndexOfDefaultPlateCavalo = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultPlateCavalo");
          final int _cursorIndexOfDefaultPlateCarreta = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultPlateCarreta");
          final User _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpCpf;
            _tmpCpf = _cursor.getString(_cursorIndexOfCpf);
            final String _tmpPasswordHash;
            _tmpPasswordHash = _cursor.getString(_cursorIndexOfPasswordHash);
            final String _tmpDefaultPlateCavalo;
            if (_cursor.isNull(_cursorIndexOfDefaultPlateCavalo)) {
              _tmpDefaultPlateCavalo = null;
            } else {
              _tmpDefaultPlateCavalo = _cursor.getString(_cursorIndexOfDefaultPlateCavalo);
            }
            final String _tmpDefaultPlateCarreta;
            if (_cursor.isNull(_cursorIndexOfDefaultPlateCarreta)) {
              _tmpDefaultPlateCarreta = null;
            } else {
              _tmpDefaultPlateCarreta = _cursor.getString(_cursorIndexOfDefaultPlateCarreta);
            }
            _result = new User(_tmpId,_tmpName,_tmpCpf,_tmpPasswordHash,_tmpDefaultPlateCavalo,_tmpDefaultPlateCarreta);
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
  public Object getUserById(final long id, final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM users WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCpf = CursorUtil.getColumnIndexOrThrow(_cursor, "cpf");
          final int _cursorIndexOfPasswordHash = CursorUtil.getColumnIndexOrThrow(_cursor, "passwordHash");
          final int _cursorIndexOfDefaultPlateCavalo = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultPlateCavalo");
          final int _cursorIndexOfDefaultPlateCarreta = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultPlateCarreta");
          final User _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpCpf;
            _tmpCpf = _cursor.getString(_cursorIndexOfCpf);
            final String _tmpPasswordHash;
            _tmpPasswordHash = _cursor.getString(_cursorIndexOfPasswordHash);
            final String _tmpDefaultPlateCavalo;
            if (_cursor.isNull(_cursorIndexOfDefaultPlateCavalo)) {
              _tmpDefaultPlateCavalo = null;
            } else {
              _tmpDefaultPlateCavalo = _cursor.getString(_cursorIndexOfDefaultPlateCavalo);
            }
            final String _tmpDefaultPlateCarreta;
            if (_cursor.isNull(_cursorIndexOfDefaultPlateCarreta)) {
              _tmpDefaultPlateCarreta = null;
            } else {
              _tmpDefaultPlateCarreta = _cursor.getString(_cursorIndexOfDefaultPlateCarreta);
            }
            _result = new User(_tmpId,_tmpName,_tmpCpf,_tmpPasswordHash,_tmpDefaultPlateCavalo,_tmpDefaultPlateCarreta);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
