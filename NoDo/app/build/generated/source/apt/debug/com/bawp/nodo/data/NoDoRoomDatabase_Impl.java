package com.bawp.nodo.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class NoDoRoomDatabase_Impl extends NoDoRoomDatabase {
  private volatile NoDoDao _noDoDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `nodo_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nodo_col` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"081bd8c25c5b314b00f28ebee4a7e75a\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `nodo_table`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsNodoTable = new HashMap<String, TableInfo.Column>(2);
        _columnsNodoTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsNodoTable.put("nodo_col", new TableInfo.Column("nodo_col", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNodoTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNodoTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNodoTable = new TableInfo("nodo_table", _columnsNodoTable, _foreignKeysNodoTable, _indicesNodoTable);
        final TableInfo _existingNodoTable = TableInfo.read(_db, "nodo_table");
        if (! _infoNodoTable.equals(_existingNodoTable)) {
          throw new IllegalStateException("Migration didn't properly handle nodo_table(com.bawp.nodo.model.NoDo).\n"
                  + " Expected:\n" + _infoNodoTable + "\n"
                  + " Found:\n" + _existingNodoTable);
        }
      }
    }, "081bd8c25c5b314b00f28ebee4a7e75a", "d762855c8f4c78285d6c6430604a872a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "nodo_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `nodo_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public NoDoDao noDoDao() {
    if (_noDoDao != null) {
      return _noDoDao;
    } else {
      synchronized(this) {
        if(_noDoDao == null) {
          _noDoDao = new NoDoDao_Impl(this);
        }
        return _noDoDao;
      }
    }
  }
}
