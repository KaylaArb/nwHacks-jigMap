import Link from 'next/link'
import styles from '../styles/RoadmapBlock.module.css';
import Pieces from '../components/JigsawPieces'


export default function RoadmapBlock({data}) {
    let filterButtons = [{name :"Ascending", value:"ascending" }, {name :"Descending", value:"descending" }, {name :"Ascending", value:"ascending" }]

    return (
        <article className={styles.block}>
            <div className={styles.header}>
                <img src="/roadmapPhoto.svg" className={styles.photo}/>
                <p className={styles.title}>4 years of a CS Student</p>
                <img src="/ellipses.svg" className={styles.ellipses}/>
            </div>

            {filterButtons.map((piece) => (
                <Pieces data={piece}/>
            ))}

            <div className={styles.footer}>
                <img src="/bottomImg.svg" className={styles.photo}/>
            </div>
        </article>

    )
}