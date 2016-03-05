package com.poseidon.controller;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.PacienteDao;
import com.poseidon.enums.CRUDViewEnum;
import com.poseidon.model.CRUDView;
import com.poseidon.model.Paciente;
import com.poseidon.model.ViewMessage;
import com.poseidon.utils.PoseidonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class PacienteController extends ControllerBase{
	@Autowired
	private PacienteDao pacienteRepository;

	static ConcurrentHashMap<String,Integer> session=new ConcurrentHashMap<>();
	public static final String REDIRECT_USER_PACIENTE = "redirect:/user/paciente";
	public static final String PACIENTE_VIEW_NAME = "Paciente";

	@Autowired
	private HttpSession httpSession;

	private static Logger logger = Logger.getLogger("PacienteController");

	@RequestMapping("/paciente")
	@ViewName(name = PACIENTE_VIEW_NAME)
	public ModelAndView buildPacientePage(ModelAndView modelAndView, @ModelAttribute CRUDView crudView) {
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		modelAndView.getModelMap().addAttribute(CRUDVIEW_CLASS_NAME, crudView);
		return modelAndView;

	}

	@RequestMapping(value = "/cadastrarPaciente")
	@ViewName(name = REDIRECT_USER_PACIENTE)
	@NotNullArgs
	public ModelAndView createUser(@ModelAttribute Paciente paciente, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
		if (session.get(httpSession.getId())!=null){
			paciente.setId(session.get(httpSession.getId()));
		}
        pacienteRepository.save(paciente);
		this.buildRedirectFlashAttributes(redirectAttributes, CRUDViewEnum.IS_SAVE);
        return modelAndView;
	}

	@RequestMapping("/pesquisarPaciente")
	@ViewName(name = REDIRECT_USER_PACIENTE)
	public ModelAndView pesquisarPaciente(ModelAndView modelAndView) {
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		return modelAndView;
	}

	@RequestMapping("/procurarPaciente")
	@ViewName(name = REDIRECT_USER_PACIENTE)
	@NotNullArgs
	public ModelAndView pesquisaPacientes(ModelAndView modelAndView, @ModelAttribute Paciente pacienteRequest, RedirectAttributes redirectAttributes) {
		List<Paciente> pacientes = pacienteRepository.findByNome(pacienteRequest.getNome());
		modelAndView.getModelMap().addAttribute("pacientes", pacientes);
		modelAndView.getModelMap().addAttribute("pacientesJSON", PoseidonUtils.convertStringtoJSON(pacientes));
		modelAndView.getModelMap().addAttribute("paciente", new Paciente());
		this.buildRedirectFlashAttributes(redirectAttributes, CRUDViewEnum.IS_SEARCH);
		return modelAndView;
	}

	@RequestMapping("/deletarPaciente")
	@ViewName(name = REDIRECT_USER_PACIENTE)
	@NotNullArgs
	public ModelAndView deletarPaciente(ModelAndView modelAndView, @ModelAttribute Paciente paciente) {
		pacienteRepository.delete(paciente);
		ViewMessage deletePageModel = new ViewMessage();
		deletePageModel.setSuccess("Paciente deletado com sucesso!");
		modelAndView.getModelMap().addAttribute("deletePageModel", deletePageModel);
		return modelAndView;
	}

	@RequestMapping("/editarPaciente")
	@ViewName(name = REDIRECT_USER_PACIENTE)
	@NotNullArgs
	public ModelAndView editarPaciente(@ModelAttribute Paciente paciente,
									   ModelAndView modelAndView,
									   RedirectAttributes redirectAttributes) {
		Paciente newPaciente = pacienteRepository.findOne(paciente.getId());
		session.put(httpSession.getId(),newPaciente.getId());
		this.buildRedirectFlashAttributes(redirectAttributes, CRUDViewEnum.IS_UPDATE);
		modelAndView.getModelMap().addAttribute("paciente", newPaciente);
//		ViewMessage message = new ViewMessage();                  -> FAZER COM QUE A PARTIR DAQUI REDIRECIONE PARA O CADASTRAR POIS TERÁ A SESSION PREENCHIDA
//		modelAndView.getModelMap().addAttribute("cadastroPageModel", message);
		return modelAndView;
	}

}
