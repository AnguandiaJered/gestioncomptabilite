package com.example.comptability.controllers;

import com.example.comptability.models.Depenses;
import com.example.comptability.models.Produits;
import com.example.comptability.models.Recettes;
import com.example.comptability.repository.ProduitRepository;
import com.example.comptability.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RecetteController {
    @Autowired RecetteRepository recetteRepository;


    @GetMapping("/recette")
    public String getAll(Model model){
        Iterable<Recettes> listrecette =  recetteRepository.findAll();
        model.addAttribute("listrecette",listrecette);
        return "recette";
    }
    @GetMapping("/recette/new")
    public String showDepense(Model model){
        model.addAttribute("recettes",new Recettes());
        return "addrecette";
    }

    @PostMapping("/recette/create")
    public String create(Recettes recettes)
    {
        recetteRepository.save(recettes);
        return "redirect:/recette";
    }

    @GetMapping("/recette/edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        try {
            Recettes recettes = recetteRepository.findById(id).get();
            model.addAttribute("recettes",recettes);
            return "addrecette";
        }catch (Exception e){
            return "redirect:/recette";
        }
    }

    @GetMapping("/recette/delete/{id}")
    public String deleterecette(@PathVariable Long id)
    {
        Recettes recettes = recetteRepository.findById(id).get();
        recetteRepository.delete(recettes);
        return "redirect:/recette";
    }
}
