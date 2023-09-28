package com.example.spring.controllers;

import com.example.spring.dao.Users;
import com.example.spring.services.UserServiceJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/magic")
public class UserController {

    @Autowired
    private UserServiceJpa userServiceJpa;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("user", new Users());
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String password) {
        userServiceJpa.addUser(new Users(name, password));
        log.info("User add successfully");
        return "redirect:/main";
    }

    @PostMapping("/info")
    public ResponseEntity<String> testPostRequest() {
        log.info("Inside testPostRequest");
        return ResponseEntity.ok("POST request successful");
    }

    @GetMapping("/main")
    public String showMainPage() {
        return "main";
    }
}
