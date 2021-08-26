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

}
