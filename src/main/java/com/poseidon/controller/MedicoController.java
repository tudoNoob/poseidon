package com.poseidon.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.dao.MedicoDao;
import com.poseidon.entity.Medico;

import jersey.repackaged.com.google.common.collect.Lists;

@Controller
public class MedicoController {
	
	private MedicoDao repository;
	private static Logger logger = Logger.getLogger("MedicoController");
	
	@RequestMapping("/cadastroMedico")
	public ModelAndView cadastroPaciente(ModelAndView modelAndView) {
		modelAndView.setViewName("cadastroMedico");
		modelAndView.getModelMap().addAttribute("medico", new Medico());
		return modelAndView;
	}
	
	@RequestMapping(value = "/salvarMedico", method = RequestMethod.POST)
	public ModelAndView salvarPaciente(@ModelAttribute Medico medico, ModelAndView modelAndView) {
		repository.save(medico);
		logger.info("salvou medico.");
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping("/pesquisarMedico")
	public ModelAndView pesquisarMedico(ModelAndView modelAndView) {
		modelAndView.setViewName("pesquisarMedico");
		Iterable<Medico> medico = repository.findAll();
		ArrayList<Medico> medicoList = Lists.newArrayList(medico);
		logger.info("FindAll:" + medicoList.toString());
		modelAndView.getModelMap().addAttribute("pacientes", medicoList);
		modelAndView.getModelMap().addAttribute("paciente", new Medico());
		return modelAndView;
	}

	@RequestMapping("/procurarMedico")
	public ModelAndView pesquisaPacientes(ModelAndView modelAndView, @RequestParam String nome) {
		Medico medico = repository.findByNome(nome);
		ArrayList<Medico> medicos = Lists.newArrayList();
		medicos.add(medico);
		modelAndView.getModelMap().addAttribute("medicos", medicos);
		modelAndView.getModelMap().addAttribute("medico", medico);
		modelAndView.setViewName("pesquisarMedico");
		return modelAndView;
	}

}
