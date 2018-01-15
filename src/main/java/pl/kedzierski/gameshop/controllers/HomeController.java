package pl.kedzierski.gameshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String getHome(){
        return "/home";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "/login";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "/contact";
    }
}