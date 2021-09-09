package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Brand;
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
        return "add/addDrink";
    }

    @PostMapping
    public String processAddDrink(@ModelAttribute Drink newDrink, Model model) {
        model.addAttribute("title", "success");
        model.addAttribute("addSuccess", "Drink successfully added");
        drinkRepository.save(newDrink);
        return "add/success";
    }

    @GetMapping("addBrand")
    public String displayAddBrand(Model model) {
        model.addAttribute("title", "add brand");
        Brand brand = new Brand();
        model.addAttribute("brand", brand);
        return "add/addBrand";
    }

    @PostMapping("addBrand")
    public String processAddBrand(@ModelAttribute Brand newBrand, Model model) {
        model.addAttribute("title", "success");
        model.addAttribute("addSuccess", "Brand successfully added");
        brandRepository.save(newBrand);
        return "add/success";
    }

}
