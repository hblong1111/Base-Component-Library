package com.hblong.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public abstract class FragmentBase<B extends ViewDataBinding> extends Fragment {
    protected B binding;
    protected NavigationViewModel navigationViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        navigationViewModel = new ViewModelProvider(getActivity()).get(NavigationViewModel.class);
        return binding.getRoot();
    }

    protected abstract int getLayoutId();


    protected void navigation(int id) {
        navigationViewModel.setIdNavigation(id);
    }
}
