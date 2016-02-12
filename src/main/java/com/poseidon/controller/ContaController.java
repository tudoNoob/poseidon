package com.poseidon.controller;

import com.google.common.collect.Lists;
import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.builder.ContaViewBuilder;
import com.poseidon.dao.AuthoritiesRepository;
import com.poseidon.dao.UserRepository;
import com.poseidon.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ContaController {

	@Autowired
	AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	UserRepository  userRepository;

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

		System.out.println("CREATE CONTA");
		System.out.println("user>"+user.toString());
		userRepository.save(user);

			authoritiesRepository.save(new Authorities(user.getUsername(),new StringBuilder().append("ROLE_").append(contaView.getRole()).toString()));

		System.out.println("cadastrou conta.");
		return modelAndView;
	}

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
		try {
			userRepository.delete(user);
			authoritiesRepository.delete(authorities);
		}catch (RuntimeException exception){
			logger.info("Deletando com sucesso.");
		}

			return modelAndView;
	}
	
	@RequestMapping("/editarConta")
	@ViewName(name = "redirect:/conta?isCadastroConta=false&isEditarConta=true&isDeleteConta=false&isExibirConta=false")
	@NotNullArgs
	public ModelAndView editarConta(ModelAndView modelAndView, @ModelAttribute ContaView contaView){
		Users user = userRepository.findByUsername(contaView.getUsername());
		if(user == null){
			return modelAndView;
		}
		user.setUsername(contaView.getUsername());
		user.setPassword(contaView.getPassword());
		userRepository.save(user);
		Authorities authority = authoritiesRepository.findByUsername(user.getUsername());
		authority.setUsername(user.getUsername());
		authority.setAuthority(contaView.getRole());
		return modelAndView;
	}
}
