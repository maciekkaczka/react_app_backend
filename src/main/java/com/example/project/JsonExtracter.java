package com.example.project;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

@Component
public class JsonExtracter implements MovieInfo {

    private static final String dataPath = "src/main/java/com/example/project/data/albums.json";
    @Override
    public JSONObject getArtist(String name) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(dataPath));
            JSONObject artists = (JSONObject) obj;
            Iterator<String> keyIter = artists.keySet().iterator();
            var artistName = "";
            while(keyIter.hasNext()){
                String key = keyIter.next();
                if(key.equalsIgnoreCase(name)) {
                    artistName = key;
                    break;
                }
            }
            return (JSONObject) artists.get(artistName);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
