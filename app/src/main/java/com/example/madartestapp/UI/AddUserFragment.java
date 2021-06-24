package com.example.madartestapp.UI;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.example.madartestapp.R;
import com.example.madartestapp.User;
import com.example.madartestapp.RoomDB.UserViewModel;
import com.example.madartestapp.databinding.FragmentAddUserBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class AddUserFragment extends Fragment {

    private UserViewModel userViewModel;
    private FragmentAddUserBinding fragmentAddUserBinding;
    private User inserted_user;
    private String  selected_gender;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentAddUserBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_add_user, container, false);

        View view = fragmentAddUserBinding.getRoot();

        return view;
    }

    @Nullable
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        userViewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);

        navController = navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);

        selected_gender = "Male";
        //set selected gender layout color
        fragmentAddUserBinding.addUserMaleLinLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selected_gender = "Male";

                setSelectedGenderLayout(fragmentAddUserBinding.addUserMaleLinLayout , fragmentAddUserBinding.addUserFemaleLinLayout ,
                        fragmentAddUserBinding.addUserMaleTxt , fragmentAddUserBinding.addUserFemaleTxt ,
                        fragmentAddUserBinding.addUserMaleImg);

                fragmentAddUserBinding.addUserMaleImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_male_white));
                fragmentAddUserBinding.addUserFemaleImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_female_prim));
            }
        });

        fragmentAddUserBinding.addUserFemaleLinLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selected_gender = "Female";

                setSelectedGenderLayout(fragmentAddUserBinding.addUserFemaleLinLayout , fragmentAddUserBinding.addUserMaleLinLayout ,
                        fragmentAddUserBinding.addUserFemaleTxt , fragmentAddUserBinding.addUserMaleTxt ,
                        fragmentAddUserBinding.addUserFemaleImg);

                fragmentAddUserBinding.addUserFemaleImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_female_white));
                fragmentAddUserBinding.addUserMaleImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_male_prim));
            }
        });

        fragmentAddUserBinding.addUserShowUsersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_fragment_add_user_to_fragment_show_users);
            }
        });
        //set selected gender layout color


        // set add user button action
        fragmentAddUserBinding.addUserAddUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AwesomeSuccessDialog(getContext())
                        .setTitle(R.string.add_new_user)
                        .setMessage(R.string.sure_add_user)
                        .setColoredCircle(R.color.dialogSuccessBackgroundColor)
                        .setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)
                        .setCancelable(false)
                        .setPositiveButtonText(getString(R.string.yes))
                        .setPositiveButtonbackgroundColor(R.color.dialogSuccessBackgroundColor)
                        .setPositiveButtonTextColor(R.color.white)
                        .setNegativeButtonText(getString(R.string.no))
                        .setNegativeButtonbackgroundColor(R.color.dialogSuccessBackgroundColor)
                        .setNegativeButtonTextColor(R.color.white)
                        .setPositiveButtonClick(new Closure() {
                            @Override
                            public void exec() {
                                addNewUser();
                            }
                        })
                        .show();
            }
        });
        // set add user button action
    }


    private void setSelectedGenderLayout(LinearLayoutCompat selected_linearLayoutCompat ,
                                         LinearLayoutCompat un_selected_linearLayoutCompat , MaterialTextView selected_textView ,
                                         MaterialTextView un_selected_textView , AppCompatImageView imageView){

        selected_linearLayoutCompat.setBackground(getResources().getDrawable(R.drawable.prim_solid));
        un_selected_linearLayoutCompat.setBackground(getResources().getDrawable(R.drawable.white_solid_prim_stroke_30));

        selected_textView.setTextColor(getResources().getColor(R.color.white));
        un_selected_textView.setTextColor(getResources().getColor(R.color.design_default_color_primary));
    }


    private boolean getTextFromEditTexts() {

        if (TextUtils.isEmpty(fragmentAddUserBinding.addUserNameEdt.getText())) {

            fragmentAddUserBinding.addUserNameEdt.setError(getResources().getString(R.string.enter_name));
            return false;
        } else if (TextUtils.isEmpty(fragmentAddUserBinding.addUserAgeEdt.getText())) {

            fragmentAddUserBinding.addUserAgeEdt.setError(getResources().getString(R.string.enter_age));
            return false;
        } else if (TextUtils.isEmpty(fragmentAddUserBinding.addUserJobTitleEdt.getText())) {

            fragmentAddUserBinding.addUserJobTitleEdt.setError(getResources().getString(R.string.enter_job_title));
            return false;
        } else {

            inserted_user = new User(fragmentAddUserBinding.addUserNameEdt.getText().toString() ,
                    fragmentAddUserBinding.addUserAgeEdt.getText().toString() ,
                    fragmentAddUserBinding.addUserJobTitleEdt.getText().toString() , selected_gender);
            return true;
        }
    }

    private void addNewUser(){

        if (getTextFromEditTexts()){

            userViewModel.insertUser(inserted_user);

            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                    getResources().getString(R.string.succ_add_user), Snackbar.LENGTH_LONG);
            snackbar.show();

            navController.navigate(R.id.action_fragment_add_user_to_fragment_show_users);
        }
    }
}
