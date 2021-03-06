package com.poseidon.controller;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.PacienteDao;
import com.poseidon.model.Paciente;
import com.poseidon.model.ViewMessage;
import com.poseidon.utils.PoseidonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class PacienteController {
	@Autowired
	private PacienteDao pacienteRepository;

	static ConcurrentHashMap<String,Integer> session=new ConcurrentHashMap<>();

	@Autowired
	private HttpSession httpSession;

	private static Logger logger = Logger.getLogger("PacienteController");

    @RequestMapping("/paciente")
    @ViewName(name = "Paciente")
    public ModelAndView buildPacientePage(ModelAndView modelAndView,
										  @RequestParam("isCadastroPaciente") String isCadastroPaciente,
										  @RequestParam("isDeletePaciente") String isDeletePaciente,
										  @RequestParam("isPesquisaPaciente") String isPesquisaPaciente){
        modelAndView.getModelMap().addAttribute("isCadastroPaciente", isCadastroPaciente);
        modelAndView.getModelMap().addAttribute("isDeletePaciente", isDeletePaciente);
        modelAndView.getModelMap().addAttribute("isPesquisaPaciente", isPesquisaPaciente);
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		ViewMessage message = new ViewMessage();
		modelAndView.getModelMap().addAttribute("cadastroPageModel", message);
        return  modelAndView;
    }


	@RequestMapping(value = "/cadastrarPaciente")
	@ViewName(name = "redirect:/user/paciente?" +
			"isCadastroPaciente=true" +
			"&isDeletePaciente=false" +
			"&isPesquisaPaciente=false")
	@NotNullArgs
	public ModelAndView createUser(@ModelAttribute Paciente paciente, ModelAndView modelAndView) {

		if (session.get(httpSession.getId())!=null){
			paciente.setId(session.get(httpSession.getId()));
		}
        pacienteRepository.save(paciente);
        return modelAndView;
	}

	@RequestMapping("/pesquisarPaciente")
	@ViewName(name = "redirect:/user/paciente?" +
			"isCadastroPaciente=false" +
			"&isDeletePaciente=false" +
			"&isPesquisaPaciente=true")
	public ModelAndView pesquisarPaciente(ModelAndView modelAndView) {
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		return modelAndView;
	}

	@RequestMapping("/procurarPaciente")
	@ViewName(name = "Paciente")
	@NotNullArgs
	public ModelAndView pesquisaPacientes(ModelAndView modelAndView, @ModelAttribute Paciente pacienteRequest) {
		List<Paciente> pacientes = pacienteRepository.findByNomeContainingIgnoreCase(pacienteRequest.getNome());
		modelAndView.getModelMap().addAttribute("pacientes", pacientes);
		modelAndView.getModelMap().addAttribute("pacientesJSON", PoseidonUtils.convertStringtoJSON(pacientes));
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		modelAndView = this.buildPacientePage(modelAndView, "false", "false", "true");
		return modelAndView;
	}

	@RequestMapping("/deletarPaciente")
	@ViewName(name = "deletePaciente")
	@NotNullArgs
	public ModelAndView deletarPaciente(ModelAndView modelAndView, @ModelAttribute Paciente paciente) {
		pacienteRepository.delete(paciente);
		ViewMessage deletePageModel = new ViewMessage();
		deletePageModel.setSuccess("Paciente deletado com sucesso!");
		modelAndView.getModelMap().addAttribute("deletePageModel", deletePageModel);
		return modelAndView;
	}

	@RequestMapping("/editarPaciente")
	@ViewName(name = "/paciente")
	@NotNullArgs
	public ModelAndView editarPaciente(ModelAndView modelAndView,
									   @ModelAttribute Paciente paciente) {
		Paciente newPaciente = pacienteRepository.findOne(paciente.getId());
		session.put(httpSession.getId(),newPaciente.getId());
		buildPacientePage(modelAndView,"true","false","false");
		modelAndView.getModelMap().addAttribute("paciente", newPaciente);
		ViewMessage message = new ViewMessage();
		modelAndView.getModelMap().addAttribute("cadastroPageModel", message);
		return modelAndView;
	}

}
