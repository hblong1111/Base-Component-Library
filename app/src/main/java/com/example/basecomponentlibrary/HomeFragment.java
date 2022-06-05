package com.example.basecomponentlibrary;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecomponentlibrary.databinding.FragmentHomeBinding;
import com.hblong.base.FragmentBase;

public class HomeFragment extends FragmentBase<FragmentHomeBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigation(R.id.action_homeFragment_to_settingFragment);
    }
}