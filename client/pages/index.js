import Head from 'next/head'
import Header from '../components/Header'
import Footer from '../components/Footer'
import Hero from "../components/Hero";
import styles from '../styles/Home.module.css'
import Trending from "../components/Trending";

export default function Home() {
  return (
    <div className={styles.container}>
        <Header/>

      <main className={styles.main}>
          <Hero/>
          <Trending/>
          <p>Hello</p>
      </main>
      <Footer/>
    </div>
  )
}
