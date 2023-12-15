package com.example.project;

import com.example.project.db.Artist;
import com.example.project.db.ArtistRepository;
import com.example.project.dbLogic.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {
    @Autowired
    private SqlHelper sqlHelper;
    @Autowired
    private ArtistRepository repository;

    @GetMapping("/get/{name}")
    @ResponseBody
    public Artist getArtist(@PathVariable("name") String name) {
        var artist = repository.findByName(name);
        return artist.get();
    }

    @PostMapping("/insert")
    public void insertPainting(@RequestBody PaintingInput data) {
        sqlHelper.insertDataToDatabase(data);
    }
}
