package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends AbstractEntity {

    private int userId;

    private int drinkId;

    private String review;

    @ManyToOne
    private Drink drink;

    public Review(int userId, int drinkId, String review) {
        this.userId = userId;
        this.drinkId = drinkId;
        this.review = review;
    }

    public Review() {}

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getUserId() {
        return userId;
    }

    public int getDrinkId() {
        return drinkId;
    }
}
