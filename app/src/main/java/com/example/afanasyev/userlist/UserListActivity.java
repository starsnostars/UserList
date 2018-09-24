package com.example.afanasyev.userlist;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.afanasyev.userlist.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class UserListActivity extends AppCompatActivity {
    @Inject UserListViewModel viewModel;
    @Inject UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        try {

            ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            binding.setViewModel(viewModel);
            binding.setAdapter(userListAdapter);

            initRecyclerView(binding.getRoot());

        } catch (RuntimeException e) {
            Log.d("TAG", "onCreate: " + String.valueOf(e));
        }
    }

    private void initRecyclerView(View v) {
        RecyclerView rv = v.findViewById(R.id.usersListView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), layoutManager.getOrientation()));
    }
}
