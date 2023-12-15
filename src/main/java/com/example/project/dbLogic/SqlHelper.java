package com.example.project.dbLogic;

import com.example.project.PaintingInput;
import com.example.project.db.Artist;
import com.example.project.db.ArtistRepository;
import com.example.project.db.PaintingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SqlHelper implements DataModification {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private PaintingRepository paintingRepository;
    @Autowired
    private PaintingFactory paintingFactory;

    @Override
    public void insertDataToDatabase(PaintingInput paintingInput) {
        var artistOptional = artistRepository.findByName(paintingInput.artist());
        artistOptional.ifPresentOrElse(
                artist -> paintingRepository.save(paintingFactory.createPainting(paintingInput, artist)),
                () -> insertArtistWithPainting(paintingInput)
        );
    }

    private void insertArtistWithPainting(PaintingInput paintingInput) {
        var artist = new Artist();
        artist.setName(paintingInput.artist());
        artistRepository.save(artist);
        paintingRepository.save(paintingFactory.createPainting(paintingInput, artist));
    }
}
