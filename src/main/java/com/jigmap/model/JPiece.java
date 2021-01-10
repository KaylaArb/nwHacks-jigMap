package com.jigmap.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class JPiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String type;
    private Date createdOn;
    private int orderNumber;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "jpieces_likes",
        joinColumns = @JoinColumn(
            name = "jpiece_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "user_id"
        )
    )
    private Set<User> userlikes  = new HashSet<User>();

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "jpieces_clicks",
        joinColumns = @JoinColumn(
            name = "jpiece_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "user_id"
        )
    )
    private Set<User> userclicks  = new HashSet<User>();

    public JPiece() {
    }

    public JPiece(Long id, String text, String type, Date createdOn, int orderNumber, Set<User> userlikes, Set<User> userclicks) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.createdOn = createdOn;
        this.orderNumber = orderNumber;
        this.userlikes = userlikes;
        this.userclicks = userclicks;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Set<User> getUserlikes() {
        return this.userlikes;
    }

    public void setUserlikes(Set<User> userlikes) {
        this.userlikes = userlikes;
    }

    public Set<User> getuserclicks() {
        return this.userclicks;
    }

    public void setuserclicks(Set<User> userclicks) {
        this.userclicks = userclicks;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", text='" + getText() + "'" +
            ", type='" + getType() + "'" +
            ", createOn='" + getCreatedOn() + "'" +
            ", orderNumber='" + getOrderNumber() + "'" +
            ", userlikes='" + getUserlikes() + "'" +
            ", userclicks='" + getuserclicks() + "'" +
            "}";
    }


}
