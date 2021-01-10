package com.jigmap.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jigmap.repository.JPieceRepository;
import com.jigmap.repository.RoadmapRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronService {

    @Autowired
    RoadmapRepository roadmapRepository;
    @Autowired
    JPieceRepository jPieceRepository;

    @Scheduled(cron = "30 * * * * *")
    public void cronJobSch() {
        List<Long> allRoadmapIDs = roadmapRepository.findAllIds();
        for(Long rm_id : allRoadmapIDs) {
            long total_jpieces_clicks = jPieceRepository.countOfClicksByRoadMapID(rm_id);
            long total_jpieces_likes = jPieceRepository.countOfLikesByRoadMapID(rm_id);
            System.out.println(total_jpieces_clicks);
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);

   }
}
