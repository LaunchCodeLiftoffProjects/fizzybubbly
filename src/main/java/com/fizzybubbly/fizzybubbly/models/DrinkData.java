package com.fizzybubbly.fizzybubbly.models;

import java.util.ArrayList;
import java.util.Collections;

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

        results.sort(Drink.DrinkNameComparator);

        return results;
    }

    public static ArrayList<Drink> findByFieldAndValue(String field, String field1, int field2, String value, Iterable<Drink> allDrinks) {

        ArrayList<Drink> filter = new ArrayList<Drink>();

        ArrayList<Drink> results = new ArrayList<Drink>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Drink>) allDrinks;
        }

        if (field.equals("all") && field1.equals("all") && field2 == 0) {
            results = findByValue(value, allDrinks);
            results.sort(Drink.DrinkNameComparator);
            return results;
        }

        for (Drink drink : allDrinks) {
            if (drink.getCarbonation().toLowerCase().contains(field) && field1.equals("all") && field2 == 0) {
                filter.add(drink);
            } else if (drink.getBrand().toLowerCase().contains(field1) && field.equals("all") && field2 == 0) {
                filter.add(drink);
            } else if (drink.getRating() == field2 && field.equals("all") && field1.equals("all")) {
                filter.add(drink);
            } else if (drink.getCarbonation().toLowerCase().contains(field) && drink.getBrand().toLowerCase().contains(field1) && field2 == 0) {
                filter.add(drink);
            } else if (drink.getCarbonation().toLowerCase().contains(field) && drink.getRating() == field2 && field1.equals("all")) {
                filter.add(drink);
            } else if (drink.getBrand().toLowerCase().contains(field1) && drink.getRating() == field2 && field.equals("all")) {
                filter.add(drink);
            } else if (drink.getCarbonation().toLowerCase().contains(field) && drink.getBrand().toLowerCase().contains(field1) && drink.getRating() == field2) {
                filter.add(drink);
            }
        }

        if (value.equals("")) {
            filter.sort(Drink.DrinkNameComparator);
            return filter;
        } else {
            results = findByValue(value, filter);
            results.sort(Drink.DrinkNameComparator);
            return results;
        }

    }

}
