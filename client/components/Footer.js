import React from "react";
import styles from '../styles/Footer.module.css'
import Link from "next/link";

export default function Footer() {

    return (
        <footer className={styles.footer}>
            <div className={styles.container}>
                <div className={styles.firstContainer}>
                    <div className={styles.logo_menu}>
                        <Link href="/"><img src="/footer_logo.svg" alt="footer logo" className={styles.logo}/></Link>
                        <Link href="/"><a className={styles.text}>Home</a></Link>
                        <Link href="/explore"><a className={styles.text}>Explore</a></Link>
                        <Link href="/create" ><a className={styles.text}>Create</a></Link>
                        <Link href="/timeline"><a className={styles.text}>Timeline</a></Link>
                    </div>
                    <div className={styles.logo_menu}>
                        <p className={styles.subTitle}>Company</p>
                        <Link href="/contact"><a className={styles.text}>Contact</a></Link>
                        <Link href="/about"><a className={styles.text}>About Us</a></Link>
                        <Link href="/" ><a className={styles.text}>Collaborate</a></Link>
                        <Link href="/"><a className={styles.text}>Support Us</a></Link>
                    </div>

                </div>

                <div className={styles.logosBox}>
                    <Link href="/"><img src="/icons.svg" alt="icons" className={styles.icons}/></Link>
                    <p className={styles.copyFont}>Copyright © 2020-2021</p>
                </div>

            </div>


        </footer>

    )
}