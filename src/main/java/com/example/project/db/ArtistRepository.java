package com.example.project.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    Optional<Artist> findByNameIgnoreCase(String name);
}
