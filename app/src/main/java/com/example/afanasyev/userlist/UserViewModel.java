package com.example.afanasyev.userlist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class UserViewModel extends BaseObservable {
    private String fullName;
    private boolean isSelected;

    public UserViewModel(String fullName) {
        this.fullName = fullName;
        notifyPropertyChanged(BR.fullName);
    }

    @Bindable
    public boolean getIsSelected() {
        return isSelected;
    }

    public void onClick() {
        isSelected = !isSelected;
        notifyPropertyChanged(BR.isSelected);
    }

    @Bindable
    public String getFullName() {
        return fullName;
    }
}