package com.example.cmu_room.database;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.cmu_room.models.Fuel;
import com.example.cmu_room.models.GasStation;
import com.example.cmu_room.models.GasStationAndFuels;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GasStationDao_Impl implements GasStationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GasStation> __insertionAdapterOfGasStation;

  private final EntityInsertionAdapter<Fuel> __insertionAdapterOfFuel;

  private final Converters __converters = new Converters();

  public GasStationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGasStation = new EntityInsertionAdapter<GasStation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `GasStation` (`id`,`name`,`address`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GasStation value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        stmt.bindDouble(4, value.getLatitude());
        stmt.bindDouble(5, value.getLongitude());
      }
    };
    this.__insertionAdapterOfFuel = new EntityInsertionAdapter<Fuel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Fuel` (`fuelName`,`price`,`date`,`gasStationId`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Fuel value) {
        if (value.getFuelName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFuelName());
        }
        stmt.bindDouble(2, value.getPrice());
        final Long _tmp;
        _tmp = __converters.dateToTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        stmt.bindLong(4, value.getGasStationId());
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public long insertGasStation(final GasStation gasStation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfGasStation.insertAndReturnId(gasStation);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertFuel(final Fuel fuel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFuel.insert(fuel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<GasStation> getAll() {
    final String _sql = "SELECT * FROM gasStation";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final List<GasStation> _result = new ArrayList<GasStation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final GasStation _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        final double _tmpLongitude;
        _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        _item = new GasStation(_tmpId,_tmpName,_tmpAddress,_tmpLatitude,_tmpLongitude);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GasStation getGasStation(final int id) {
    final String _sql = "SELECT * FROM gasStation WHERE gasStation.id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final GasStation _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        final double _tmpLongitude;
        _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        _result = new GasStation(_tmpId,_tmpName,_tmpAddress,_tmpLatitude,_tmpLongitude);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GasStationAndFuels getGasStationAndFuels(final int idGasStation) {
    final String _sql = "SELECT * FROM gasStation WHERE gasStation.id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idGasStation);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
        final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
        final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
        final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
        final LongSparseArray<ArrayList<Fuel>> _collectionFuels = new LongSparseArray<ArrayList<Fuel>>();
        while (_cursor.moveToNext()) {
          final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
          ArrayList<Fuel> _tmpFuelsCollection = _collectionFuels.get(_tmpKey);
          if (_tmpFuelsCollection == null) {
            _tmpFuelsCollection = new ArrayList<Fuel>();
            _collectionFuels.put(_tmpKey, _tmpFuelsCollection);
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipFuelAscomExampleCmuRoomModelsFuel(_collectionFuels);
        final GasStationAndFuels _result;
        if(_cursor.moveToFirst()) {
          final GasStation _tmpGasStation;
          if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfAddress) && _cursor.isNull(_cursorIndexOfLatitude) && _cursor.isNull(_cursorIndexOfLongitude))) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            _tmpGasStation = new GasStation(_tmpId,_tmpName,_tmpAddress,_tmpLatitude,_tmpLongitude);
          }  else  {
            _tmpGasStation = null;
          }
          ArrayList<Fuel> _tmpFuelsCollection_1 = null;
          final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
          _tmpFuelsCollection_1 = _collectionFuels.get(_tmpKey_1);
          if (_tmpFuelsCollection_1 == null) {
            _tmpFuelsCollection_1 = new ArrayList<Fuel>();
          }
          _result = new GasStationAndFuels(_tmpGasStation,_tmpFuelsCollection_1);
        } else {
          _result = null;
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertGasStationAndFuels(final GasStationAndFuels gasStationAndFuels) {
    GasStationDao.DefaultImpls.insertGasStationAndFuels(GasStationDao_Impl.this, gasStationAndFuels);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipFuelAscomExampleCmuRoomModelsFuel(
      final LongSparseArray<ArrayList<Fuel>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<Fuel>> _tmpInnerMap = new LongSparseArray<ArrayList<Fuel>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipFuelAscomExampleCmuRoomModelsFuel(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<Fuel>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipFuelAscomExampleCmuRoomModelsFuel(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `fuelName`,`price`,`date`,`gasStationId`,`id` FROM `Fuel` WHERE `gasStationId` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "gasStationId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfFuelName = CursorUtil.getColumnIndexOrThrow(_cursor, "fuelName");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfGasStationId = CursorUtil.getColumnIndexOrThrow(_cursor, "gasStationId");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        ArrayList<Fuel> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final Fuel _item_1;
          final String _tmpFuelName;
          if (_cursor.isNull(_cursorIndexOfFuelName)) {
            _tmpFuelName = null;
          } else {
            _tmpFuelName = _cursor.getString(_cursorIndexOfFuelName);
          }
          final double _tmpPrice;
          _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
          final LocalDateTime _tmpDate;
          final Long _tmp;
          if (_cursor.isNull(_cursorIndexOfDate)) {
            _tmp = null;
          } else {
            _tmp = _cursor.getLong(_cursorIndexOfDate);
          }
          _tmpDate = __converters.fromTimestamp(_tmp);
          final int _tmpGasStationId;
          _tmpGasStationId = _cursor.getInt(_cursorIndexOfGasStationId);
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _item_1 = new Fuel(_tmpFuelName,_tmpPrice,_tmpDate,_tmpGasStationId,_tmpId);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
