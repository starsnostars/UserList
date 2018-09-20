package com.example.afanasyev.userlist;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.afanasyev.userlist.databinding.ActivityMainBinding;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.JsonPlaceholderService;

public class UserListActivity extends AppCompatActivity {
    private UserListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonPlaceholderService service = retrofit.create(JsonPlaceholderService.class);

            ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            this.viewModel = new UserListViewModel(service);
            UserListAdapter adapter = new UserListAdapter();
            binding.setViewModel(viewModel);
            binding.setAdapter(adapter);

            RecyclerView rv = binding.getRoot().findViewById(R.id.usersListView);
            rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        } catch (RuntimeException e) {
            Log.d("TAG", "onCreate: " + String.valueOf(e));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.viewModel.loadUsers();
    }
}
