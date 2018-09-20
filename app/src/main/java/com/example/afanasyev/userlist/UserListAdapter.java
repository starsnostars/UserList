package com.example.afanasyev.userlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.afanasyev.userlist.databinding.UserItemLayoutBinding;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserHolder> {
    private ArrayList<UserViewModel> data = new ArrayList<>();

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context)
                                .inflate(R.layout.user_item_layout, new FrameLayout(context), false);

        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userListItem, int i) {
        UserViewModel vm = data.get(i);
        userListItem.setViewModel(vm);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<UserViewModel> data) {
        this.data = data;
        notifyItemRangeChanged(0, data.size());
    }

    static class UserHolder extends RecyclerView.ViewHolder {
        private UserItemLayoutBinding binding;

        public UserHolder(View itemView) {
            super(itemView);
        }

        public void setViewModel(UserViewModel viewModel) {
            getBinding().setViewModel(viewModel);
        }

        private UserItemLayoutBinding getBinding() {
            if (binding == null) {
                binding = DataBindingUtil.getBinding(itemView);
            }

            return binding;
        }
    }
}
