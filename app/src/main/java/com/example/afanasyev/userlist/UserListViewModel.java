package com.example.afanasyev.userlist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.JsonPlaceholderService;
import services.UserModel;

public class UserListViewModel extends BaseObservable {
    private ArrayList<UserViewModel> users = new ArrayList<>();
    private boolean isLoading = false;

    private JsonPlaceholderService service;

    public UserListViewModel(JsonPlaceholderService service) {
        this.service = service;
        loadUsers();
    }

    @Bindable
    public ArrayList<UserViewModel> getUsers() {
        return users;
    }

    @Bindable
    public boolean getIsLoading() {
        return this.isLoading;
    }

    private void setLoading(boolean value) {
        this.isLoading = value;
        notifyPropertyChanged(BR.isLoading);
    }

    public void loadUsers() {
        Call<List<UserModel>> call = service.listUsers();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                try {
                    setLoading(true);
                    users.clear();
                    for (UserModel model: response.body()) {
                        users.add(new UserViewModel(model.getName()));
                    }
                    notifyPropertyChanged(BR.users);
                }
                finally {
                    setLoading(false);
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.d("TAG", "onResponse: " + String.valueOf(t));
            }
        });
    }
}
