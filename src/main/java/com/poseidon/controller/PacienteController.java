package com.poseidon.controller;

import com.poseidon.dao.PacienteDao;
import com.poseidon.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class PacienteController {
    @Autowired
    private PacienteDao pacienteDao;

    private static Logger logger = Logger.getLogger("PacienteController");

    @RequestMapping("/home")
    public ModelAndView home(ModelAndView  modelAndView){
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/cadastroPaciente")
    public ModelAndView cadastroPaciente(ModelAndView modelAndView){
        modelAndView.setViewName("cadastroPaciente");
        modelAndView.getModelMap().addAttribute("paciente",new Paciente());
        return modelAndView;
    }

    @RequestMapping(value = "/salvarPaciente", method = RequestMethod.POST)
    public ModelAndView salvarPaciente(@ModelAttribute Paciente paciente, ModelAndView modelAndView) {
        pacienteDao.save(paciente);
        logger.info("salvou paciente.");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/pesquisarPaciente")
    public ModelAndView pesquisarPaciente(@ModelAttribute Paciente pacientes, ModelAndView modelAndView){
        modelAndView.setViewName("pesquisaPaciente");
        return modelAndView;
    }


}
