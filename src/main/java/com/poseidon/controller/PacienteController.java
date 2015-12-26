package com.poseidon.controller;

import com.poseidon.dao.PacienteDao;
import com.poseidon.model.Paciente;

import jersey.repackaged.com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class PacienteController {
    @Autowired
    private PacienteDao repositories;

    private static Logger logger = Logger.getLogger("PacienteController");
    

    @RequestMapping("/cadastroPaciente")
    public ModelAndView cadastroPaciente(ModelAndView modelAndView){
        modelAndView.setViewName("cadastroPaciente");
        modelAndView.getModelMap().addAttribute("paciente",new Paciente());
        return modelAndView;
    }

    @RequestMapping(value = "/salvarPaciente", method = RequestMethod.POST)
    public ModelAndView salvarPaciente(@ModelAttribute Paciente paciente, ModelAndView modelAndView) {
        repositories.save(paciente);
        logger.info("salvou paciente.");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/pesquisarPaciente")
    public ModelAndView pesquisarPaciente(ModelAndView modelAndView){
        modelAndView.setViewName("pesquisarPaciente");
        Iterable<Paciente> pacientes = repositories.findAll();
        ArrayList<Paciente> pacientesList = Lists.newArrayList(pacientes);
        logger.info("FindAll:"+pacientesList.toString());
        modelAndView.getModelMap().addAttribute("pacientes",pacientesList);
        return modelAndView;
    }

    public ModelAndView pesquisaPacientes(ModelAndView modelAndView, @ModelAttribute Paciente paciente){
        List<Paciente> pacientes = (List<Paciente>) repositories.findAll();
        modelAndView.getModelMap().addAttribute("pacientes",pacientes);
        return modelAndView;
    }


}
