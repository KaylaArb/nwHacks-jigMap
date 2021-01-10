package com.jigmap.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.jigmap.model.Roadmap;

public interface RoadmapRepository extends CrudRepository<Roadmap, Long> {

    List<Roadmap> findAll();

}
