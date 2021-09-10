package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("drink")
public class DrinkController {

    @Autowired
    private DrinkRepository drinkRepository;

//    @GetMapping("/{id}")
//    public String displayDrinkDetails(@PathVariable Integer id, Model model) {
//        Optional<Drink> result = drinkRepository.findById(id);
//        Drink drink = result.get();
//
//        model.addAttribute("title", drink.toString());
//        model.addAttribute("drink", drink);
//
//        return "drink";
//
//    }
//
//    @PostMapping("/{id}")
//    public String submitNewReview(@PathVariable Integer id, Model model) {
//
//        return "drink";
//    }


//````````````TEST AREA````````````````

    @GetMapping("/{id}")
    public String displayDrinkDetails(@PathVariable Integer id, Model model) {
        Optional<Drink> result = drinkRepository.findById(id);
        Drink drink = result.get();

        model.addAttribute("title", drink.toString());
        model.addAttribute("drink", drink);

        return "drink";

    }

    @PostMapping("/{id}")
    public String submitNewReview(@PathVariable Integer id, Model model) {
        Optional<Drink> result = drinkRepository.findById(id);
        Drink drink = result.get();

        model.addAttribute("title", drink.toString());
        model.addAttribute("drink", drink);

        return "drink";
    }
}