package com.example.project;

import com.example.project.db.Artist;
import com.example.project.db.ArtistRepository;
import com.example.project.jsonLogic.JsonModifier;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {
    @Autowired
    private JsonModifier modifier;
    @Autowired
    private ArtistRepository repository;

    @GetMapping("/get/{name}")
    @ResponseBody
    public JSONObject getArtist (@PathVariable("name") String name){
        return modifier.getByKey(name);
    }

    @PostMapping("/insert")
    public void insertPainting (@RequestBody JSONObject data){
        modifier.insertPaintingToDatabase(data);
    }

    @PostMapping("/addArtist")
    public @ResponseBody String addNewArtist(@RequestBody JSONObject data){
        Artist artist = new Artist((String) data.get("name"));
        repository.save(artist);
        return "Saved";

    }
}
