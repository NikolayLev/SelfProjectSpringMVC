package ru.levchenko.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SignUpController {

    //@Autowired
    //private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    //@PostMapping("/signUp")
    //public String signUp(UserForm userForm) {
    //    service.signUp(userForm);
    //    return "redirect:/login";
    //}
}