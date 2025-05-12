package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/user/home")
    public String userHome(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "user_home";
    }
}