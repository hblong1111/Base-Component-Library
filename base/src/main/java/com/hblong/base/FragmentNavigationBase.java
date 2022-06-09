package com.hblong.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public abstract class FragmentNavigationBase<B extends ViewDataBinding> extends FragmentBase<B> {

    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        createNavigation();
        if (navController != null) {
            navigationViewModel.getIdNavigation().observe(getActivity(), id -> {
                try {
                    navController.navigate(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        return super.onCreateView(inflater, container, savedInstanceState);
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
                (NavHostFragment) getChildFragmentManager().findFragmentById(view.getId());
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
    }

    @Override
    protected abstract int getLayoutId();
}
