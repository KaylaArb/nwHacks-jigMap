package com.jigmap.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="rm_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "User Name is mandatory")
    private String userName;
    private Date dateOfBirth;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
    private String profile;

    @OneToMany(targetEntity=Roadmap.class, fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id")
    private List<Roadmap> roadmaps  = new ArrayList<>();

    @ManyToMany(mappedBy = "userlikes", cascade=CascadeType.ALL)
    private List<Roadmap> likedRoadmaps = new ArrayList<Roadmap>();
    @ManyToMany(mappedBy = "usersubscriptions", cascade=CascadeType.ALL)
    private List<Roadmap> subscribedRoadmaps = new ArrayList<Roadmap>();

    public User() {
    }


    public User(Long id, String userName, Date dateOfBirth, String email, String password, String profile, List<Roadmap> roadmaps, List<Roadmap> likedRoadmaps, List<Roadmap> subscribedRoadmaps) {
        this.id = id;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.roadmaps = roadmaps;
        this.likedRoadmaps = likedRoadmaps;
        this.subscribedRoadmaps = subscribedRoadmaps;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    


    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public List<Roadmap> getRoadmaps() {
        return this.roadmaps;
    }

    public void setRoadmaps(List<Roadmap> roadmaps) {
        this.roadmaps = roadmaps;
    }


    public List<Roadmap> getLikedRoadmaps() {
        return this.likedRoadmaps;
    }

    public void setLikedRoadmaps(List<Roadmap> likedRoadmaps) {
        this.likedRoadmaps = likedRoadmaps;
    }

    public List<Roadmap> getSubscribedRoadmaps() {
        return this.subscribedRoadmaps;
    }

    public void setSubscribedRoadmaps(List<Roadmap> subscribedRoadmaps) {
        this.subscribedRoadmaps = subscribedRoadmaps;
    }

    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", profile='" + getProfile() + "'" +
            ", roadmaps='" + getRoadmaps() + "'" +
            ", likeRoadmaps='" + getLikedRoadmaps() + "'" +
            ", subscribedRoadmaps='" + getSubscribedRoadmaps() + "'" +
            "}";
    }


}
