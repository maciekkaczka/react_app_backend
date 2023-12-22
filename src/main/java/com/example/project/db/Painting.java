package com.example.project.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Painting {
    private String name;
    private String year;
    private String place;
    private String photo;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
