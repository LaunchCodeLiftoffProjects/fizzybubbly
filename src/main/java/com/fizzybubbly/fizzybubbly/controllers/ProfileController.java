package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.Review;
import com.fizzybubbly.fizzybubbly.models.User;
import com.fizzybubbly.fizzybubbly.models.data.ReviewRepository;
import com.fizzybubbly.fizzybubbly.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String profile(Model model, HttpSession session) {
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("title", user.getUsername());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("reviews", user.getReviews());
        model.addAttribute(user);

        return "profile";
    }
}


