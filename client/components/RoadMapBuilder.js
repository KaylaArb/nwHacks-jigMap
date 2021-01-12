import React from "react";
import {useState} from 'react';
import styles from '../styles/RoadMapBuilder.module.css';

export default function Builder() {
    const [add, setAdd] = useState('');

    const addTop = () => (
        <div className={styles.jigsawRow}>
            <img src="/uploadArrow.svg" alt="logo" className={styles.uploadImage3}/>
            <input id="thirdJigsaw" placeholder="or click to start writing" className={styles.jigsawBoxTop2}/>
        </div>
    )

    function submitRoadmap() {
        let name = document.getElementById("name").value;
        let descrip = document.getElementById("description").value;
        let jigsaw1 = document.getElementById("firstJigsaw").value;
        let jigsaw2 = document.getElementById("secondJigsaw").value;
        let jigsaw3 = null
        {add === 'Top' ? jigsaw3 = document.getElementById("thirdJigsaw").value : null}
        let pieces = []
        {jigsaw1 ? pieces.push({text: jigsaw1, orderNumber: 1}) : null}
        {jigsaw2 ? pieces.push({text: jigsaw2, orderNumber: 2}) : null}
        {jigsaw3 ? pieces.push({text: jigsaw3, orderNumber: 3}) : null}

        // Simple POST request with a JSON body using fetch
        const requestOptions = {
            method: 'POST',
            // mode: 'no-cors',
            headers: {'content-type': 'application/json'},
            body: JSON.stringify({ title: name, description: descrip, user_id: 3, jpieces: pieces })
        };
        fetch('https://nwhacks-backend.herokuapp.com/api/v1/roadmap/new', requestOptions)
            .then(response => response.json())
            .then(response => {
                window.location.replace("/my-roadmaps")
                console.log(response)
                console.log("it worked")
            })
    }


    return (
        <div className={styles.builder}>
            <h3>Roadmap Builder</h3>
            <div className={styles.container}>
                <form className={styles.form}>
                    <div className={styles.textInfo}>
                        <input type="text" id="name" placeholder="Roadmap Name" required className={styles.inputBox}/>
                        <input type="text" id="description" placeholder="Description/Guidelines"
                               className={styles.inputBox}/>
                        <h4 className={styles.h4}>Jigsaw Pieces</h4>
                    </div>

                    <div className={styles.jigsawInfo}>
                        <div className={styles.jigsawRow}>
                            <img src="/uploadArrow.svg" alt="logo" className={styles.uploadImage}/>
                            <input id="firstJigsaw" placeholder="or click to start writing"
                                   className={styles.jigsawBoxTop}/>
                        </div>
                        <div className={styles.jigsawRow}>
                            <img src="/uploadArrow.svg" alt="logo" className={styles.uploadImage2}/>
                            <input id="secondJigsaw" placeholder="or click to start writing"
                                   className={styles.jigsawBoxBottom}/>
                        </div>
                        {add === 'Top' ? addTop() : ''}
                        <button type="button" onClick={() => setAdd('Top')} className={styles.addButton}> +</button>
                    </div>
                    <div className={styles.priceInfo}>
                        <p>Pricing</p>
                        <input id="price" type="text" placeholder="$0.00" className={styles.priceInput}/>
                    </div>
                    <div className={styles.buttonContainer}>
                        <button type="button" className={styles.submitButton} onClick={submitRoadmap}>Post Roadmap</button>
                    </div>
                </form>
            </div>

        </div>
    )
}



