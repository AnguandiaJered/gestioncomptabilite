package com.example.comptabilite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
    @GetMapping("/")
    public String showHomePage(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "index";
    }
}
