package com.poseidon.controller;

import java.util.List;
import java.util.logging.Logger;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
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

	private Logger logger = Logger.getLogger("ContaController");

    @RequestMapping("/conta")
    @ViewName(name = "Conta")
    public ModelAndView buildContaPage(ModelAndView modelAndView,@RequestParam("isCadastroConta") String isCadastroConta,@RequestParam("isEditarConta") String isEditarConta,@RequestParam("isDeleteConta") String isDeleteConta,@RequestParam("isExibirConta") String isExibirConta){
        modelAndView.getModelMap().addAttribute("isCadastroConta", isCadastroConta);
        modelAndView.getModelMap().addAttribute("isEditarConta", isEditarConta);
        modelAndView.getModelMap().addAttribute("isDeleteConta", isDeleteConta);
        modelAndView.getModelMap().addAttribute("isExibirConta", isExibirConta);
        exibirConta(modelAndView);
        return  modelAndView;
    }
    
	@RequestMapping(value="/cadastrarConta")
	@ViewName(name = "redirect:/conta?isCadastroConta=true&isEditarConta=false&isDeleteConta=false&isExibirConta=false")
	@NotNullArgs
	public ModelAndView cadastrarConta(@ModelAttribute ContaView contaView,@ModelAttribute String role, ModelAndView modelAndView){
		Users user = Users.createUser(contaView);
		//if(dadoSessao.getIdUsuario()!= null)user.setId(dadoSessao.getIdUsuario());
		System.out.println("CREATE CONTA");
		System.out.println("user>"+user.toString());
		userRepository.save(user);
		//if(dadoSessao.getIdUsuario()== null)
			authoritiesRepository.save(new Authorities(user.getUsername(),new StringBuilder().append("ROLE_").append(contaView.getRole()).toString()));
		//dadoSessao.setIdUsuario(null);
		System.out.println("cadastrou conta.");
		return modelAndView;
	}
	
	@RequestMapping(value="/exibirConta")
	@ViewName(name = "redirect:/conta?isCadastroConta=false&isEditarConta=false&isDeleteConta=false&isExibirConta=true")
	@NotNullArgs
    private void exibirConta(ModelAndView modelAndView) {
        Iterable<Users> contaList = userRepository.findAll();
        List<ContaView> contasView = Lists.newArrayList();
		for(Users user : contaList){
			if(user!= null && user.getUsername() != null && !user.getUsername().isEmpty()) {
				logger.info(user.toString());
				Authorities authority = authoritiesRepository.findByUsername(user.getUsername());
				contasView.add(new ContaViewBuilder().convertUsersThroughContaView(user).withAuthority(authority.getAuthority()).build());
			}
		}
        modelAndView.getModelMap().addAttribute("contas", contasView);
    }
    
	@RequestMapping(value="/deletarConta")
	@ViewName(name = "redirect:/conta?isCadastroConta=false&isEditarConta=false&isDeleteConta=true&isExibirConta=false")
	@NotNullArgs
	public ModelAndView deletarConta(@ModelAttribute ContaView contaView, ModelAndView modelAndView){
		Users user = userRepository.findByUsername(contaView.getUsername());
		Authorities authorities = authoritiesRepository.findByUsername(contaView.getUsername());
		System.out.println("Delete USER");
		System.out.println("user>"+user.toString());
		userRepository.delete(user);
		authoritiesRepository.delete(authorities);
		return modelAndView;
	}
	
	@RequestMapping("/editarConta")
	@ViewName(name = "redirect:/conta?isCadastroConta=true&isEditarConta=true&isDeleteConta=false&isExibirConta=false")
	@NotNullArgs
	public ModelAndView editarConta(ModelAndView modelAndView, @ModelAttribute ContaView contaView, RedirectAttributes redirectAttributes){
		Users user = userRepository.findByUsername(contaView.getUsername());
		if(user == null){
			redirectAttributes.addFlashAttribute("contaView",contaView);
			redirectAttributes.addFlashAttribute("isEditarError", "true");
			modelAndView.setViewName("redirect:/home");
			return modelAndView;
		}
		dadoSessao.setIdUsuario(user.getId());
		Authorities authorities = authoritiesRepository.findByUsername(contaView.getUsername());
		contaView.setPassword(user.getPassword());
		contaView.setUsername(user.getUsername());
		contaView.setRole(authorities.getAuthority().replace("ROLE_", ""));
		redirectAttributes.addFlashAttribute("isEditar", "isEditar");
		redirectAttributes.addFlashAttribute("contaView",contaView);
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
}
