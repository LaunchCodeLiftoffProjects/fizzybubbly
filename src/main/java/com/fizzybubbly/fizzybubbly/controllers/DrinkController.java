package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.Review;
import com.fizzybubbly.fizzybubbly.models.User;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import com.fizzybubbly.fizzybubbly.models.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("drink")
public class DrinkController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AuthenticationController authenticationController;

    boolean userHasReviewed;

    @GetMapping("/{drinkId}")
    public String displayDrinkDetails(@PathVariable Integer drinkId, HttpServletRequest request, Model model) {
        Optional<Drink> result = drinkRepository.findById(drinkId);
        Drink drink = result.get();
        User user = authenticationController.getUserFromSession(request.getSession());
        Review review = new Review();

        review.setDrink(drink);
        review.setUser(user);

        userHasReviewed = false;

        //if user is not null and there is a review of drink by user, userHasReviewed is true
        if (user != null && !reviewRepository.findReviewsByDrinkIdAndUserId(drinkId, user.getId()).isEmpty()) {
                userHasReviewed = true;
        };

        model.addAttribute("review", review);
        model.addAttribute("title", drink.toString());
        model.addAttribute("drink", drink);
        model.addAttribute("user", user);
        model.addAttribute("userHasReviewed", userHasReviewed);
        model.addAttribute("isNewReview", false);

        return "drink";
    }

    @PostMapping("/{drinkId}")
    public String submitNewReview(@PathVariable Integer drinkId, @ModelAttribute Review newReview, Model model) {
        Optional<Drink> result = drinkRepository.findById(drinkId);
        Drink drink = result.get();

        reviewRepository.save(newReview);
        userHasReviewed = true;

        model.addAttribute("title", drink.toString());
        model.addAttribute("drink", drink);
        model.addAttribute("userHasReviewed", userHasReviewed);
        model.addAttribute("isNewReview", true);

        return "drink";
    }
}