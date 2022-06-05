package com.example.basecomponentlibrary;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.basecomponentlibrary.databinding.ActivityMainBinding;
import com.hblong.base.ActivityBase;
import com.hblong.base.ActivityNavigationBase;

public class MainActivity extends ActivityNavigationBase<ActivityMainBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}