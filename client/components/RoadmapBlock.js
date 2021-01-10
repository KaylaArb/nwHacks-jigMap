import Link from 'next/link'
import styles from '../styles/RoadmapBlock.module.css';
import Pieces from '../components/JigsawPieces'


export default function RoadmapBlock( {data} ) {

    return (
        <article className={styles.block}>
            <div className={styles.header}>
                <img src="/roadmapPhoto.svg" className={styles.photo}/>
                <p className={styles.title}>{data.title}</p>
                <img src="/ellipses.svg" className={styles.ellipses}/>
            </div>

            {data.jpieces.map((piece) => (
                <Pieces data={piece}/>
            ))}

            <div className={styles.footer}>
                <img src="/bottomImg.svg" className={styles.photo}/>
            </div>
        </article>

    )
}