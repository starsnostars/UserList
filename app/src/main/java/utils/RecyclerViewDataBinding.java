package utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.afanasyev.userlist.UserListAdapter;
import com.example.afanasyev.userlist.UserViewModel;

import java.util.ArrayList;

public class RecyclerViewDataBinding {
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, UserListAdapter adapter, ArrayList<UserViewModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.setData(data);
    }
}
