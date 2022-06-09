package com.example.basecomponentlibrary;


import com.example.basecomponentlibrary.databinding.FragmentCoinBinding;
import com.hblong.base.FragmentBase;

public class CoinFragment extends FragmentBase<FragmentCoinBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_coin;
    }
}