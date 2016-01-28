package com.poseidon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.*;
import com.poseidon.model.*;

@Controller
public class ContaController {

	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private DadoSessao dadoSessao;
	
    @RequestMapping("/conta")
    @ViewName(name = "Conta")
    public ModelAndView buildContaPage(ModelAndView modelAndView,@RequestParam("isCadastroConta") String isCadastroConta,@RequestParam("isEditarConta") String isEditarConta,@RequestParam("isDeleteConta") String isDeleteConta){
        modelAndView.getModelMap().addAttribute("isCadastroConta", isCadastroConta);
        modelAndView.getModelMap().addAttribute("isCadastroConta", isCadastroConta);
        modelAndView.getModelMap().addAttribute("isDeleteConta", isDeleteConta);
        //achaTodosMedicos(modelAndView);
        return  modelAndView;

    }
    
	@RequestMapping(value="/cadastrarConta")
	@NotNullArgs
	public ModelAndView createUser(@ModelAttribute ContaView contaView,@ModelAttribute String role, ModelAndView modelAndView){
		Users user = Users.createUser(contaView);
		if(dadoSessao.getIdUsuario()!= null)user.setId(dadoSessao.getIdUsuario());
		System.out.println("CREATE CONTA");
		System.out.println("user>"+user.toString());
		userRepository.save(user);
		modelAndView.setViewName("redirect:/dashboard");
		if(role!= null && !role.isEmpty()){
			
			contaView.setRole(role);
			modelAndView.setViewName("redirect:/home");
		}
		if(dadoSessao.getIdUsuario()== null)authoritiesRepository.save(new Authorities(user.getUsername(),new StringBuilder().append("ROLE_").append(contaView.getRole()).toString()));
		dadoSessao.setIdUsuario(null);
		return modelAndView;
	}
	
/*	@RequestMapping(value="/createSimpleUser")
	@NotNullArgs
	public ModelAndView createSimpleUser(@ModelAttribute ContaView contaView, ModelAndView modelAndView, RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute(contaView);
		redirectAttributes.addFlashAttribute("USER");
		modelAndView.setViewName("redirect:/createUser");
		return modelAndView;
	}*/
	
	@RequestMapping(value="/deletarConta")
	@NotNullArgs
	public ModelAndView deleteUser(@ModelAttribute ContaView contaView, ModelAndView modelAndView){
		Users user = userRepository.findByUsername(contaView.getUsername());
		Authorities authorities = authoritiesRepository.findByUsername(contaView.getUsername());
		System.out.println("Delete USER");
		System.out.println("user>"+user.toString());
		userRepository.delete(user);
		authoritiesRepository.delete(authorities);
		modelAndView.setViewName("redirect:/dashboard");
		return modelAndView;
	}
	
	@RequestMapping("/editarConta")
	@NotNullArgs
	public ModelAndView editarUsuario(ModelAndView modelAndView, @ModelAttribute ContaView contaView, RedirectAttributes redirectAttributes){
		Users user = userRepository.findByUsername(contaView.getUsername());
		if(user == null){
			redirectAttributes.addFlashAttribute("contaView",contaView);
			redirectAttributes.addFlashAttribute("isEditarError", "true");
			modelAndView.setViewName("redirect:/dashboard");
			return modelAndView;
		}
		dadoSessao.setIdUsuario(user.getId());
		Authorities authorities = authoritiesRepository.findByUsername(contaView.getUsername());
		contaView.setPassword(user.getPassword());
		contaView.setUsername(user.getUsername());
		contaView.setRole(authorities.getAuthority().replace("ROLE_", ""));
		redirectAttributes.addFlashAttribute("isEditar", "isEditar");
		redirectAttributes.addFlashAttribute("contaView",contaView);
		modelAndView.setViewName("redirect:/dashboard");
		return modelAndView;
	}
}
