package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserReviews extends AbstractEntity {

    private String username;

    private String review;

    @ManyToOne
    private Drink drink;

    public UserReviews(String username, String review) {
        this.username = username;
        this.review = review;
    }

    public UserReviews() {}

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
