import React from "react";
import Link from 'next/link'
import styles from '../styles/RoadMapBuilder.module.css';

export default function Builder() {

    return (
        <div className={styles.builder}>
            <h3>Roadmap Builder</h3>
            <div className={styles.container}>
                <form className={styles.form}>
                    <div className={styles.textInfo}>
                        <input type="text" id="name" placeholder="Roadmap Name" required className={styles.inputBox}/>
                        <input type="text" id="description" placeholder="Description/Guidelines" className={styles.inputBox}/>
                        <h4 className={styles.h4}>Jigsaw Pieces</h4>
                    </div>

                    <div className={styles.jigsawInfo}>
                        <div className={styles.jigsawRow}>
                            <img src="/uploadArrow.svg" alt="logo" className={styles.uploadImage}/>
                            <input id="firstMap" placeholder="or click to start writing" className={styles.jigsawBoxTop}/>
                        </div>
                        <div className={styles.jigsawRow}>
                            <img src="/uploadArrow.svg" alt="logo" className={styles.uploadImage2}/>
                            <input id="secondMap" placeholder="or click to start writing" className={styles.jigsawBoxBottom}/>
                        </div>
                    </div>
                    <div className={styles.priceInfo}>
                        <p>Pricing</p>
                        <input id="price" type="text" placeholder="$0.00" className={styles.priceInput}/>
                    </div>
                    <div className={styles.buttonContainer}>
                        <button type="submit" className={styles.submitButton}>Post Roadmap</button>
                    </div>
                </form>


            </div>

        </div>
    )
}