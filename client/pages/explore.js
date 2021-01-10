import Header from '../components/Header'
import Footer from '../components/Footer'
import styles from '../styles/Explore.module.css'
import React from "react";

export default function Explore() {
    return (
        <div className={styles.container}>
            <Header activePage={'Explore'}/>
            <main className={styles.main}>

            </main>
            <Footer/>
        </div>
    )
}
