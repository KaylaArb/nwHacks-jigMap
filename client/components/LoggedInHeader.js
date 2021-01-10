import React from "react";
import Link from 'next/link'
import styles from '../styles/LoggedInHeader.module.css'
import {useState, useEffect} from 'react';

export default function Header({activePage}) {

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
                <Link href="/">
                    <a className={`${styles.links} ${isScrolled ? styles.active : ''}`}>
                        Home
                    </a>
                </Link>
                <Link href="/explore">
                    <a className={`${styles.links} ${isScrolled ? styles.active : ''}`}>
                        Explore
                    </a>
                </Link>
                <Link href="/create">
                    <a className={`${styles.links} ${isScrolled ? styles.active : ''}`}>
                        Create
                    </a>
                </Link>
                <Link href="/timeline">
                    <a className={`${styles.links} ${isScrolled ? styles.active : ''}`}>
                        Timeline
                    </a>
                </Link>
            </div>
        </header>
    )
}


