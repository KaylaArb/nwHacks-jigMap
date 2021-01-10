import styles from '../styles/RoadmapBlock.module.css';

export default function Pieces({data}) {
    let min = Math.ceil(1);
    let max = Math.floor(4);
    let random = Math.round((Math.random() * (max - min) + min) * 1)
    return (
        <div>
            <div className={`${styles.jigsaw1} ${random === 1 ? styles.active : ''}`}>
                <img src="/text.svg"/>
                <p className={styles.jigsawText}> {data.text}</p>
            </div>
            <div className={`${styles.jigsaw2} ${random === 2 ? styles.active : ''}`}>
                <img src="/video.svg"/>
                <p className={styles.jigsawText}> {data.text}</p>
            </div>
            <div className={`${styles.jigsaw3} ${random === 3 ? styles.active : ''}`}>
                <img src="/link.svg"/>
                <p className={styles.jigsawText}> {data.text}</p>
            </div>
            <div className={`${styles.jigsaw4} ${random === 4 ? styles.active : ''}`}>
                <img src="/image.svg"/>
                <p className={styles.jigsawText}> {data.text}</p>
            </div>
        </div>
    )


}