package com.example.comptabilite.controllers;

import com.example.comptabilite.models.Agents;

import com.example.comptabilite.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgentController {

    @Autowired AgentRepository agentRepository;

    @GetMapping("/agent")
    public String getAll(Model model){
        Iterable<Agents> listagent =  agentRepository.findAll();
        model.addAttribute("listagent",listagent);
        return "agent";
    }
    @GetMapping("/agent/new")
    public String showProduit(Model model){
        model.addAttribute("agents",new Agents());
        return "addagent";
    }
    @PostMapping("/agent/create")
    public String create(@ModelAttribute("agents") Agents agents)
    {
        agentRepository.save(agents);
        return "redirect:/agent";
    }

    @GetMapping("/agent/edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        try {
            Agents agents = agentRepository.findById(id).get();
            model.addAttribute("agents",agents);
            return "addagent";
        }catch (Exception e){
            return "redirect:/agent";
        }
    }

    @GetMapping("/agent/delete/{id}")
    public String deleteagent(@PathVariable Long id)
    {
        Agents deleteagent = agentRepository.findById(id).get();
        agentRepository.delete(deleteagent);
        return "redirect:/agent";
    }
}
