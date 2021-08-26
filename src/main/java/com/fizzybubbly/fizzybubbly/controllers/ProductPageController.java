package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping ("productPage")
public class ProductPageController {

    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping("")
    public String displayDrinkDetails(@RequestParam int drinkId, Model model) {
        Optional<Drink> result = drinkRepository.findById(drinkId);
//        Drink drink = drinkRepository.findById(drinkId).get();
//        if (result.isEmpty()) {
//            model.addAttribute("title", "Invalid Drink ID: " + drinkId);
//        } else {
            Drink drink = result.get();
            model.addAttribute("title", drink.toString() + " Details");
            model.addAttribute("drink", drink);
//        }
        return "productPage";
    }

//    @GetMapping("")
//    public String displayDrinkDetails(@RequestParam int drinkId, Model model) {
//        Optional<Drink> result = drinkRepository.findById(drinkId);
//
//            Drink drink = result.get();
//            model.addAttribute("title", drink.toString() + " Details");
//            model.addAttribute("drink", drink);
//
//        return "productPage";
//    }



}
