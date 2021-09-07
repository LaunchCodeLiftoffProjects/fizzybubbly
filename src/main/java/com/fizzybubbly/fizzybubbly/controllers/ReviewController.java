package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Review;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import com.fizzybubbly.fizzybubbly.models.data.ReviewRepository;
import com.fizzybubbly.fizzybubbly.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String review(Model model) {
        model.addAttribute("title", "create a seltz review");
        Review review = new Review();
        model.addAttribute("review", review);
        return "review";
    }

    @PostMapping
    public String processNewReview(@ModelAttribute Review newReview, Model model) {
        model.addAttribute("title", "success");
        reviewRepository.save(newReview);
        return "success";
    }

}

