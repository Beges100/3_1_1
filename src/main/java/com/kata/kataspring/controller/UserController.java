package com.kata.kataspring.controller;

import com.kata.kataspring.model.User;
import com.kata.kataspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/new")
    public String createUser(ModelMap model) {
        model.addAttribute("user", new User());
        
        return "new";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }


    @RequestMapping("/")
    public String printUsers(ModelMap model) {
            model.addAttribute("allUsers", userService.getAllUsers());

        return "users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUserById(id);

        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);

        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserAtId(id));

        return "/edit";
    }

}
