package com.example.comptabilite.controllers;

import com.example.comptabilite.models.Users;

import com.example.comptabilite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired  UserRepository userRepository;

    @GetMapping("/users")
    public String getAll(Model model){
        Iterable<Users> listusers =  userRepository.findAll();
        model.addAttribute("listusers",listusers);
        return "users";
    }
    @GetMapping("/users/new")
    public String showProduit(Model model){
        model.addAttribute("users",new Users());
        return "addusers";
    }
    @PostMapping("/users/create")
    public String create(@ModelAttribute("users") Users users)
    {
        userRepository.save(users);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        try {
            Users users = userRepository.findById(id).get();
            model.addAttribute("users",users);
            return "addusers";
        }catch (Exception e){
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteusers(@PathVariable Long id)
    {
        Users deleteusers = userRepository.findById(id).get();
        userRepository.delete(deleteusers);
        return "redirect:/users";
    }
}
