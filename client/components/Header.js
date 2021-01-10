import React from "react";
import Link from 'next/link'
import styles from '../styles/Header.module.css'
import {useState, useEffect} from 'react';

export default function Header({activePage, user}) {
    const user1 = ["user"]

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
            <div className={styles.content}>
                <div className={styles.header__title}>
                    <Link href="/"><img src="/jigmap_logo.svg" alt="logo" className={styles.logo}/></Link>
                </div>

                <div className={`${styles.navLinks} ${isScrolled ? styles.active : ''}`}>
                    {user1 ? <div><Link href="/">
                            <a className={`${styles.linksUser} ${activePage == 'Home' ? styles.active : ''}`}>
                                Home
                            </a>
                        </Link>
                            <Link href="/explore">
                                <a className={`${styles.linksUser} ${activePage == 'Explore' ? styles.active : ''}`}>
                                    Explore
                                </a>
                            </Link>
                            <Link href="/create">
                                <a className={`${styles.linksUser} ${activePage == 'Create' ? styles.active : ''}`}>
                                    Create
                                </a>
                            </Link>
                            <Link href="/timeline">
                                <a className={`${styles.linksUser} ${activePage == 'Timeline' ? styles.active : ''}`}>
                                    Timeline
                                </a>
                            </Link></div>
                        :
                        <div>
                            <Link href="/about">
                                <a className={`${styles.links} ${activePage == 'About' ? styles.active : ''}`}>
                                    About
                                </a>
                            </Link>
                            <Link href="/#contact">
                                <a className={`${styles.links} ${activePage == 'Contact' ? styles.active : ''}`}>
                                    Contact
                                </a>
                            </Link>
                            <Link href="/explore">
                                <a className={`${styles.links} ${activePage == 'Explore' ? styles.active : ''}`}>
                                    Explore
                                </a>
                            </Link>
                            <Link href="/login" className={`${styles.navLinks} ${user1 ? '' : styles.active}`}>
                                <button className={`${styles.loginButton} ${isScrolled ? styles.active : ''}`}><a>
                                    LOG IN
                                </a></button>
                            </Link>
                        </div>
                    }

                </div>

                <div className={`${styles.userPic} ${user1 ? styles.active : ''}`}>
                    <Link href="/roadmaps"><img src="/profilePic.svg" alt="profile picture"
                                                  className={`${styles.profilePic} ${isScrolled ? styles.active : ''}`}/></Link>
                </div>
            </div>
        </header>
    )
}


