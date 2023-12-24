package com.example.project;

import com.example.project.db.Artist;
import com.example.project.db.ArtistRepository;
import com.example.project.db.Painting;
import com.example.project.db.PaintingRepository;
import com.example.project.dbLogic.SqlHelper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Artist> getAllArtists() {
        return sqlHelper.getAllSortedArtists();
    }

    @PostMapping("/insert")
    public ResponseEntity insertPainting(@RequestBody PaintingInput data) {
        sqlHelper.insertDataToDatabase(data);
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/deletePainting")
    public ResponseEntity deletePainting(@RequestBody JSONObject data) {
        sqlHelper.deleteDataFromDatabase((String) data.get("name"));
        return ResponseEntity.ok().body("ok");
    }
}
