package com.example.project.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaintingRepository extends CrudRepository<Painting, Integer> {
    List<Painting> findAllByArtistId(Integer id);

    Painting findByNameIgnoreCase(String name);

    Optional<List<Painting>> findByArtist(Artist artist);
}
