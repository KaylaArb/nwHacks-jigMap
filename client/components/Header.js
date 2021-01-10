import React from "react";
import Link from 'next/link'
import styles from '../styles/Header.module.css'
import {useState, useEffect} from 'react';

export default function Header() {

    const [isScrolled, setIsScrolled] = useState(false);

    const listenScrollEvent = e => {
        if (window.scrollY > 0) {
            setIsScrolled(true)
        } else {
            setIsScrolled(false);
        }
    }

    useEffect(() => {
        window.addEventListener('scroll', listenScrollEvent);
    })

    return (
        <header className={`${styles.header} ${isScrolled ? styles.active : ''}`}>
            <div className={styles.header__title}>
                <Link href="/"><img src="/jigmap_logo.svg" alt="logo" className={styles.logo}/></Link>
            </div>

            <div className={`${styles.navLinks} ${isScrolled ? styles.active : ''}`}>
                <Link href="/about">
                    <a className={styles.links}>
                        About
                    </a>
                </Link>
                <Link href="/#contact">
                    <a className={styles.links}>
                        Contact
                    </a>
                </Link>
                <Link href="/explore">
                    <a className={styles.links}>
                        Explore
                    </a>
                </Link>
                <Link href="/login">
                    <button className={`${styles.loginButton} ${isScrolled ? styles.active : ''}`}><a>
                        LOG IN
                    </a></button>
                </Link>
            </div>
        </header>
    )
}


