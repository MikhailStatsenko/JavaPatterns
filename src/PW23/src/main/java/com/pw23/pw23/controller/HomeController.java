package com.pw23.pw23.controller;

import com.pw23.pw23.security.UsersDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "/home";
    }

//    @GetMapping("/showUserInfo")
//    public String showUserInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UsersDetails userDetails = (UsersDetails) authentication.getPrincipal();
//        System.out.println(userDetails.getUser());
//        return "/home";
//    }
}
