package com.example.project.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@RequiredArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private final String name;
}
