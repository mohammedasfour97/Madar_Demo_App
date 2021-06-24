package com.example.madartestapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.madartestapp.R;
import com.example.madartestapp.User;
import com.example.madartestapp.databinding.UserItemBinding;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private List<User> UserList;
    Context context;


    public static class UsersViewHolder extends RecyclerView.ViewHolder {

        private UserItemBinding userItemBinding;


        public UsersViewHolder(UserItemBinding userItemBinding) {
            super(userItemBinding.getRoot());
            this.userItemBinding = userItemBinding;
        }

    }

    public UsersAdapter(List<User> UserList, Context context) {
        this.UserList = UserList;
        this.context = context;

    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {

        User user = UserList.get(position);

        holder.userItemBinding.setUser(user);

        if (user.getGender().equals("Male")) holder.userItemBinding.userItemGenderImg.setImageDrawable(holder.userItemBinding.getRoot()
        .getResources().getDrawable(R.drawable.ic_male_prim));
        else holder.userItemBinding.userItemGenderImg.setImageDrawable(holder.userItemBinding.getRoot()
                .getResources().getDrawable(R.drawable.ic_female_prim));


    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserItemBinding userItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.user_item, parent, false);
        return new UsersViewHolder(userItemBinding);

    }


    @Override
    public int getItemCount() {
        return UserList.size();
    }
}