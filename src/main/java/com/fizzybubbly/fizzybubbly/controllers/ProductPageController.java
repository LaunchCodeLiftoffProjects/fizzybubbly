package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.DrinkData;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("productPage")
public class ProductPageController {

    @Autowired
    private DrinkRepository drinkRepository;

    @RequestMapping("")
    public String productInfo(Model model) {
        model.addAttribute("title", "seltz info");
        model.addAttribute("drinks", drinkRepository.findAll());
        return "productPage";
    }

    @PostMapping("{drink.brand}+{drink.flavor}")
    public String displaySeltzInfo(Model model, @RequestParam String searchTerm) {
        Iterable<Drink> drinks = null;
        if (searchTerm.toLowerCase().equals("${drink.brand} + ${drink.flavor}")) {
            drinks = DrinkData.findByValue(searchTerm, drinkRepository.findAll());
            model.addAttribute("title", searchTerm + "seltzy info:");
            model.addAttribute("drinks", drinks);
        } else
            model.addAttribute("title", searchTerm + "seltzy info not in database");

        return "{drink.brand}+{drink.flavor}";
    }
}