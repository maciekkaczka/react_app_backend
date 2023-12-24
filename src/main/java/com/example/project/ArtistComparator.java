package com.example.project;

import com.example.project.db.Artist;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class ArtistComparator implements Comparator<Artist> {
    @Override
    public int compare(Artist a, Artist b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
