package com.example.basecomponentlibrary;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecomponentlibrary.databinding.FragmentSettingBinding;
import com.hblong.base.FragmentBase;
import com.hblong.base.FragmentNavigationBase;

public class SettingFragment extends FragmentNavigationBase<FragmentSettingBinding> {

    private int idItemOld = R.id.itemHome;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.bnvHome.setOnItemSelectedListener(item -> {

            Log.d("longhb", "HomeFragment.onViewCreated: " + item.getItemId());
            int idNavigation = 0;
            switch (idItemOld) {
                case R.id.itemHome:
                    switch (item.getItemId()) {
                        case R.id.itemCoins:
                            idNavigation = R.id.action_homeNAVFragment_to_coinFragment;
                            break;
                        case R.id.itemHistory:
                            idNavigation = R.id.action_homeNAVFragment_to_historyFragment;
                            break;
                        case R.id.itemMore:
                            idNavigation = R.id.action_homeNAVFragment_to_moreFragment;
                            break;
                    }
                    break;
                case R.id.itemCoins:

                    switch (item.getItemId()) {
                        case R.id.itemHome:
                            idNavigation = R.id.action_coinFragment_to_homeNAVFragment;
                            break;
                        case R.id.itemHistory:
                            idNavigation = R.id.action_coinFragment_to_historyFragment;
                            break;
                        case R.id.itemMore:
                            idNavigation = R.id.action_coinFragment_to_moreFragment;
                            break;
                    }
                    break;
                case R.id.itemHistory:

                    switch (item.getItemId()) {
                        case R.id.itemHome:
                            idNavigation = R.id.action_historyFragment_to_homeNAVFragment;
                            break;
                        case R.id.itemCoins:
                            idNavigation = R.id.action_historyFragment_to_coinFragment;
                            break;
                        case R.id.itemMore:
                            idNavigation = R.id.action_historyFragment_to_moreFragment;
                            break;
                    }
                    break;
                case R.id.itemMore:

                    switch (item.getItemId()) {
                        case R.id.itemHome:
                            idNavigation = R.id.action_moreFragment_to_homeNAVFragment;
                            break;
                        case R.id.itemCoins:
                            idNavigation = R.id.action_moreFragment_to_coinFragment;
                            break;
                        case R.id.itemHistory:
                            idNavigation = R.id.action_moreFragment_to_historyFragment;
                            break;
                    }
                    break;
            }

            navigation(idNavigation);
            idItemOld = item.getItemId();
            Log.d("longhb", "SettingFragment.onViewCreated: " + idItemOld);
            return true;
        });
    }
}