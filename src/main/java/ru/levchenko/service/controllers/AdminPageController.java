package ru.levchenko.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.levchenko.service.models.Role;
import ru.levchenko.service.models.State;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.UsersRepository;

import java.util.Map;

@Controller
@RequestMapping("adminPage")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminPageController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping
    public String getAdminPage(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "adminPage";
    }

    @GetMapping("{userId}")
    public String userEditForm(@PathVariable Long userId, Model model) {
        User user = usersRepository.findOne(userId);
        model.addAttribute("user1", user);
        model.addAttribute("role", Role.ADMIN);
        model.addAttribute("status", State.ACTIVE);
        return "userEdit";
    }

    @PostMapping
    public String editUser(
            @RequestParam Map<String, String> form,
            @RequestParam("userId") Long id) {

        User user = usersRepository.findOne(id);
        user.setLogin(form.get("login"));
        user.setFirstName(form.get("firstName"));
        user.setLastName(form.get("lastName"));

        if (form.containsKey("status")) {
            user.setState(State.ACTIVE);
        } else {
            user.setState(State.BANNED);
        }

        if (form.containsKey("role")) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
        usersRepository.save(user);

        return "redirect:/adminPage";


    }

}
