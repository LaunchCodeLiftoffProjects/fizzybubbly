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


    @GetMapping("/{id}")
    public String displayDrinkDetails(@PathVariable Integer id, HttpServletRequest request, Model model) {
        Optional<Drink> result = drinkRepository.findById(id);
        Drink drink = result.get();
        User user = authenticationController.getUserFromSession(request.getSession());
        Review review = new Review();

        review.setDrink(drink);
        review.setUser(user);

        model.addAttribute("review", review);
        model.addAttribute("title", drink.toString());
        model.addAttribute("drink", drink);

        return "drink";
    }

    @PostMapping("/{id}")
    public String submitNewReview(@PathVariable Integer id, @ModelAttribute Review newReview, Model model) {
        Optional<Drink> result = drinkRepository.findById(id);
        Drink drink = result.get();

        model.addAttribute("title", drink.toString());
        model.addAttribute("drink", drink);

        reviewRepository.save(newReview);

        return "drink";
    }
}