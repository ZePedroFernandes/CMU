package com.example.cmu_room;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/cmu_room/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/cmu_room/GasStationFragment$GasStationListComunication;", "Lcom/example/cmu_room/AddGasStationFragment$NoticeDialogListener;", "()V", "gasStationDao", "Lcom/example/cmu_room/database/GasStationDao;", "getGasStationDao", "()Lcom/example/cmu_room/database/GasStationDao;", "gasStationDao$delegate", "Lkotlin/Lazy;", "gasStationList", "", "Lcom/example/cmu_room/models/GasStation;", "listFragment", "Lcom/example/cmu_room/GasStationFragment;", "goToDetails", "", "position", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogNegativeClick", "dialog", "Landroidx/fragment/app/DialogFragment;", "onDialogPositiveClick", "gasStation", "updateList", "gasStatations", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.cmu_room.GasStationFragment.GasStationListComunication, com.example.cmu_room.AddGasStationFragment.NoticeDialogListener {
    private java.util.List<com.example.cmu_room.models.GasStation> gasStationList;
    private final com.example.cmu_room.GasStationFragment listFragment = null;
    private final kotlin.Lazy gasStationDao$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.cmu_room.database.GasStationDao getGasStationDao() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void updateList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.cmu_room.models.GasStation> gasStatations) {
    }
    
    @java.lang.Override()
    public void goToDetails(int position) {
    }
    
    @java.lang.Override()
    public void onDialogPositiveClick(@org.jetbrains.annotations.NotNull()
    com.example.cmu_room.models.GasStation gasStation) {
    }
    
    @java.lang.Override()
    public void onDialogNegativeClick(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.DialogFragment dialog) {
    }
}