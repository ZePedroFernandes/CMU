package com.example.cmu_room.database;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.example.cmu_room.database.Converters.class})
@androidx.room.Database(entities = {com.example.cmu_room.models.GasStation.class, com.example.cmu_room.models.Fuel.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/cmu_room/database/GasStationDB;", "Landroidx/room/RoomDatabase;", "()V", "gasStationDao", "Lcom/example/cmu_room/database/GasStationDao;", "Companion", "app_debug"})
public abstract class GasStationDB extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cmu_room.database.GasStationDB.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.example.cmu_room.database.GasStationDB instance;
    private static final java.util.concurrent.ExecutorService executors = null;
    
    public GasStationDB() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.cmu_room.database.GasStationDao gasStationDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/example/cmu_room/database/GasStationDB$Companion;", "", "()V", "executors", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getExecutors", "()Ljava/util/concurrent/ExecutorService;", "instance", "Lcom/example/cmu_room/database/GasStationDB;", "getInstance", "()Lcom/example/cmu_room/database/GasStationDB;", "setInstance", "(Lcom/example/cmu_room/database/GasStationDB;)V", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.cmu_room.database.GasStationDB getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.Nullable()
        com.example.cmu_room.database.GasStationDB p0) {
        }
        
        public final java.util.concurrent.ExecutorService getExecutors() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.cmu_room.database.GasStationDB getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}