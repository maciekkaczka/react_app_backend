package com.example.project.dbLogic;

import com.example.project.PaintingInput;
import com.example.project.db.Artist;
import com.example.project.db.Painting;
import org.springframework.stereotype.Component;

@Component
public class PaintingFactory {
    public Painting createPainting(PaintingInput paintingInput, Artist artist) {
        Painting painting = new Painting();
        painting.setArtist(artist);
        painting.setYear(paintingInput.year());
        painting.setName(paintingInput.painting());
        painting.setPlace(paintingInput.place());
        painting.setPhoto(paintingInput.photo());
        return painting;
    }
}
