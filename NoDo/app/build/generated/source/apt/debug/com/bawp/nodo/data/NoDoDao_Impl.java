package com.bawp.nodo.data;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.bawp.nodo.model.NoDo;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class NoDoDao_Impl implements NoDoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfNoDo;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteANoDo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNoDoItem;

  public NoDoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNoDo = new EntityInsertionAdapter<NoDo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `nodo_table`(`id`,`nodo_col`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NoDo value) {
        stmt.bindLong(1, value.getId());
        if (value.getNoDo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNoDo());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM nodo_table";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteANoDo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM nodo_table WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNoDoItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE nodo_table SET nodo_col = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(NoDo noDo) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfNoDo.insert(noDo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public int deleteANoDo(int id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteANoDo.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, id);
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteANoDo.release(_stmt);
    }
  }

  @Override
  public int updateNoDoItem(int id, String nodoText) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNoDoItem.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (nodoText == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, nodoText);
      }
      _argIndex = 2;
      _stmt.bindLong(_argIndex, id);
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateNoDoItem.release(_stmt);
    }
  }

  @Override
  public LiveData<List<NoDo>> getAllNoDos() {
    final String _sql = "SELECT * FROM nodo_table ORDER BY nodo_col DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<NoDo>>() {
      private Observer _observer;

      @Override
      protected List<NoDo> compute() {
        if (_observer == null) {
          _observer = new Observer("nodo_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfNoDo = _cursor.getColumnIndexOrThrow("nodo_col");
          final List<NoDo> _result = new ArrayList<NoDo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final NoDo _item;
            final String _tmpNoDo;
            _tmpNoDo = _cursor.getString(_cursorIndexOfNoDo);
            _item = new NoDo(_tmpNoDo);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
    }.getLiveData();
  }
}
