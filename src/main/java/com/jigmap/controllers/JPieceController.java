package com.jigmap.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.jigmap.model.JPiece;
import com.jigmap.model.User;
import com.jigmap.repository.JPieceRepository;
import com.jigmap.repository.UserRepository;

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

//@CrossOrigin(origins = "https://nwhacks-frontend.herokuapp.com/", maxAge = 86400)
@RestController
@RequestMapping("/api/v1/jpiece")
public class JPieceController {
    
    @Autowired
    private JPieceRepository jPieceRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(JPieceController.class);


    // @RequestMapping(value = "/like", 
    //         method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<User> likeJpiece(@RequestBody Map<String, Object> lookupRequestObject) {
    //     try {
    //         Optional<JPiece> jpiece =  jPieceRepository.findById(
    //                 ((Number) lookupRequestObject.get("jpieceID")).longValue());
    //         Optional<User> user =  userRepository.findById(
    //             ((Number) lookupRequestObject.get("userID")).longValue());
    //         if(jpiece.isPresent() && user.isPresent()) {
    //             List<JPiece> likedJPieces = user.get().getLikedJPieces();
    //             List<User> userLikes  = jpiece.get().getUserlikes();
    //             if(likedJPieces.contains(jpiece.get())) {
    //                 likedJPieces.remove(jpiece.get()); 
    //             } else {
    //                 likedJPieces.add(jpiece.get());
    //             }
    //             if(userLikes.contains(user.get())) {
    //                 userLikes.remove(user.get());
    //             } else {
    //                 userLikes.add(user.get());
    //             }
    //             User updatedUser = user.get();
    //             JPiece updatedJPiece = jpiece.get();
    //             updatedJPiece.setUserlikes(userLikes);
    //             jPieceRepository.save(updatedJPiece);
    //             updatedUser.setLikedJPieces(likedJPieces);
    //             return new ResponseEntity<>(userRepository.save(updatedUser), HttpStatus.OK);
    //         } else {
    //             logger.error("No jpiece or user");
    //             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //         }
    //     } catch(Exception e) {
    //         logger.error("Internal error {} ", e.getMessage());
    //         e.printStackTrace();
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @RequestMapping(value = "/click",
            method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JPiece> clickJpiece(@RequestBody Map<String, Object> lookupRequestObject) {
        try {
            Optional<JPiece> jpiece =  jPieceRepository.findById(
                    ((Number) lookupRequestObject.get("jpieceID")).longValue());
            Optional<User> user =  userRepository.findById(
                            ((Number) lookupRequestObject.get("userID")).longValue());
            if(jpiece.isPresent() && user.isPresent()) {

                return new ResponseEntity<>(jPieceRepository.save(jpiece.get()), HttpStatus.OK);
            } else {
                logger.error("No jpiece or user");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch(Exception e) {
            logger.error("Internal error {} ", e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
