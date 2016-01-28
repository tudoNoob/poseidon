package com.poseidon.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.*;
import com.poseidon.model.*;


@Controller
public class ConsultaController {

    @Autowired
    private ConsultaDao consultaRepository;

    private static Logger logger = Logger.getLogger("ConsultaController");
    
    @RequestMapping("/consulta")
    @ViewName(name = "Consulta")
    public ModelAndView buildConsultaPage(ModelAndView modelAndView,@RequestParam("isCadastroConsulta") String isCadastroConsulta,@RequestParam("isDeleteConsulta") String isDeleteConsulta,@RequestParam("isEditarConsulta") String isEditarConsulta,@RequestParam("isExibirConsulta") String isExibirConsulta){
        modelAndView.getModelMap().addAttribute("isCadastroConsulta", isCadastroConsulta);
        modelAndView.getModelMap().addAttribute("isDeleteConsulta", isDeleteConsulta);
        modelAndView.getModelMap().addAttribute("isEditarConsulta", isEditarConsulta);
        modelAndView.getModelMap().addAttribute("isExibirConsulta", isExibirConsulta);
        //achaTodosMedicos(modelAndView);
        return  modelAndView;
    }
    
    @RequestMapping(value = "/cadastrarConsulta")
    @ViewName(name = "redirect:/consulta?isCadastroConsulta=true&isDeleteConsulta=false&isEditarConsulta=false&isExibirConsulta=false")
    @NotNullArgs
    public ModelAndView cadastrarConsulta(@ModelAttribute Consulta consulta, ModelAndView modelAndView) {
        logger.info("CREATE CONSULTA");
        logger.info("consulta>" + consulta.toString());
        consultaRepository.save(consulta);
        logger.info("salvou consulta.");
        return modelAndView;
    }
    
/*    @RequestMapping(value = "/deletarConsulta")
    @ViewName(name = "redirect:/consulta?isCadastroConsulta=false&isDeleteConsulta=true&isEditarConsulta=false&isExibirConsulta=false")
    @NotNullArgs
    public ModelAndView deletarConsulta(@ModelAttribute Consulta consulta, ModelAndView modelAndView) {

    }
    
    @RequestMapping(value = "/editarConsulta")
    @ViewName(name = "redirect:/consulta?isCadastroConsulta=false&isDeleteConsulta=false&isEditarConsulta=true&isExibirConsulta=false")
    @NotNullArgs
    public ModelAndView editarConsulta(@ModelAttribute Consulta consulta, ModelAndView modelAndView) {

    }
    @RequestMapping(value = "/exibirConsulta")
    @ViewName(name = "redirect:/consulta?isCadastroConsulta=false&isDeleteConsulta=false&isEditarConsulta=false&isExibirConsulta=true")
    @NotNullArgs
    public ModelAndView exibirConsulta(@ModelAttribute Consulta consulta, ModelAndView modelAndView) {

    }*/
}
