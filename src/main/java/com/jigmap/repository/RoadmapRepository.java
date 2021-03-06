package com.jigmap.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.jigmap.model.Roadmap;

@Repository
public interface RoadmapRepository extends CrudRepository<Roadmap, Long> {

    List<Roadmap> findAll();
    @Query("SELECT id FROM Roadmap") 
    List<Long> findAllIds();

}
