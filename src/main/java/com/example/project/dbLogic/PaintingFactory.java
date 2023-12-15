package com.example.project.dbLogic;

import com.example.project.PaintingInput;
import com.example.project.db.Artist;
import com.example.project.db.Painting;
import org.springframework.stereotype.Component;

@Component
public class PaintingFactory {
    public Painting createPainting(PaintingInput paintingInput, Artist artist) {
        return new Painting(
                paintingInput.painting(),
                paintingInput.year(),
                paintingInput.place(),
                paintingInput.photo(),
                artist
        );
    }
}
