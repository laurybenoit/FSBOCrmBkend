package com.fsbocrmbkend.fsbocrmbkend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class UserProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String profileDescription;

    @OneToOne(mappedBy = "userProfile")
    @JsonIgnore
    private User user;

    public UserProfile(Long id, String firstName, String lastName, String profileDescription, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileDescription = profileDescription;

    }

    public UserProfile(String firstName, String lastName, String description) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}