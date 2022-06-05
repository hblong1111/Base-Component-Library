package com.hblong.base;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public abstract class ActivityNavigationBase<B extends ViewDataBinding> extends ActivityBase<B> {

    private NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNavigation();
        if (navController != null) {
            navigationViewModel.getIdNavigation().observe(this, id -> {
                navController.navigate(id);
            });
        }
    }

    private void createNavigation() {
        try {
            FragmentContainerView fragmentContainerView = checkViewContainHostFragment();
            if (binding.getRoot() instanceof FragmentContainerView) {
                createController(binding.getRoot());
            } else if (fragmentContainerView != null) {
                createController(fragmentContainerView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private FragmentContainerView checkViewContainHostFragment() {
        ViewGroup viewGroup = (ViewGroup) binding.getRoot();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof FragmentContainerView) {
                return (FragmentContainerView) view;
            }
        }
        return null;
    }

    private void createController(View view) {
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(view.getId());
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
    }

    @Override
    protected abstract int getLayoutId();
}
