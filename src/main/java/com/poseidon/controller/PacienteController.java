package com.poseidon.controller;

import java.util.*;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.dao.*;
import com.poseidon.model.*;
import com.poseidon.utils.PoseidonUtils;

import jersey.repackaged.com.google.common.collect.Lists;

@Controller
public class PacienteController {
	@Autowired
	private PacienteDao repositories;
	@Autowired
	private DadoSessao dadoSessao;

	private static Logger logger = Logger.getLogger("PacienteController");

	@RequestMapping("/cadastroPaciente")
	@NotNullArgs
	public ModelAndView cadastroPaciente(ModelAndView modelAndView, @ModelAttribute Paciente paciente) {
		modelAndView.setViewName("cadastroPaciente");
		if (paciente == null)
			paciente = new Paciente();
		modelAndView.getModelMap().addAttribute("paciente", paciente);
		ViewMessage message = new ViewMessage();
		modelAndView.getModelMap().addAttribute("cadastroPageModel", message);
		return modelAndView;
	}

	@RequestMapping(value = "/salvarPaciente", method = RequestMethod.POST)
	@NotNullArgs
	public ModelAndView salvarPaciente(@ModelAttribute Paciente paciente, ModelAndView modelAndView) {
		if(dadoSessao.getId()!= null)paciente.setId(dadoSessao.getId());
		repositories.save(paciente);
		logger.info("salvou paciente.");
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping("/pesquisarPaciente")
	public ModelAndView pesquisarPaciente(ModelAndView modelAndView) {
		modelAndView.setViewName("pesquisarPaciente");
		Iterable<Paciente> pacientes = repositories.findAll();
		ArrayList<Paciente> pacientesList = Lists.newArrayList(pacientes);
		logger.info("FindAll:" + pacientesList.toString());
		//modelAndView.getModelMap().addAttribute("pacientes", pacientesList);
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		return modelAndView;
	}

	@RequestMapping("/procurarPaciente")
	@NotNullArgs
	public ModelAndView pesquisaPacientes(ModelAndView modelAndView, @ModelAttribute Paciente pacienteRequest) {
		List<Paciente> pacientes = repositories.findByNome(pacienteRequest.getNome());
		modelAndView.getModelMap().addAttribute("pacientes", pacientes);
		modelAndView.getModelMap().addAttribute("pacientesJSON", PoseidonUtils.convertStringtoJSON(pacientes));
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		modelAndView.setViewName("pesquisarPaciente");
		return modelAndView;
	}

	@RequestMapping("/deletePaciente")
	public ModelAndView deletePaciente(ModelAndView modelAndView) {
		modelAndView.setViewName("deletePaciente");
		modelAndView.getModelMap().addAttribute("deletePageModel", new ViewMessage());
		return modelAndView;
	}

	@RequestMapping("/deletarPaciente")
	@NotNullArgs
	public ModelAndView deletarPaciente(ModelAndView modelAndView, @ModelAttribute Paciente paciente) {
		repositories.delete(paciente);
		ViewMessage deletePageModel = new ViewMessage();
		deletePageModel.setSuccess("Paciente deletado com sucesso!");
		modelAndView.getModelMap().addAttribute("deletePageModel", deletePageModel);
		modelAndView.setViewName("deletePaciente");
		return modelAndView;
	}

	@RequestMapping("/editarPaciente")
	@NotNullArgs
	public ModelAndView editarPaciente(ModelAndView modelAndView, RedirectAttributes redirectAttributes,
			@ModelAttribute Paciente paciente) {
		Paciente newPaciente = repositories.findOne(paciente.getId());
		dadoSessao.setId(newPaciente.getId());
		modelAndView.setViewName("redirect:/cadastroPaciente");
		redirectAttributes.addFlashAttribute(newPaciente);
		return modelAndView;
	}

}
