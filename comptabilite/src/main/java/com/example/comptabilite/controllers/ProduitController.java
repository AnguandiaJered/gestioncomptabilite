package com.example.comptabilite.controllers;

import com.example.comptabilite.models.Produits;
import com.example.comptabilite.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProduitController {

@Autowired ProduitRepository produitRepository;

   @GetMapping("/produit")
   public String getAll(Model model){
      Iterable<Produits> listproduit =  produitRepository.findAll();
      model.addAttribute("listproduit",listproduit);
      return "produit";
   }
   @GetMapping("/produit/new")
   public String showProduit(Model model){
      model.addAttribute("produits",new Produits());
      return "addproduct";
   }
   @PostMapping("/produit/create")
   public String create(@ModelAttribute("produits") Produits produits)
   {
      produitRepository.save(produits);
      return "redirect:/produit";
   }

   @GetMapping("/produit/edit/{id}")
   public String edit(@PathVariable Long id, Model model)
   {
      try {
         Produits produits = produitRepository.findById(id).get();
         model.addAttribute("produits",produits);
         return "addproduct";
      }catch (Exception e){
         return "redirect:/produit";
      }
   }

   @GetMapping("/produit/delete/{id}")
   public String deleteproduit(@PathVariable Long id)
   {
      Produits deleteproduit = produitRepository.findById(id).get();
      produitRepository.delete(deleteproduit);
      return "redirect:/produit";
   }
}
