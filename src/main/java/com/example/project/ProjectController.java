package com.example.project;

import com.example.project.db.Artist;
import com.example.project.db.ArtistRepository;
import com.example.project.db.Painting;
import com.example.project.db.PaintingRepository;
import com.example.project.dbLogic.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private SqlHelper sqlHelper;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private PaintingRepository paintingRepository;

    @GetMapping("/get/{name}")
    @ResponseBody
    public List<Painting> getArtist(@PathVariable("name") String name) {
        return sqlHelper.getPaintingsByArtist(name);
    }

    @GetMapping("/getArtists")
    @ResponseBody
    public Iterable<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @PostMapping("/insert")
    public void insertPainting(@RequestBody PaintingInput data) {
        sqlHelper.insertDataToDatabase(data);
    }
}
