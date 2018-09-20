package com.example.afanasyev.userlist;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.afanasyev.userlist.databinding.ActivityMainBinding;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            UserListViewModel viewModel = new UserListViewModel();
            UserListAdapter adapter = new UserListAdapter();
            binding.setViewModel(viewModel);
            binding.setAdapter(adapter);

            RecyclerView rv = binding.getRoot().findViewById(R.id.usersListView);
            rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        } catch(RuntimeException e) {
            int i = 0;
        }
    }
}
