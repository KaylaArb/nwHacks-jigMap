package com.jigmap.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roadmap")
public class Roadmap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int price;
    private int totalTime;
    private Date publicationDate;
    private int rank;
    private int classifiedPrediction;
    private int user_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="rm_id", referencedColumnName = "id")
    private List<JPiece> jPieces  = new ArrayList<>();

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
        name = "roadmap_likes",
        joinColumns = @JoinColumn(
            name = "roadmap_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "user_id"
        )
    )
    private List<User> userlikes  = new ArrayList<User>();
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "roadmap_subscriptions", joinColumns = @JoinColumn(name = "roadmap_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> usersubscriptions  = new ArrayList<User>();
    

    public Roadmap() {
    }

    


    public Roadmap(Long id, String title, String description, int price, int totalTime, Date publicationDate, int rank, int classifiedPrediction, int user_id, List<JPiece> jPieces, List<User> userlikes, List<User> usersubscriptions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.totalTime = totalTime;
        this.publicationDate = publicationDate;
        this.rank = rank;
        this.classifiedPrediction = classifiedPrediction;
        this.user_id = user_id;
        this.jPieces = jPieces;
        this.userlikes = userlikes;
        this.usersubscriptions = usersubscriptions;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public Date getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getClassifiedPrediction() {
        return this.classifiedPrediction;
    }

    public void setClassifiedPrediction(int classifiedPrediction) {
        this.classifiedPrediction = classifiedPrediction;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<JPiece> getJPieces() {
        return this.jPieces;
    }

    public void setJPieces(List<JPiece> jPieces) {
        this.jPieces = jPieces;
    }

    public List<User> getUserlikes() {
        return this.userlikes;
    }

    public void setUserlikes(List<User> userlikes) {
        this.userlikes = userlikes;
    }

    public List<User> getUsersubscriptions() {
        return this.usersubscriptions;
    }

    public void setUsersubscriptions(List<User> usersubscriptions) {
        this.usersubscriptions = usersubscriptions;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            ", totalTime='" + getTotalTime() + "'" +
            ", publicationDate='" + getPublicationDate() + "'" +
            ", rank='" + getRank() + "'" +
            ", classifiedPrediction='" + getClassifiedPrediction() + "'" +
            ", user_id='" + getUser_id() + "'" +
            ", jPieces='" + getJPieces() + "'" +
            ", userlikes='" + getUserlikes() + "'" +
            ", usersubscriptions='" + getUsersubscriptions() + "'" +
            "}";
    }
    

}
