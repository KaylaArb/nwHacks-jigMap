import React from "react";
import Link from 'next/link'
import styles from '../styles/Trending.module.css';

export default function Trending() {

    return (
        <div className={styles.trending}>
            <h2>Trending Roadmaps</h2>
            <div >
                <p className={styles.paragraph}> Explore thousands of roadmaps for your courses, ideas or any
                    discipline.</p>
            </div>
            <img src="/trending.svg" alt="roadmap" className={styles.roadMap} />
            <div>
                <button className={styles.button}>
                    Explore All →
                </button>
            </div>
            <img src="/border.svg" alt="logo" className={styles.border} />
        </div>
    )
}