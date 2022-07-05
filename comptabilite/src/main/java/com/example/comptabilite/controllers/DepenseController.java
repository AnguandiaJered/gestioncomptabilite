package com.example.comptabilite.controllers;

import com.example.comptabilite.models.Agents;
import com.example.comptabilite.models.Depenses;
import com.example.comptabilite.models.Produits;
import com.example.comptabilite.repository.AgentRepository;
import com.example.comptabilite.repository.DepenseRepository;
import com.example.comptabilite.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DepenseController {
    @Autowired DepenseRepository depenseRepository;
    @Autowired AgentRepository agentRepository;

    @GetMapping("/depense")
    public String getAll(Model model){
        Iterable<Depenses> listdepense =  depenseRepository.findAll();
        model.addAttribute("listdepense",listdepense);
        return "depense";
    }
    @GetMapping("/depense/new")
    public String showDepense(Model model){
        Iterable<Agents> listagent =  agentRepository.findAll();
        model.addAttribute("listagent",listagent);
        model.addAttribute("depenses",new Depenses());
        return "addepense";
    }
    @PostMapping("/depense/create")
    public String create(Depenses depenses)
    {
        depenseRepository.save(depenses);
        return "redirect:/depense";
    }
    @GetMapping("/depense/edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        try {
            Depenses depenses = depenseRepository.findById(id).get();
            model.addAttribute("depenses",depenses);
            return "addepense";
        }catch (Exception e){
            return "redirect:/depense";
        }
    }

    @GetMapping("/depense/delete/{id}")
    public String deletedepense(@PathVariable Long id)
    {
        Depenses depenses = depenseRepository.findById(id).get();
        depenseRepository.delete(depenses);
        return "redirect:/depense";
    }
}
