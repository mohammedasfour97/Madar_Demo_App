package com.example.madartestapp.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madartestapp.R;
import com.example.madartestapp.User;
import com.example.madartestapp.ViewModels.UserViewModel;
import com.example.madartestapp.Adapters.UsersAdapter;
import com.example.madartestapp.databinding.FragmentShowUsersBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShowUsersFragment extends Fragment {

    private FragmentShowUsersBinding fragmentShowUsersBinding;
    private NavController navController;
    private RecyclerView recyclerView;
    private UsersAdapter usersAdapter;
    private List<User> userList;
    private UserViewModel userViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentShowUsersBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_show_users, container,
                false);

        View view = fragmentShowUsersBinding.getRoot();

        return view;
    }

    @Nullable
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);

        initRecyclerView();

        fragmentShowUsersBinding.showUsersBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigateUp();
            }
        });

        userViewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);

        requestUserList();


    }


    private void initRecyclerView(){

        recyclerView = fragmentShowUsersBinding.showUsersRecyclerview;

        userList = new ArrayList<>();
        usersAdapter = new UsersAdapter(userList , getContext());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(usersAdapter);

    }


    private void requestUserList(){

        userViewModel.get_all_users().observe(getActivity(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {

                userList.addAll(users);
                usersAdapter.notifyDataSetChanged();
            }
        });
    }
    }
