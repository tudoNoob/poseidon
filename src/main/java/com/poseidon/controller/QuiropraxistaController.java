package com.poseidon.controller;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.QuiropraxistaDao;
import com.poseidon.model.Quiropraxista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class QuiropraxistaController {

    @Autowired
    QuiropraxistaDao quiropraxistaRepository;

    private static Logger logger = Logger.getLogger("QuiropraxistaController");

    @RequestMapping("/quiropraxista")
    @ViewName(name = "Quiropraxista")
    public ModelAndView criarPaginaQuiropraxista(ModelAndView modelAndView,@RequestParam("isCadastroQuiropraxista") String isCadastroQuiropraxista,@RequestParam("isPesquisaQuiropraxista") String isPesquisaQuiropraxista,@RequestParam("isDeleteQuiropraxista") String isDeleteQuiropraxista, @RequestParam("isEditarQuiropraxista") String isEditarQuiropraxista, @RequestParam("isExibirQuiropraxista") String isExibirQuiropraxista){
        modelAndView.getModelMap().addAttribute("isCadastroQuiropraxista", isCadastroQuiropraxista);
        modelAndView.getModelMap().addAttribute("isPesquisaQuiropraxista", isPesquisaQuiropraxista);
        modelAndView.getModelMap().addAttribute("isDeleteQuiropraxista", isDeleteQuiropraxista);
        modelAndView.getModelMap().addAttribute("isEditarQuiropraxista", isEditarQuiropraxista);
        modelAndView.getModelMap().addAttribute("isExibirQuiropraxista", isExibirQuiropraxista);
        achaTodosQuiropraxistas(modelAndView);
        return  modelAndView;

    }
    
    @RequestMapping(value = "/exibirQuiropraxista")
    @ViewName(name = "redirect:/quiropraxista?isCadastroQuiropraxista=false&isPesquisaQuiropraxista=false&isDeleteQuiropraxista=false&isEditarQuiropraxista=false&isExibirQuiropraxista=true")
    @NotNullArgs
    public void achaTodosQuiropraxistas(ModelAndView modelAndView) {
        Iterable<Quiropraxista> listaTodosQuiropraxistas = quiropraxistaRepository.findAll();
        List<Quiropraxista> quiropraxistasView = com.google.common.collect.Lists.newArrayList();
        for(Quiropraxista quiropraxista : listaTodosQuiropraxistas){
        	quiropraxistasView.add(quiropraxista);
        }
        logger.info("Listou os Quiropraxistas.");
        modelAndView.getModelMap().addAttribute("quiropraxistas", quiropraxistasView);
    }

    @RequestMapping(value = "/deletarQuiropraxista")
    @ViewName(name = "redirect:/quiropraxista?isCadastroQuiropraxista=false&isPesquisaQuiropraxista=false&isDeleteQuiropraxista=true&isEditarQuiropraxista=false&isExibirQuiropraxista=false")
    @NotNullArgs
    public ModelAndView deletarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista, ModelAndView modelAndView) {
        logger.info("Deletar Quiropraxista:");
        logger.info("Quiropraxista ->" + quiropraxista.toString());
        Quiropraxista quiropraxistaEncontrado = quiropraxistaRepository.findById(quiropraxista.getId());
        try {
        	quiropraxistaRepository.delete(quiropraxistaEncontrado);
        }catch (RuntimeException exception){
            logger.info("Deletando o quiropraxista.");
        }
        logger.info("Deletou o Quiropraxista.");
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrarQuiropraxista")
    @ViewName(name = "redirect:/quiropraxista?isCadastroQuiropraxista=true&isPesquisaQuiropraxista=false&isDeleteQuiropraxista=false&isEditarQuiropraxista=false&isExibirQuiropraxista=false")
    @NotNullArgs
    public ModelAndView cadastrarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista, ModelAndView modelAndView) {
        logger.info("Criar Quiropraxista:");
        logger.info("Quiropraxista -> " + quiropraxista.toString());
        quiropraxistaRepository.save(quiropraxista);
        logger.info("Cadastrou o Quiropraxista.");
        return modelAndView;
    }
    
    @RequestMapping(value = "/editarQuiropraxista")
    @ViewName(name = "redirect:/quiropraxista?isCadastroQuiropraxista=false&isPesquisaQuiropraxista=false&isDeleteQuiropraxista=false&isEditarQuiropraxista=true&isExibirQuiropraxista=false")
    @NotNullArgs
    public ModelAndView editarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista, ModelAndView modelAndView) {
        logger.info("Editar Quiropraxista:");
        logger.info("Quiropraxista -> " + quiropraxista.toString());
        quiropraxistaRepository.save(quiropraxista);
        logger.info("Editou o Quiropraxista.");
        return modelAndView;
    }
}