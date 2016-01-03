package com.poseidon.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.dao.MedicoDao;
import com.poseidon.model.Authorities;
import com.poseidon.model.DadoSessao;
import com.poseidon.model.Medico;
import com.poseidon.model.UserView;
import com.poseidon.model.Users;

import jersey.repackaged.com.google.common.collect.Lists;

@Controller
public class MedicoController {
	@Autowired
	private MedicoDao repository;
	private static Logger logger = Logger.getLogger("MedicoController");
	private DadoSessao dadoSessao;
	
	@RequestMapping("/cadastroMedico")
	public ModelAndView cadastroPaciente(ModelAndView modelAndView) {
		modelAndView.setViewName("cadastroMedico");
		modelAndView.getModelMap().addAttribute("medico", new Medico());
		return modelAndView;
	}
	
	
	@RequestMapping(value="/createMedico")
	public ModelAndView createUser(@ModelAttribute Medico medic, ModelAndView modelAndView){
		System.out.println("CREATE USER");
		System.out.println("medico>"+medic.toString());
		repository.save(medic);
		logger.info("salvou medico.");
		modelAndView.setViewName("redirect:/dashboard");
		
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
	
	public void achaTodosMedicos(ModelAndView modelAndView) {
		Iterable<Medico> medicoList = repository.findAll();
		List<Medico> medicoView= Lists.newArrayList();
		for(Medico medico : medicoList){
			medicoView.add(medico);
		}
		
		modelAndView.getModelMap().addAttribute("medicos", medicoView);
	}

}
