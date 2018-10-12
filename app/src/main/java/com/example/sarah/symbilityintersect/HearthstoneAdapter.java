package com.example.sarah.symbilityintersect;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HearthstoneAdapter extends RecyclerView.Adapter<HearthstoneAdapter.HearthstoneViewHolder> {

    int[] mData;

    public static class HearthstoneViewHolder extends RecyclerView.ViewHolder {
        public HearthstoneViewHolder(View v) {
            super(v);
        }
    }

    public HearthstoneAdapter(int[] data) {
        mData = data;
    }

    @Override
    public HearthstoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_main, parent, false);

        return new HearthstoneViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HearthstoneViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }
}
