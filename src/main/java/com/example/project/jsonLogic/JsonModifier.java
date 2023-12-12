package com.example.project.jsonLogic;

import com.example.project.DataModification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Component
public class JsonModifier implements DataModification {
    private static final String dataPath = "src/main/java/com/example/project/data/";

    @Override
    public JSONObject getByKey(String name) {
        return getJsonData(dataPath + name + ".json");
        //TODO: zrobić jakiś error catcher jak nie ma
    }

    @Override
    public void insertPaintingToDatabase(JSONObject paintingData){
        String artistFileName = paintingData.get("artist").toString().replace(" ", "-").toLowerCase() + ".json";
        Optional<JSONObject> artist = Optional.ofNullable(getJsonData(dataPath + artistFileName));
        addElementToPaintingsArray(artist, paintingData);
    }

    private JSONObject addElementToPaintingsArray(Optional<JSONObject> artistData, JSONObject paintingData){
        artistData.ifPresent(
            artist -> {
                JSONArray paintings = (JSONArray) artist.get("paintings");
                paintings.add(paintingData.get("painting"));

                System.out.println(
                        artist.get("paintings")
                );
            }
        );
        return null;
    }

    private JSONObject getJsonData(String path){
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(path));
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            return null;
        }
    }
}
