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
