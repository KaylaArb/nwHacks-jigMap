import React from "react";
import Link from 'next/link'
import styles from '../styles/Hero.module.css';

export default function Hero() {

    return (
        <div className={styles.hero}>
            <div className={styles.container}>
                <div className={styles.inputContainer}>
                    <div className={styles.navSearchContainer}>
                        <button
                            type="submit"
                            className={styles.formButton}
                            // onClick={handleSearch}
                        />
                        <input
                            type="text"
                            name="search"
                            placeholder="Search all the roadmaps..."
                            className={styles.searchInput}
                            // value={searchValue}
                            // onKeyDown={handleKeyDown}
                            // onChange={handleChangeSearchValue}
                            />
                        {/*{*/}
                        {/*    searchValue && (*/}
                        {/*        <button*/}
                        {/*            className={styles.clearButton}*/}
                        {/*            onClick={() => setSearchValue('')} />*/}
                        {/*    )*/}
                        {/*}*/}


                    </div>
                    <p>100M+ roadmaps created on JigMap</p>

                </div>

            </div>

        </div>
    )
}