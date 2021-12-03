package com.example.cmu_room.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/cmu_room/models/GasStationAndFuels;", "", "gasStation", "Lcom/example/cmu_room/models/GasStation;", "fuels", "", "Lcom/example/cmu_room/models/Fuel;", "(Lcom/example/cmu_room/models/GasStation;Ljava/util/List;)V", "getFuels", "()Ljava/util/List;", "getGasStation", "()Lcom/example/cmu_room/models/GasStation;", "app_debug"})
public final class GasStationAndFuels {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private final com.example.cmu_room.models.GasStation gasStation = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Relation(parentColumn = "id", entityColumn = "gasStationId")
    private final java.util.List<com.example.cmu_room.models.Fuel> fuels = null;
    
    public GasStationAndFuels(@org.jetbrains.annotations.NotNull()
    com.example.cmu_room.models.GasStation gasStation, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.cmu_room.models.Fuel> fuels) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.cmu_room.models.GasStation getGasStation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.cmu_room.models.Fuel> getFuels() {
        return null;
    }
}