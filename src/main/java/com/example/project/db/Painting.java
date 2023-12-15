package com.example.project.db;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Painting {
    private final String name;
    private final String year;
    private final String place;
    private final String photo;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private final Artist artist;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
