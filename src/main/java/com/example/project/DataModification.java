package com.example.project;

import org.json.simple.JSONObject;

public interface DataModification {
    JSONObject getByKey(String name);
    void insertPaintingToDatabase(JSONObject paintingData);
}
