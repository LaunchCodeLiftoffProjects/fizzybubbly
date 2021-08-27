package com.fizzybubbly.fizzybubbly.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("add")
public class AddController {

    @GetMapping
    public String add(Model model) {
        model.addAttribute("title", "add a seltz");
        return "add";
    }

}
