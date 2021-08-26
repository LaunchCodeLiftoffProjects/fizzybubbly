package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.DrinkData;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("productPage")
public class ProductPageController {

    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping("")
    public String displayDrinkDetails(@RequestParam Integer drinkId, Model model) {
        Optional<Drink> result = drinkRepository.findById(drinkId);
        Drink drink = result.get();
        model.addAttribute("title", drink);
        model.addAttribute("drink", drink);

        return "productPage";

    }
}