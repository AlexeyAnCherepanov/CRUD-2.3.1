package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "user";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String edit(Model model, @RequestParam long id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit_user";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") long id, @ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUsers(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
