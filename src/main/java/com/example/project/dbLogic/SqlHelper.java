package com.example.project.dbLogic;

import com.example.project.ArtistComparator;
import com.example.project.PaintingInput;
import com.example.project.db.Artist;
import com.example.project.db.ArtistRepository;
import com.example.project.db.Painting;
import com.example.project.db.PaintingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SqlHelper implements DataModification {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private PaintingRepository paintingRepository;
    @Autowired
    private PaintingFactory paintingFactory;
    @Autowired
    private ArtistComparator comparator;

    @Override
    public void insertDataToDatabase(PaintingInput paintingInput) {
        var artistOptional = artistRepository.findByNameIgnoreCase(paintingInput.artist());
        artistOptional.ifPresentOrElse(
                artist -> paintingRepository.save(paintingFactory.createPainting(paintingInput, artist)),
                () -> insertArtistWithPainting(paintingInput)
        );
    }

    @Override
    public void deleteDataFromDatabase(String paintingName) {
        var painting = paintingRepository.findByNameIgnoreCase(paintingName);
        var artist = artistRepository.findById(painting.getArtist().getId());
        paintingRepository.delete(painting);
        if (paintingRepository.findByArtist(artist.get()).get().isEmpty()) {
            artistRepository.delete(artist.get());
        }
    }

    @Override
    public List<Painting> getPaintingsByArtist(String artistName) {
        var artistOptional = artistRepository.findByNameIgnoreCase(artistName);
        return artistOptional.map(artist -> paintingRepository.findAllByArtistId(artist.getId()))
                .orElse(null);
    }

    @Override
    public List<Artist> getAllSortedArtists() {
        var artistsIterator = artistRepository.findAll().iterator();
        List<Artist> list = new ArrayList<>();
        while (artistsIterator.hasNext()) {
            list.add(artistsIterator.next());
        }
        list.sort(comparator);
        return list;
    }

    private void insertArtistWithPainting(PaintingInput paintingInput) {
        var artist = new Artist();
        artist.setName(paintingInput.artist());
        artistRepository.save(artist);
        paintingRepository.save(paintingFactory.createPainting(paintingInput, artist));
    }
}
