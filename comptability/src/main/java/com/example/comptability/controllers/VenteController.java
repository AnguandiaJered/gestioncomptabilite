package com.example.comptability.controllers;

import com.example.comptability.models.Recettes;
import com.example.comptability.models.Ventes;
import com.example.comptability.repository.RecetteRepository;
import com.example.comptability.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class VenteController {

    @Autowired VenteRepository venteRepository;


    @GetMapping("/vente")
    public String getAll(Model model){
        Iterable<Ventes> listvente =  venteRepository.findAll();
        model.addAttribute("listvente",listvente);
        return "vente";
    }
    @GetMapping("/vente/new")
    public String showDepense(Model model){
        model.addAttribute("ventes",new Ventes());
        return "addvente";
    }
    @PostMapping("/vente/create")
    public String create(Ventes ventes)
    {
        venteRepository.save(ventes);
        return "redirect:/vente";
    }

    @GetMapping("/vente/edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        try {
            Ventes ventes = venteRepository.findById(id).get();
            model.addAttribute("ventes",ventes);
            return "addvente";
        }catch (Exception e){
            return "redirect:/vente";
        }
    }

    @GetMapping("/vente/delete/{id}")
    public String deleterecette(@PathVariable Long id)
    {
        Ventes ventes = venteRepository.findById(id).get();
        venteRepository.delete(ventes);
        return "redirect:/vente";
    }
}
