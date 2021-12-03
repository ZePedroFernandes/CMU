package com.example.cmu_room.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\'J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\tH\u0017\u00a8\u0006\u0014"}, d2 = {"Lcom/example/cmu_room/database/GasStationDao;", "", "getAll", "", "Lcom/example/cmu_room/models/GasStation;", "getGasStation", "id", "", "getGasStationAndFuels", "Lcom/example/cmu_room/models/GasStationAndFuels;", "idGasStation", "insertFuel", "", "fuel", "Lcom/example/cmu_room/models/Fuel;", "insertGasStation", "", "gasStation", "insertGasStationAndFuels", "gasStationAndFuels", "app_debug"})
public abstract interface GasStationDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM gasStation")
    public abstract java.util.List<com.example.cmu_room.models.GasStation> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM gasStation WHERE gasStation.id = :id")
    public abstract com.example.cmu_room.models.GasStation getGasStation(int id);
    
    @androidx.room.Insert()
    public abstract long insertGasStation(@org.jetbrains.annotations.NotNull()
    com.example.cmu_room.models.GasStation gasStation);
    
    @androidx.room.Insert()
    public abstract void insertFuel(@org.jetbrains.annotations.NotNull()
    com.example.cmu_room.models.Fuel fuel);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM gasStation WHERE gasStation.id = :idGasStation")
    @androidx.room.Transaction()
    public abstract com.example.cmu_room.models.GasStationAndFuels getGasStationAndFuels(int idGasStation);
    
    @androidx.room.Insert()
    @androidx.room.Transaction()
    public abstract void insertGasStationAndFuels(@org.jetbrains.annotations.NotNull()
    com.example.cmu_room.models.GasStationAndFuels gasStationAndFuels);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        @androidx.room.Insert()
        @androidx.room.Transaction()
        public static void insertGasStationAndFuels(@org.jetbrains.annotations.NotNull()
        com.example.cmu_room.database.GasStationDao $this, @org.jetbrains.annotations.NotNull()
        com.example.cmu_room.models.GasStationAndFuels gasStationAndFuels) {
        }
    }
}