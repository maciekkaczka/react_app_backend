package com.example.project.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingRepository extends CrudRepository<Painting, Integer> {
    List<Painting> findAllByArtistId(Integer id);
}
