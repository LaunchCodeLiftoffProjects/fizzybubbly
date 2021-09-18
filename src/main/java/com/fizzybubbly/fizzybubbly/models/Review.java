package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Review extends AbstractEntity {

    private String reviewText;

    @ManyToOne
    private Drink drink;

    @ManyToOne
    private User user;

    public Review() {}

    public Review(String reviewText) {
        this.reviewText = reviewText;
    }

    public Review(String reviewText, Drink drink, User user) {
        this.reviewText = reviewText;
        this.drink = drink;
        this.user = user;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return reviewText;
    }
}
