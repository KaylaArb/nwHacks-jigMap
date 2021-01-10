import Header from '../components/Header'
import Footer from '../components/Footer'
import styles from '../styles/Explore.module.css'
import React from "react";
import RoadmapBlock from "../components/RoadmapBlock";

export default function Explore({date}) {
    return (
        <div className={styles.container}>
            <Header activePage={'Explore'}/>

            <main className={styles.main}>
                <img src="/exploreInfo.svg" alt="roadmap information" className={styles.exploreInfo}/>
                <h2>Trending Roadmaps</h2>
                <div>
                    <p className={styles.paragraph}> Explore thousands of roadmaps for your courses, ideas or any
                        discipline.</p>
                </div>
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
                        <RoadmapBlock/>
                    </div>
                    <div className={styles.item}>
                        <RoadmapBlock/>
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
