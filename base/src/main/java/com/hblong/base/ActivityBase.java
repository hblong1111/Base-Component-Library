package com.hblong.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.hblong.base.databinding.ActivityTestBinding;

public abstract class ActivityBase<B extends ViewDataBinding> extends AppCompatActivity {
    protected B binding;

    protected NavigationViewModel navigationViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), null, false);
        setContentView(binding.getRoot());
        navigationViewModel = new ViewModelProvider(this).get(NavigationViewModel.class);
    }

    protected abstract int getLayoutId();

    protected void navigation(int id) {
        navigationViewModel.setIdNavigation(id);
    }
}
