package com.example.sarah.symbilityintersect;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HearthstoneAdapter extends RecyclerView.Adapter<HearthstoneAdapter.HearthstoneViewHolder> {

    private ArrayList<HearthstoneCard> mData;

    public static class HearthstoneViewHolder extends RecyclerView.ViewHolder {
        public View hCardView;

        public HearthstoneViewHolder(View v) {
            super(v);
            hCardView = v;
        }
    }

    public HearthstoneAdapter(ArrayList<HearthstoneCard> data) {
        mData = data;
    }

    @Override
    public HearthstoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_hearthstone_card, parent, false);

        return new HearthstoneViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HearthstoneViewHolder holder, int position) {
        HearthstoneCard card = mData.get(position);
        ((TextView) holder.hCardView.findViewById(R.id.name)).setText(card.getName());
        ((TextView) holder.hCardView.findViewById(R.id.type)).setText(card.getType());
        ((TextView) holder.hCardView.findViewById(R.id.PlayerClass)).setText(card.getPlayerClass());
        if (card.mImgUrl != null) {

        }
        else {
//            ((ImageView) holder.hCardView.findViewById(R.id.image)).setImage
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
