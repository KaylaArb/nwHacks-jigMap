import Head from 'next/head'
import Header from '../components/Header'
import Footer from '../components/Footer'
import Hero from "../components/Hero";
import styles from '../styles/Home.module.css'
import Trending from "../components/Trending";
import Features from "../components/Features";

export default function Home() {
  return (
    <div className={styles.container}>
        <Header activePage={'Home'}/>
        <Hero/>

      <main className={styles.main}>
          <Trending/>
          <Features/>
      </main>
      <Footer/>
    </div>
  )
}
