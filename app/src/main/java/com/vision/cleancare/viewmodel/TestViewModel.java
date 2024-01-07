package com.vision.cleancare.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {

    private final Context _context;

    public MutableLiveData<Boolean> onBack = new MutableLiveData<>();

    public TestViewModel(Context context) {
        _context = context;
    }

    public void onBackClick() {
        onBack.setValue(true);
    }

    public LiveData<Boolean> isOnBackClicked() {
        return onBack;
    }


}
