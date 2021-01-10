import Header from '../components/Header'
import Footer from '../components/Footer'
import styles from '../styles/MyRoadmaps.module.css'
import RoadmapBlock from "../components/RoadmapBlock";
import RoadmapBlock2 from "../components/RoadmapBlock2";

import React from "react";

export default function Roadmaps() {
    return (
        <div className={styles.container}>
            <Header/>
            <main className={styles.main}>
                <img src="/myroadmapsInfo.svg" alt="roadmap information" className={styles.roadmapInfo}/>
                <div className={styles.masonry}>
                    {/*{data.map((roadmap) =>(*/}
                    {/*    <RoadmapBlock key={roadmap.id} roadmap={roadmap}/>*/}
                    {/*))}*/}
                    <div className={styles.item}>
                        <RoadmapBlock/>
                    </div>
                    <div className={styles.item}>
                        <RoadmapBlock/>
                    </div>
                    <div className={styles.item}>
                        <RoadmapBlock/>
                    </div>
                    <div className={styles.item}>
                        <RoadmapBlock/>
                    </div>
                    <div className={styles.item}>
                        <RoadmapBlock2/>
                    </div>
                    <div className={styles.item}>
                        <RoadmapBlock2/>
                    </div>
                    <div className={styles.item}>
                        <RoadmapBlock/>
                    </div>


                </div>
            </main>
            <Footer/>
        </div>
    )
}
