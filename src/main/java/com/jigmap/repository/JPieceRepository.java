package com.jigmap.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.jigmap.model.JPiece;

@Repository
public interface JPieceRepository extends CrudRepository<JPiece, Long> {

    Optional<JPiece> findById(Long id);

    @Query(value="SELECT COUNT(*) FROM jpieces_clicks WHERE jpiece_id IN (SELECT id from jpiece WHERE rm_id = ?1)",nativeQuery = true)
    long countOfClicksByRoadMapID(Long rm_id);

    @Query(value="SELECT COUNT(*) FROM jpieces_likes WHERE jpiece_id IN (SELECT id from jpiece WHERE rm_id = ?1)",nativeQuery = true)
    long countOfLikesByRoadMapID(Long rm_id);

}
