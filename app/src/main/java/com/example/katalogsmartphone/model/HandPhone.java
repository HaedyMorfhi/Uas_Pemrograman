package com.example.katalogsmartphone.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class HandPhone {


    private String id;
    private String spesifikasi;



    public HandPhone() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }


    public static HandPhone fromJSONObject(JSONObject obj) {
        HandPhone tr = new HandPhone();
        try {
            tr.setId(obj.getString("id"));
            tr.setSpesifikasi(obj.getString("spesifikasi"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", this.id);
            jsonObj.put("spesifikasi", this.spesifikasi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}
