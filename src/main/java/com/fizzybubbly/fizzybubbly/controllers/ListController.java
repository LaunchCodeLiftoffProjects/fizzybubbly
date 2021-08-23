package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.DrinkData;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("list")
public class ListController {

    @Autowired
    private DrinkRepository drinkRepository;

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("drinks", drinkRepository.findAll());
        return "list";
    }
}

// ToDo: Refactor Drink class into separate file, change to public
// ToDo: Add repository class to map the csv file to the drink object

class Drink {
    public String name;
    public String carbonation;
    // Talk to group about considering an enum for carbonation to limit the values of that property.
    public String flavor;
    public double rating;
    // Talk to group about whether we want to use a double or an int
}
