import Header from '../components/Header'
import Footer from '../components/Footer'
import styles from '../styles/Explore.module.css'
import React from "react";
import RoadmapBlock from "../components/RoadmapBlock";

export default function Explore({data}) {
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

                        {data.reverse().map((roadmap) =>(
                            <div className={styles.item}><RoadmapBlock key={roadmap.id} data={roadmap}/> </div>
                        ))}
                </div>
            </main>
            <Footer/>
        </div>
    )
}

export async function getServerSideProps() {
    const res = await fetch(`https://nwhacks-backend.herokuapp.com/api/v1/roadmap/`)
    const data = await res.json()
    console.log("worked here")
    console.log(data)

    return {
        props: {data},
    }
}
