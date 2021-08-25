package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Drink {

    @Id
    @GeneratedValue
    private int drinkId;

    private String brand;

    private String flavor;

    private String carbonation;

    private int rating;

    public Drink(int drinkId, String brand, String flavor, String carbonation, int rating) {
        this.drinkId = drinkId;
        this.brand = brand;
        this.flavor = flavor;
        this.carbonation = carbonation;
        this.rating = rating;
    }

    public Drink() {}

    @Override
    public String toString() {
        return brand + " " + flavor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink that = (Drink) o;
        return drinkId == that.drinkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drinkId);
    }

    public int getDrinkId() {
        return drinkId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getCarbonation() {
        return carbonation;
    }

    public void setCarbonation(String carbonation) {
        this.carbonation = carbonation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
