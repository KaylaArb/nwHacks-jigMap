package com.jigmap.controllers;

import java.util.List;

import com.jigmap.model.Roadmap;
import com.jigmap.repository.RoadmapRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 86400)
@RestController
@RequestMapping("/api/v1/roadmap")
public class RoadmapController {
    
    @Autowired
    private RoadmapRepository roadmapRepository;

    private static final Logger logger = LoggerFactory.getLogger(RoadmapController.class);

    @RequestMapping(value = "/", 
    method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Roadmap>> getAllRoadmaps() {
        try {
            List<Roadmap> roadmaps = roadmapRepository.findAll();
            logger.debug("Roadmap size {}", roadmaps.size());
            if(roadmaps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(roadmaps, HttpStatus.OK);
        } catch(Exception e) {
            logger.error("Internal Error - {}", e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @RequestMapping(value = "/new", 
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Roadmap> createRoadmap(@RequestBody Roadmap roadmap) {
        return new ResponseEntity<>(roadmapRepository.save(roadmap), HttpStatus.OK);
    }
}
