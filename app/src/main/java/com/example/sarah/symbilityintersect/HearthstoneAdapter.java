package com.example.sarah.symbilityintersect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HearthstoneAdapter extends RecyclerView.Adapter<HearthstoneAdapter.HearthstoneViewHolder> implements Filterable {

    private ArrayList<HearthstoneCard> mTotalData;
    private ArrayList<HearthstoneCard> mDisplayData;

    public static class HearthstoneViewHolder extends RecyclerView.ViewHolder {
        public View hCardView;

        public HearthstoneViewHolder(View v) {
            super(v);
            hCardView = v;
        }
    }

    public HearthstoneAdapter(ArrayList<HearthstoneCard> data) {
        mTotalData = data;
        mDisplayData = data;
    }

    @Override
    public HearthstoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_hearthstone_card, parent, false);

        return new HearthstoneViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HearthstoneViewHolder holder, int position) {
        HearthstoneCard card = mDisplayData.get(position);
        ((TextView) holder.hCardView.findViewById(R.id.name)).setText(card.getName());
        ((TextView) holder.hCardView.findViewById(R.id.type)).setText(card.getType());
        ((TextView) holder.hCardView.findViewById(R.id.PlayerClass)).setText(card.getPlayerClass());
        ImageView imageView = ((ImageView) holder.hCardView.findViewById(R.id.image));
        if (card.getName().equals("Boar")) {
            Log.e("Test", "Url: " + card.getImgUrl());
        }
        if (card.getImgUrl() == null || card.getImgUrl().isEmpty()) {
            Picasso.get().load(R.drawable.hearthstone_default);
//            imageView.setBackgroundResource(R.drawable.hearthstone_default);
        }
        else {
            Picasso.get().load(card.getImgUrl()).placeholder(R.drawable.hearthstone_default).error(R.drawable.hearthstone_default).into(imageView);
//            ((ImageView) holder.hCardView.findViewById(R.id.image)).setImage
        }
    }

    @Override
    public int getItemCount() {
        return mDisplayData.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                ArrayList<HearthstoneCard> cardListFiltered = new ArrayList<>();
                String charString = charSequence.toString().toLowerCase();
                if (charString.isEmpty()) {
                    cardListFiltered = mTotalData;
                }
                else {
                    for (HearthstoneCard card : mTotalData) {
                        if (card.getName().toLowerCase().contains(charString)) {
                            cardListFiltered.add(card);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = cardListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                mDisplayData.clear();
                mDisplayData.addAll((ArrayList<HearthstoneCard>) results.values);
                notifyDataSetChanged();
            }
        };
    }
}
