package com.ricoom.techie.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ricoom.techie.services.ProductService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Controller
public class UserController {
	private ProductService productservice;


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
public String showUserList(Model model) {
    model.addAttribute("products", productservice.getAllProducts());
    // System.out.println(productservice.getAllProducts());
    return "index";
}
}
