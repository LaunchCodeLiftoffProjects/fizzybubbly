package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping
    public String profile(Model model, HttpSession session) {
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("title", user.getUsername());
        model.addAttribute(user);
        return "profile";
    }

}

