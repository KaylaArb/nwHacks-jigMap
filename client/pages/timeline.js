import Header from '../components/Header'
import Footer from '../components/Footer'
import FilterRoadmaps from '../components/FilterRoadmaps'
import styles from '../styles/Timeline.module.css'

import React from "react";

export default function Timeline() {
    return (
        <div className={styles.container}>
            <Header activePage={'Timeline'}/>
            <main className={styles.main}>
                <img src="/timelineInfo.svg" alt="creat information" className={styles.timelineInfo}/>
                <FilterRoadmaps/>
            </main>
            <Footer/>
        </div>
    )
}
