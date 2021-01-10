package com.jigmap.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="rm_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long user_id;
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
    private List<Roadmap> roadmaps  = new ArrayList<>();;

    public User() {
    }



    public User(Long user_id, String userName, Date dateOfBirth, String email, String password, String profile, List<Roadmap> roadmaps) {
        this.user_id = user_id;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.roadmaps = roadmaps;
    }
    

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
    

}
