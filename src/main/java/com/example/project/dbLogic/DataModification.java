package com.example.project.dbLogic;

import com.example.project.PaintingInput;
import com.example.project.db.Painting;

import java.util.List;

public interface DataModification {
    void insertDataToDatabase(PaintingInput paintingData);

    void deleteDataFromDatabase(String paintingName);

    List<Painting> getPaintingsByArtist(String artistName);
}
