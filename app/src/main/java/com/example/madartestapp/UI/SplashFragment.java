package com.example.madartestapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.madartestapp.R;
import com.example.madartestapp.databinding.FragmentSplashBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

public class SplashFragment extends Fragment {

    private FragmentSplashBinding fragmentSplashBinding;
    private NavController navController;
    private static final int SPLASH_DISPLAY_LENGTH = 3000;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentSplashBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_splash, container,
                false);

        View view = fragmentSplashBinding.getRoot();

        return view;
    }

    @Nullable
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination,
                                             @Nullable Bundle arguments) {


            }
        });
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                navController.navigate(R.id.action_splash_fragment_to_fragment_add_user);

            }
        }, SPLASH_DISPLAY_LENGTH);
}
}
