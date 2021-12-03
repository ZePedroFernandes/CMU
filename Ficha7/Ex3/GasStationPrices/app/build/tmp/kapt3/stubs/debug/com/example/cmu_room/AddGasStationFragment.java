package com.example.cmu_room;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/example/cmu_room/AddGasStationFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "listener", "Lcom/example/cmu_room/AddGasStationFragment$NoticeDialogListener;", "getListener$app_debug", "()Lcom/example/cmu_room/AddGasStationFragment$NoticeDialogListener;", "setListener$app_debug", "(Lcom/example/cmu_room/AddGasStationFragment$NoticeDialogListener;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "NoticeDialogListener", "app_debug"})
public final class AddGasStationFragment extends androidx.fragment.app.DialogFragment {
    public com.example.cmu_room.AddGasStationFragment.NoticeDialogListener listener;
    
    public AddGasStationFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.cmu_room.AddGasStationFragment.NoticeDialogListener getListener$app_debug() {
        return null;
    }
    
    public final void setListener$app_debug(@org.jetbrains.annotations.NotNull()
    com.example.cmu_room.AddGasStationFragment.NoticeDialogListener p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/cmu_room/AddGasStationFragment$NoticeDialogListener;", "", "onDialogNegativeClick", "", "dialog", "Landroidx/fragment/app/DialogFragment;", "onDialogPositiveClick", "gasStation", "Lcom/example/cmu_room/models/GasStation;", "app_debug"})
    public static abstract interface NoticeDialogListener {
        
        public abstract void onDialogPositiveClick(@org.jetbrains.annotations.NotNull()
        com.example.cmu_room.models.GasStation gasStation);
        
        public abstract void onDialogNegativeClick(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.DialogFragment dialog);
    }
}