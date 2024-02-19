//package pl.gren.oze_app.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class RegistrationController {
//
//    @GetMapping("/register")
//    public String showRegistrationForm(User user) {
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String processRegistration(@ModelAttribute("user") User user) {
//        // Tutaj możesz dodać logikę obsługi rejestracji, taką jak zapis do bazy danych.
//        return "redirect:/login"; // Przekieruj do strony logowania po rejestracji.
//    }
//}