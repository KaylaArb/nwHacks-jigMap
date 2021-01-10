import React from "react";
import {useState, useEffect} from 'react';
import styles from '../styles/RoadMapBuilder.module.css';
import Router from "next/router";

export default function Builder() {
    const [add, setAdd] = useState('');

    const addTop = () => (
        <div className={styles.jigsawRow}>
            <img src="/uploadArrow.svg" alt="logo" className={styles.uploadImage3}/>
            <input id="thirdMap" placeholder="or click to start writing" className={styles.jigsawBoxTop2}/>
        </div>
    )

    // const handleSearch = () => {
    //     const path = router.pathname
    //     const query = router.query
    //     query.search = searchValue
    //     setHomePage(false);
    //     router.push({
    //         pathname: path,
    //         query: query,
    //     }).then(() => window.scrollTo(0, 0));
    //     setSearchValue('')
    // };

    // function buttonFilter(buttonValue) {
    //     let value = buttonValue;
    //     fetch("http://localhost:8080/api/filter/" + value)
    //         .then((response) => response.json())
    //         .then( response => {
    //             router.reload(window.location.pathname);})
    // }


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
                            <input id="firstMap" placeholder="or click to start writing"
                                   className={styles.jigsawBoxTop}/>
                        </div>
                        <div className={styles.jigsawRow}>
                            <img src="/uploadArrow.svg" alt="logo" className={styles.uploadImage2}/>
                            <input id="secondMap" placeholder="or click to start writing"
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
                        <button type="submit" className={styles.submitButton} onClick={submitRoadmap}>Post Roadmap</button>
                    </div>
                </form>
            </div>

        </div>
    )
}

// export async function getServerSideProps() {
//     const res = await fetch(`https://...`)
//     const data = await res.json()
//
//     return {
//         props: {data},
//     }
// }

function submitRoadmap() {
    let name = document.getElementById("name").value;
    let description = document.getElementById("description").value;
    // let jpieces = document.getElementById("firstMap").value;
    let price = document.getElementById("price").value;
    let firstMap = document.getElementById("firstMap").value;
    let secondMap = document.getElementById("firstMap").value;

    fetch("https://nwhacks-backend.herokuapp.com/api/v1/roadmap/new", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'},
        body: JSON.stringify({title:name, description: description,user_id:2})})
        .then(response => {
            window.location.replace("/roadmaps")
            console.log(response)
            console.log("it worked")
        })
}

