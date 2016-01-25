package com.poseidon.controller;

import java.util.*;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.*;
import com.poseidon.model.*;

import jersey.repackaged.com.google.common.collect.Lists;

@Controller
public class MedicoController {

    @Autowired
    private MedicoDao medicoRepository;

    private static Logger logger = Logger.getLogger("MedicoController");

    @RequestMapping("/medico")
    @ViewName(name = "Medico")
    public ModelAndView buildMedicoPAge(ModelAndView modelAndView,@RequestParam("isCadastroMedico") String isCadastroMedico,@RequestParam("isPesquisaMedico") String isPesquisaMedico,@RequestParam("isDeleteMedico") String isDeleteMedico){
        modelAndView.getModelMap().addAttribute("isCadastroMedico", isCadastroMedico);
        modelAndView.getModelMap().addAttribute("isPesquisaMedico", isPesquisaMedico);
        modelAndView.getModelMap().addAttribute("isDeleteMedico", isDeleteMedico);
        achaTodosMedicos(modelAndView);
        return  modelAndView;

    }

    private void achaTodosMedicos(ModelAndView modelAndView) {
        Iterable<Medico> medicoList = medicoRepository.findAll();
        List<Medico> medicoView= com.google.common.collect.Lists.newArrayList();
        for(Medico medico : medicoList){
            medicoView.add(medico);
        }

        modelAndView.getModelMap().addAttribute("medicos", medicoView);
    }

    @RequestMapping(value = "/deleteMedico")
    @ViewName(name = "redirect://medico?isCadastroMedico=false&isPesquisaMedico=false&isDeleteMedico=true")
    @NotNullArgs
    public ModelAndView deleteMedico(@ModelAttribute Medico medic, ModelAndView modelAndView) {
        logger.info("DELETE MEDICO");
        logger.info("medico>" + medic.toString());
        medicoRepository.delete(medic);
        logger.info("deletou medico.");
        return modelAndView;
    }

    @RequestMapping(value = "/createMedico")
    @ViewName(name = "redirect:/medico?isCadastroMedico=true&isPesquisaMedico=false&isDeleteMedico=false")
    @NotNullArgs
    public ModelAndView createUser(@ModelAttribute Medico medic, ModelAndView modelAndView) {
        logger.info("CREATE MEDICO");
        logger.info("medico>" + medic.toString());
        medicoRepository.save(medic);
        logger.info("salvou medico.");
        return modelAndView;
    }


}
