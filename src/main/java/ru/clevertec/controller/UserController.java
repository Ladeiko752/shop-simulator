package ru.clevertec.controller;

import ru.clevertec.entity.User;
import ru.clevertec.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationView(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user){
        userService.saveUser(user);
        return "redirect:/login";
    }


}
