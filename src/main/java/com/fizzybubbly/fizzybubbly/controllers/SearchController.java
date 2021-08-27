package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.DrinkData;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private DrinkRepository drinkRepository;

    @RequestMapping
    public String search(Model model) {
        model.addAttribute("title", "find a seltz");
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchTerm){
        Iterable<Drink> drinks;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            drinks = drinkRepository.findAll(Sort.by("brand").ascending().and(Sort.by("flavor").ascending()));
        } else {
            drinks = DrinkData.findByValue(searchTerm, drinkRepository.findAll(Sort.by("brand").ascending().and(Sort.by("flavor").ascending())));
        }
        model.addAttribute("title", "find a seltz: " + searchTerm);
        model.addAttribute("drinks", drinks);

        return "search";
    }

}
