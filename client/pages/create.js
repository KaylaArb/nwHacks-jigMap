import Head from 'next/head'
import Header from '../components/Header'
import Footer from '../components/Footer'
import styles from '../styles/Create.module.css'

import Builder from "../components/RoadMapBuilder";
import React from "react";

export default function Create() {
    return (
        <div className={styles.container}>
            <Header/>
            <main className={styles.main}>
                <img src="/videoDemo.svg" alt="video demo" className={styles.videoDemo}/>
                <Builder/>
            </main>
            <Footer/>
        </div>
    )
}
