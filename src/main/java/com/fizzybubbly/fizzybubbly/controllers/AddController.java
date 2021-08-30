package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("add")
public class AddController {

    @GetMapping
    public String displayAddDrink(Model model) {
        model.addAttribute("title", "add a seltz");
        return "add";
    }

    @PostMapping
    public String processAddDrink(@ModelAttribute Drink newDrink, Model model) {
        model.addAttribute("title", "success");
        return "success";
    }

}
