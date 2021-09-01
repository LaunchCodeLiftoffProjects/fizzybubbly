package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.data.BrandRepository;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("add")
public class AddController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public String displayAddDrink(Model model) {
        model.addAttribute("title", "add a seltz");
        Drink drink = new Drink();
        model.addAttribute("drink", drink);
        model.addAttribute("brands", brandRepository.findAll());
        return "add";
    }

    @PostMapping
    public String processAddDrink(@ModelAttribute Drink newDrink, Model model) {
        model.addAttribute("title", "success");
        drinkRepository.save(newDrink);
        return "success";
    }

}
