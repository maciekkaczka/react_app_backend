package com.example.project;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectController {
    @Autowired
    private JsonExtracter jsonExtracter;

    @GetMapping("/get/{name}")
    @ResponseBody
    public JSONObject getMovie (@PathVariable("name") String name){
        return jsonExtracter.getArtist(name);
    }

    @PostMapping("/insert")
    public void insertData (String data){
        System.out.println("dupa");
    }
}
