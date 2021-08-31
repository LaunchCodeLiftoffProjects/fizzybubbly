package com.fizzybubbly.fizzybubbly.models;

import java.util.ArrayList;

public class DrinkData {

    public static ArrayList<Drink> findByValue(String value, Iterable<Drink> allDrinks) {
        String lower_val = value.toLowerCase();

        ArrayList<Drink> results = new ArrayList<>();

        for (Drink drink : allDrinks) {
            if (drink.getBrand().toLowerCase().contains(lower_val)) {
                results.add(drink);
            } else if (drink.getFlavor().toLowerCase().contains(lower_val)) {
                results.add(drink);
            } else if (drink.getCarbonation().toLowerCase().contains(lower_val)) {
                results.add(drink);
            } else if (drink.toString().toLowerCase().contains(lower_val)) {
                results.add(drink);
            }
        }
        return results;
    }

    public static ArrayList<Drink> findByFieldAndValue(String field, String value, Iterable<Drink> allDrinks) {

        String lower_val = value.toLowerCase();

        ArrayList<Drink> filter = new ArrayList<>();
        ArrayList<Drink> results = new ArrayList<>();

        if (lower_val.equals("all")){
            return (ArrayList<Drink>) allDrinks;
        }

        if (field.equals("all")){
            results = findByValue(value, allDrinks);
            return results;
        }

        for (Drink drink : allDrinks) {

            if (drink.getBrand().toLowerCase().contains(field)) {
                filter.add(drink);
            }
            if (drink.getCarbonation().toLowerCase().contains(field)) {
                filter.add(drink);
            }
        }

        if (value.equals("")) {
            return filter;
        } else {
            results = findByValue(value, filter);
            return results;
        }

    }

}
