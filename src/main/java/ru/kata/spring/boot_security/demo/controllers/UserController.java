package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
@Secured({"ROLE_USER", "ROLE_ADMIN"})
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getPersonalData(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "userPage";

    }


}
