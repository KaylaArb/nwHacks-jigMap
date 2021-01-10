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

@Entity
public class JPiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String type;
    private Date createOn;
    private int orderNumber;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
        name = "jpieces_likes",
        joinColumns = @JoinColumn(
            name = "jpiece_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "user_id"
        )
    )
    private List<User> userlikes  = new ArrayList<User>();

    public JPiece() {
    }


    public JPiece(Long id, String text, String type, Date createOn, int orderNumber, List<User> userlikes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.createOn = createOn;
        this.orderNumber = orderNumber;
        this.userlikes = userlikes;
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

    public Date getCreateOn() {
        return this.createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<User> getUserlikes() {  
        return this.userlikes;
    }

    public void setUserlikes(List<User> userlikes) {
        this.userlikes = userlikes;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", text='" + getText() + "'" +
            ", type='" + getType() + "'" +
            ", createOn='" + getCreateOn() + "'" +
            ", orderNumber='" + getOrderNumber() + "'" +
            ", userlikes='" + getUserlikes() + "'" +
            "}";
    }
    


}
