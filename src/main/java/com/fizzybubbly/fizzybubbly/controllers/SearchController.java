package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.DrinkData;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private DrinkRepository drinkRepository;

    static HashMap<String, String> fieldChoices = new HashMap<>();

    public SearchController () {
        fieldChoices.put("all", "All");
        fieldChoices.put("heavy", "Heavy");
        fieldChoices.put("medium", "Medium");
        fieldChoices.put("light", "Light");
    }

    @RequestMapping
    public String search(Model model) {
        for (Drink drink : drinkRepository.findAll()) {
            String key = drink.getBrand().toLowerCase();
            String value = drink.getBrand();
            fieldChoices.put(key, value);
        }
        model.addAttribute("title", "find a seltz");
        model.addAttribute("fieldChoices", fieldChoices);
        return "search";
    }

    @GetMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchField, @RequestParam String searchTerm) {
        Iterable<Drink> drinks;
//        Sort sortOrder = Sort.by("drink.carbonation");
        if (searchTerm.toLowerCase().equals("all")){
            drinks = drinkRepository.findAll();
        } else {
            drinks = DrinkData.findByFieldAndValue(searchField, searchTerm, drinkRepository.findAll());
        }
        model.addAttribute("title", "find a seltz: " + searchTerm);
        model.addAttribute("fieldChoices", fieldChoices);
        model.addAttribute("drinks", drinks);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchField", searchField);

        return "search";
    }

}

