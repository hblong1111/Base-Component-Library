package com.hblong.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavigationViewModel extends ViewModel {
    private final MutableLiveData<Integer> idNavigation = new MutableLiveData<>();

    public MutableLiveData<Integer> getIdNavigation() {
        return idNavigation;
    }

    public void setIdNavigation(int value) {
        idNavigation.postValue(value);
    }
}
