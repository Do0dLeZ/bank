package com.bank.controllers;

import com.bank.ERoles;
import com.bank.model.entity.CustomUser;
import com.bank.security.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin_main";
    }

    @RequestMapping("/add_user_page")
    public String addUserPage(Model model) {
        model.addAttribute("roles", ERoles.values());
        return "add_user_page";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String addUser(@RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam String login,
                          @RequestParam String password,
                          @RequestParam(required = false) String email,
                          @RequestParam(required = false) String phone,
                          @RequestParam(value = "role") ERoles role
    ) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String hashedPass = encoder.encodePassword(password, null);
        CustomUser customUser = new CustomUser(login, hashedPass, role);
        customUser.setName(name);
        customUser.setSurname(surname);
        customUser.setEmail(email);
        customUser.setPhoneNumber(phone);

        userService.addUser(customUser);

        int id = customUser.getId();

        return "redirect:/admin";
    }
}
