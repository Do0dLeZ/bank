package com.bank.controllers;

import com.bank.ERoles;
import com.bank.model.entity.CustomUser;
import com.bank.security.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private IUserService userService;
    @RequestMapping
    public String mainPage() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CustomUser customUser = userService.getUserByLogin(user.getUsername());

        if (customUser.getRole().equals(ERoles.ADMIN))
            return "redirect:/admin";
        else if (customUser.getRole().equals(ERoles.CLIENT)) {
            return "redirect:/client";
        }

        return "redirect:/";
    }
}
