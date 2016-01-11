package controller;

import java.util.*;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ValidateArgs;
import com.poseidon.annotation.ViewName;
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
	@ViewName(name = "cadastroPaciente")
	@NotNullArgs
	public ModelAndView cadastroPaciente(ModelAndView modelAndView, @ModelAttribute Paciente paciente) {
		if (paciente == null)
			paciente = new Paciente();
		modelAndView.getModelMap().addAttribute("paciente", paciente);
		ViewMessage message = new ViewMessage();
		modelAndView.getModelMap().addAttribute("cadastroPageModel", message);
		return modelAndView;
	}

	@RequestMapping(value = "/salvarPaciente", method = RequestMethod.POST)
	@ViewName(name = "home")
	@NotNullArgs
	@ValidateArgs
	public ModelAndView salvarPaciente(@ModelAttribute Paciente paciente, ModelAndView modelAndView) {
		if (dadoSessao.getId() != null)
			paciente.setId(dadoSessao.getId());
		repositories.save(paciente);
		logger.info("salvou paciente.");
		return modelAndView;
	}

	@RequestMapping("/pesquisarPaciente")
	@ViewName(name = "pesquisarPaciente")
	public ModelAndView pesquisarPaciente(ModelAndView modelAndView) {
		Iterable<Paciente> pacientes = repositories.findAll();
		ArrayList<Paciente> pacientesList = Lists.newArrayList(pacientes);
		logger.info("FindAll:" + pacientesList.toString());
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		return modelAndView;
	}

	@RequestMapping("/procurarPaciente")
	@ViewName(name = "pesquisarPaciente")
	@NotNullArgs
	public ModelAndView pesquisaPacientes(ModelAndView modelAndView, @ModelAttribute Paciente pacienteRequest) {
		List<Paciente> pacientes = repositories.findByNome(pacienteRequest.getNome());
		modelAndView.getModelMap().addAttribute("pacientes", pacientes);
		modelAndView.getModelMap().addAttribute("pacientesJSON", PoseidonUtils.convertStringtoJSON(pacientes));
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		return modelAndView;
	}

	@RequestMapping("/deletePaciente")
	@ViewName(name = "deletePaciente")
	public ModelAndView deletePaciente(ModelAndView modelAndView) {
		modelAndView.getModelMap().addAttribute("deletePageModel", new ViewMessage());
		return modelAndView;
	}

	@RequestMapping("/deletarPaciente")
	@ViewName(name = "deletePaciente")
	@NotNullArgs
	public ModelAndView deletarPaciente(ModelAndView modelAndView, @ModelAttribute Paciente paciente) {
		repositories.delete(paciente);
		ViewMessage deletePageModel = new ViewMessage();
		deletePageModel.setSuccess("Paciente deletado com sucesso!");
		modelAndView.getModelMap().addAttribute("deletePageModel", deletePageModel);
		return modelAndView;
	}

	@RequestMapping("/editarPaciente")
	@ViewName(name = "redirect:/cadastroPaciente")
	@NotNullArgs
	public ModelAndView editarPaciente(ModelAndView modelAndView, RedirectAttributes redirectAttributes,
			@ModelAttribute Paciente paciente) {
		Paciente newPaciente = repositories.findOne(paciente.getId());
		dadoSessao.setId(newPaciente.getId());
		redirectAttributes.addFlashAttribute(newPaciente);
		return modelAndView;
	}

}
