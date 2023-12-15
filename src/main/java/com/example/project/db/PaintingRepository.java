package com.example.project.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends CrudRepository<Painting, Integer> {
}
