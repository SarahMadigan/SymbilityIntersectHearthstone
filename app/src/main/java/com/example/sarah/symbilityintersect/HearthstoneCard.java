package com.example.sarah.symbilityintersect;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sarah on 2018-10-11.
 */

public class HearthstoneCard {
    private String mName;
    private String mImgUrl;
    private String mType;

    private String mPlayerClass;

    public HearthstoneCard(String name, String imgUrl, String type, String playerClass) {
        mName = name;
        mImgUrl = imgUrl;
        mType = type;
        mPlayerClass = playerClass;
    }

    public String getName() {
        return mName;
    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public String getType() {
        return mType;
    }

    public String getPlayerClass() {
        return mPlayerClass;
    }

    public static ArrayList<HearthstoneCard> parseResponse(JSONObject response) {
        ArrayList<HearthstoneCard> cards = new ArrayList<>();
        Iterator<String> keys = response.keys();
        while (keys.hasNext()) {
            JSONArray currCardArray = new JSONArray();
            try {
                currCardArray = response.getJSONArray(keys.next());
                for (int i = 0; i < currCardArray.length(); i++) {
                    JSONObject currCard = currCardArray.getJSONObject(i);
                    cards.add(new HearthstoneCard(
                            currCard.getString("name"),
                            getImageString(currCard, "img"),
                            currCard.getString("type"),
                            currCard.getString("playerClass")));
                }
            }
            catch (JSONException e) {
                Log.e("Card parsing", e.toString());
            }
        }
        return cards;
    }

    private static String getImageString(JSONObject obj, String key) {
        String result;
        try {
            result = obj.getString(key);
        }
        catch (JSONException e) {
            result = "a";
        }
        return result;
    }
}
