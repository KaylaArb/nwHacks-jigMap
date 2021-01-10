import React from "react";
import Link from 'next/link'
import styles from '../styles/Hero.module.css';
import { useState, useRef } from 'react';

export default function Hero() {
    const [searchValue, setSearchValue] = useState('');

    const handleKeyDown = (event) => {
        if (event.key === 'Enter') {
            handleSearch();
        }
    }

    const handleChangeSearchValue = (e) => {
        if (e && e.target) {
            setSearchValue(e.target.value);
        }
    };

    const handleSearch = () => {
        window.location.replace('/explore')
    };

    return (
        <div className={styles.hero}>
            <div className={styles.container}>
                <div className={styles.inputContainer}>
                    <div className={styles.navSearchContainer}>
                        <button
                            type="submit"
                            className={styles.formButton}
                            onClick={handleSearch}
                        />
                        <input
                            type="text"
                            name="search"
                            placeholder="Search all the roadmaps..."
                            className={styles.searchInput}
                            value={searchValue}
                            onKeyDown={handleKeyDown}
                            onChange={handleChangeSearchValue}
                            />

                    </div>
                    <p>100M+ roadmaps created on JigMap</p>

                </div>

            </div>

        </div>
    )
}