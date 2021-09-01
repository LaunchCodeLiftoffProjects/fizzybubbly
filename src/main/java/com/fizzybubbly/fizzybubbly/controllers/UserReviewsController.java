package com.fizzybubbly.fizzybubbly.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("review")
public class UserReviewsController {

    @GetMapping
    public String review(Model model) {
        model.addAttribute("title", "make or edit a seltz review");
        return "review";
    }

}

