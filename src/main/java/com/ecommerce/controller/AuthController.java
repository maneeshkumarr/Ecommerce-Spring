package com.ecommerce.controller;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            if (user.getRole() == User.Role.ADMIN) return "redirect:/admin/home";
            else return "redirect:/user/home";
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password1, @RequestParam String password2, Model model) {
        if (!password1.equals(password2)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }
        if (userRepository.findByEmail(email) != null) {
            model.addAttribute("error", "Email already exists");
            return "register";
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password1);
        user.setRole(User.Role.USER);
        userRepository.save(user);
        return "redirect:/login";
    }
}
