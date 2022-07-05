package com.example.comptabilite.controllers;

import com.example.comptabilite.models.*;
import com.example.comptabilite.rapports.RecetteExcel;
import com.example.comptabilite.rapports.RecetteRapport;
import com.example.comptabilite.repository.AgentRepository;
import com.example.comptabilite.repository.ProduitRepository;
import com.example.comptabilite.repository.RecetteRepository;
import com.example.comptabilite.repository.VenteRepository;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class RecetteController {
    @Autowired private RecetteRepository recetteRepository;
    @Autowired VenteRepository venteRepository;
    @Autowired AgentRepository agentRepository;

    @GetMapping("/recette")
    public String getAll(Model model){
        Iterable<Recettes> listrecette =  recetteRepository.findAll();
        model.addAttribute("listrecette",listrecette);
        return "recette";
    }
    @GetMapping("/recette/new")
    public String showDepense(Model model){
        Iterable<Ventes> listvente =  venteRepository.findAll();
        model.addAttribute("listvente",listvente);
        Iterable<Agents> listagent =  agentRepository.findAll();
        model.addAttribute("listagent",listagent);
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

    @GetMapping("/recette/exportexcel/")
    public void PrintExcel( HttpServletResponse response) throws IOException {
        response.setContentType("Application/octet-stream");
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentateTime=dateformat.format(new Date(0));
        String headerkey="Content-Disposition";
        String headerValue= "atachment; fileName=listerecette" + currentateTime +".xlsx";
        response.setHeader(headerkey,headerValue);
        List<Recettes> listRecette = (List<Recettes>) recetteRepository.findAll();
        RecetteExcel recettexcel = new RecetteExcel(listRecette);
        recettexcel.export(response);
    }

    @GetMapping("/recette/exprotpdf/")
    public void printpdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        String currentFormatDate = dateformat.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; fileName= listRecettes" + currentFormatDate + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Recettes> listrecette = (List<Recettes>) recetteRepository.findAll();

        RecetteRapport recettepdfexport = new RecetteRapport(listrecette);
        recettepdfexport.export(response);

    }
}
