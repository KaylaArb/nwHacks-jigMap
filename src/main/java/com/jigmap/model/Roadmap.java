package com.jigmap.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roadmap")
public class Roadmap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private int price;
    private Date publicationDate;
    private int rank;
    private int classifiedPrediction;
    private int user_id;

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



    public Roadmap(Long id, String title, String description, int price, Date publicationDate, int rank, int classifiedPrediction, int user_id, List<User> userlikes, List<User> usersubscriptions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.publicationDate = publicationDate;
        this.rank = rank;
        this.classifiedPrediction = classifiedPrediction;
        this.user_id = user_id;
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Roadmap)) {
            return false;
        }
        Roadmap roadmap = (Roadmap) o;
        return Objects.equals(id, roadmap.id) && Objects.equals(title, roadmap.title) && Objects.equals(description, roadmap.description) && price == roadmap.price && Objects.equals(publicationDate, roadmap.publicationDate) && rank == roadmap.rank && classifiedPrediction == roadmap.classifiedPrediction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, publicationDate, rank, classifiedPrediction);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            ", publicationDate='" + getPublicationDate() + "'" +
            ", rank='" + getRank() + "'" +
            ", classifiedPrediction='" + getClassifiedPrediction() + "'" +
            ", user_id='" + getUser_id() + "'" +
            "}";
    }
    

}
