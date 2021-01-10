import React from "react";
import {useState, useEffect} from 'react';
import styles from '../styles/FilterRoadmaps.module.css';
import RoadmapBlock from "./RoadmapBlock";

export default function FilterRoadmaps() {

    return (
        <div className={styles.container}>
            <div className={styles.allRoadmaps}>
                <h4 className={styles.h4}>Jigsaw Pieces</h4>
                <p className={styles.paragraph}> Filter through the roadsmaps you are subscribed to and fork them to add on your own twist.</p>
                <RoadmapBlock/>
            </div>
            <div className={styles.filterContainer}>
                <div className={styles.filterBox}>
                    <p className={styles.title}>RoadMaps</p>
                    <img src="/border.svg" alt="border" className={styles.border} />
                    <label className="container">One
                        <input type="checkbox" />
                    </label>
                    <label className="container">Two
                        <input type="checkbox"/>

                    </label>
                    <label className="container">Three
                        <input type="checkbox"/>

                    </label>
                    <label className="container">Four
                        <input type="checkbox"/>
                    </label>
                    <img src="/unsubscribe.svg" alt="unsubscribe" className={styles.unsubscribe}/>
                </div>
                <p>If you think there must be a different order to this roadmap, submit a CHANGE ORDER REQUEST.</p>

            </div>

        </div>
    )
}