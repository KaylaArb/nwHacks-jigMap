import React from "react";
import Link from 'next/link'
import styles from '../styles/Trending.module.css';

export default function Features() {

    return (
        <div className={styles.trending}>
            <h2 className={styles.title}>Features and Use Cases</h2>
            <div >
                <p className={styles.paragraph}> You can use jigsaw pieces for any purpose out there an let others benefit from it.</p>
            </div>
            <img src="/demo_map.svg" alt="roadmap" className={styles.roadMap} />
        </div>
    )
}