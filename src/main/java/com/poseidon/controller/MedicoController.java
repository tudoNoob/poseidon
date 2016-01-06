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
	
	@RequestMapping("/cadastroMedico")
	@ViewName(name = "cadastroMedico")
	public ModelAndView cadastroPaciente(ModelAndView modelAndView) {
		logger.info("CADASTRA MEDICO.");
		modelAndView.getModelMap().addAttribute("medico", new Medico());
		return modelAndView;
	}
	
	
	@RequestMapping(value="/createMedico")
	@ViewName(name = "redirect:/dashboard")
	@NotNullArgs
	public ModelAndView createUser(@ModelAttribute Medico medic, ModelAndView modelAndView){
		logger.info("CREATE MEDICO");
		logger.info("medico>"+medic.toString());
		medicoRepository.save(medic);
		logger.info("salvou medico.");
		return modelAndView;
	}
	
	@RequestMapping(value = "/salvarMedico", method = RequestMethod.POST)
	@ViewName(name = "home")
	@NotNullArgs
	public ModelAndView salvarPaciente(@ModelAttribute Medico medico, ModelAndView modelAndView) {
		logger.info("SALVA MEDICO.");
		medicoRepository.save(medico);
		logger.info("salvou medico.");
		return modelAndView;
	}
	
	@RequestMapping("/pesquisarMedico")
	public ModelAndView pesquisarMedico(ModelAndView modelAndView) {
		logger.info("PESQUISA MEDICO.");
		modelAndView.setViewName("pesquisarMedico");
		Iterable<Medico> medico = medicoRepository.findAll();
		ArrayList<Medico> medicoList = Lists.newArrayList(medico);
		logger.info("FindAll:" + medicoList.toString());
		modelAndView.getModelMap().addAttribute("pacientes", medicoList);
		modelAndView.getModelMap().addAttribute("paciente", new Medico());
		return modelAndView;
	}

	@RequestMapping("/procurarMedico")
	@NotNullArgs
	public ModelAndView pesquisaPacientes(ModelAndView modelAndView, @RequestParam String nome) {
		logger.info("PROCURANDO MEDICO.");
		Medico medico = medicoRepository.findByNome(nome);
		ArrayList<Medico> medicos = Lists.newArrayList();
		medicos.add(medico);
		modelAndView.getModelMap().addAttribute("medicos", medicos);
		modelAndView.getModelMap().addAttribute("medico", medico);
		modelAndView.setViewName("pesquisarMedico");
		return modelAndView;
	}
	
	

}
