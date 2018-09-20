package com.example.afanasyev.userlist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class UserViewModel extends BaseObservable {
    private String fullName;

    public UserViewModel(String fullName) {
        this.fullName = fullName;
        notifyPropertyChanged(BR.fullName);
    }

    @Bindable
    public String getFullName() {
        return fullName;
    }
}