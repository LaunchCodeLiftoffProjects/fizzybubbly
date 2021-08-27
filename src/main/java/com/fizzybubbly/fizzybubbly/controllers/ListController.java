package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("list")
public class ListController {

    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("drinks", drinkRepository.findAll());
        return "list";
    }


}
