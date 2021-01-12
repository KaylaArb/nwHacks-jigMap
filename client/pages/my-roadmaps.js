import Header from '../components/Header'
import Footer from '../components/Footer'
import styles from '../styles/MyRoadmaps.module.css'
import RoadmapBlock from "../components/RoadmapBlock";
import Masonry, { ResponsiveMasonry } from "react-responsive-masonry"
import React, { Children } from "react";

export default function Roadmaps({ data }) {

    return (
        <div className={styles.container}>
            <Header />
            <main className={styles.main}>
                <img src="/myroadmapsInfo.svg" alt="roadmap information" className={styles.roadmapInfo} />
                <Masonry columnsCount={3}>
                    {data.roadmaps.map((roadmap) => (
                        <div className={styles.item}><RoadmapBlock key={roadmap.id} data={roadmap} /> </div>
                    ))}
                </Masonry>
            </main>
            <Footer />
        </div>
    )
}

export async function getServerSideProps() {
    const res = await fetch(`https://nwhacks-backend.herokuapp.com/api/v1/users/3`)
    const data = await res.json()
    console.log("worked here")
    console.log(data)

    return {
        props: { data },
    }
}
