package com.example.basecomponentlibrary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecomponentlibrary.databinding.FragmentSettingBinding;
import com.hblong.base.FragmentBase;

public class SettingFragment extends FragmentBase<FragmentSettingBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }
}