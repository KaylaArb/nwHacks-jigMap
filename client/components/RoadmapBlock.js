import Link from 'next/link'
import styles from '../styles/RoadmapBlock.module.css';


export default function RoadmapBlock({data}) {
    return (
        <article className={styles.block}>
            <div className={styles.header}>
                <img src="/roadmapPhoto.svg" className={styles.photo}/>
                <p className={styles.title}>4 years of a CS Student</p>
                <img src="/ellipses.svg" className={styles.ellipses}/>
            </div>
            <div className={styles.jigsaw1}>
                <img src="/text.svg"/>
                <p className={styles.jigsawText}> Here is text hello this is an example of what it will look like</p>
            </div>
            <div className={styles.jigsaw2}>
                <img src="/video.svg"/>
                <p className={styles.jigsawText}> Here is text hello this is an example of what it will look like</p>
            </div>
            <div className={styles.footer}>
                <img src="/bottomImg.svg" className={styles.photo}/>
            </div>
        </article>

    )
}