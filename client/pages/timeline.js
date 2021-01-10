import Header from '../components/Header'
import Footer from '../components/Footer'
import FilterRoadmaps from '../components/FilterRoadmaps'
import styles from '../styles/Timeline.module.css'

import React from "react";

export default function Timeline({data}) {
    return (
        <div className={styles.container}>
            <Header activePage={'Timeline'}/>
            <main className={styles.main}>
                <img src="/timelineInfo.svg" alt="creat information" className={styles.timelineInfo}/>
                <FilterRoadmaps data={data.roadmaps}/>
            </main>
            <Footer/>
        </div>
    )
}

export async function getServerSideProps() {
    const res = await fetch(`https://nwhacks-backend.herokuapp.com/api/v1/users/3`)
    const data = await res.json()
    console.log("worked")
    console.log(data)

    return {
        props: {data},
    }
}