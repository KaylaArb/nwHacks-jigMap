import Link from 'next/link'
import styles from '../styles/RoadmapBlock.module.css';
import Pieces from '../components/JigsawPieces'

export default function RoadmapBlock({ data }) {

    var iconImage;
    if (data.user_id === 1) {
        iconImage = "/photoId1.svg";
    } else if (data.user_id === 2) {
        iconImage = "/photoId2.svg";
    } else {
        iconImage = "/roadmapPhoto.svg"
    }

    return (
        <article className={styles.block}>
            <div className={styles.header}>
                <img if src={iconImage} className={styles.photo} />
                <p className={styles.title}>{data.title}</p>
                <img src="/ellipses.svg" className={styles.ellipses} />
            </div>
            <div>
                {data.jpieces.map((piece) => (
                    <Pieces data={piece} />
                ))}
            </div>
            <div className={styles.footer}>
                <img src="/bottomImg.svg" className={styles.photo} />
            </div>
        </article>

    )
}