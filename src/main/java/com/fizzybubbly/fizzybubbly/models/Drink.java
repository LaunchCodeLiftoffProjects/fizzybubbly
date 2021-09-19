package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
public class Drink extends AbstractEntity {

    @ManyToOne
    private Brand brand;

    @OneToMany(mappedBy = "drink")
    private List<Review> reviews = new ArrayList<>();

    private String flavor;

    private String carbonation;

    private int rating;

    public String imagePath;


    public Drink(Brand brand, String flavor, String carbonation, int rating, String imagePath) {
        this.brand = brand;
        this.flavor = flavor;
        this.carbonation = carbonation;
        this.rating = rating;
        this.imagePath = imagePath;
    }

    public Drink() {
    }


    public Drink(Brand brand, String flavor, String carbonation, int rating, String imagePath, List<Review> reviews) {
        this.brand = brand;
        this.flavor = flavor;
        this.carbonation = carbonation;
        this.rating = rating;
        this.imagePath = imagePath;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return brand.getName() + " " + flavor;
    }

    public String getBrand() {
        return brand.getName();
    }

    public void setBrand(Brand brand) {
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public static Comparator<Drink> DrinkNameComparator = new Comparator<Drink>() {

        public int compare(Drink a, Drink b) {
            String Drink1 = a.getBrand().toLowerCase();
            String Drink2 = b.getBrand().toLowerCase();

            return Drink1.compareTo(Drink2);

            // descending order
            // return
            // StudentName2.compareTo(StudentName1);
        }
    };

}
