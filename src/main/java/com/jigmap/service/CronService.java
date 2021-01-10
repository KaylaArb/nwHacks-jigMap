package com.jigmap.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jigmap.model.Roadmap;
import com.jigmap.repository.JPieceRepository;
import com.jigmap.repository.RoadmapRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronService {

    @Autowired
    RoadmapRepository roadmapRepository;
    @Autowired
    JPieceRepository jPieceRepository;

    private static final Logger logger = LoggerFactory.getLogger(CronService.class);

    @Scheduled(cron = "0 0 */1 * * *")
    public void cronJobSch() {
        List<Roadmap> allRoadmapIDs = roadmapRepository.findAll();
        for(Roadmap roadmap : allRoadmapIDs) {
            long total_jpieces_clicks = jPieceRepository.countOfClicksByRoadMapID(roadmap.getId());
            long total_jpieces_likes = jPieceRepository.countOfLikesByRoadMapID(roadmap.getId());
            long number_of_jpieces = allRoadmapIDs.size();

            int rank = (int) Math.ceil(((total_jpieces_clicks + total_jpieces_likes)/number_of_jpieces*2)*5);
            logger.info("Rank of {} roadmap is {}", roadmap.getTitle(), rank);
            roadmap.setRank(rank);
            roadmapRepository.save(roadmap);
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        logger.info("Cron job completed at {}", strDate);

   }
}
