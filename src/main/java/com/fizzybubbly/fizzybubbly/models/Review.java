package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends AbstractEntity {

    private String review;

    @ManyToOne
    private Drink drink;

    @ManyToOne
    private User user;

    public Review(String review) {
        this.review = review;
    }

    public Review() {}

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return review;
    }
}
