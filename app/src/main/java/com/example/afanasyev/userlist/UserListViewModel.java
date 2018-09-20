package com.example.afanasyev.userlist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;

public class UserListViewModel extends BaseObservable {
    private ArrayList<UserViewModel> users = new ArrayList<>();

    public UserListViewModel() {
        fillUsers();
    }

    @Bindable
    public ArrayList<UserViewModel> getUsers() {
        return users;
    }

    private void fillUsers() {
        for (int i = 0; i < 20; i++) {
            users.add(new UserViewModel("user: " + i));
        }
        notifyPropertyChanged(BR.users);
    }
}
