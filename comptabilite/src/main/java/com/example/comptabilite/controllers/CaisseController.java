package com.example.comptabilite.controllers;

import com.example.comptabilite.models.Caisses;
import com.example.comptabilite.repository.CaisseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaisseController {
    @Autowired CaisseRepository caisserepository;

    @GetMapping("/caisse/all")
    public List<Caisses> getAll()
    {
        List<Caisses> list = caisserepository.findAll();
        return list;
    }

    @PostMapping("/caisses/create")
    public String create(@RequestBody Caisses caisses)
    {
        Caisses caiss = new Caisses();
        caiss.setMontant(caisses.getMontant());
        caisserepository.save(caiss);
        return "created successfully";
    }

    @PutMapping("/caisses/update/{id}")
    public String update(@PathVariable Long id,@RequestBody Caisses caisses)
    {
        Caisses cs = caisserepository.findById(id).get();
        cs.setMontant(caisses.getMontant());
        caisserepository.save(cs);
        return "updated successfully";
    }

    @DeleteMapping("/caisses/delete/{id}")
    public String caissedelete(@PathVariable Long id )
    {
        Caisses caissedelete = caisserepository.findById(id).get();
        caisserepository.delete(caissedelete);
        return "deleted successfully";
    }
}
