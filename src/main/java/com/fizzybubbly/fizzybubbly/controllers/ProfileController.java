package com.fizzybubbly.fizzybubbly.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @GetMapping
    public String profile(Model model) {
        model.addAttribute("title", "your profile");
        System.out.println("this works");
        return "profile";
    }

}

