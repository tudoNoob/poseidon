package com.poseidon.controller;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.QuiropraxistaDao;
import com.poseidon.enums.CRUDViewEnum;
import com.poseidon.model.CRUDView;
import com.poseidon.model.Quiropraxista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class QuiropraxistaController extends ControllerBase {

    @Autowired
    QuiropraxistaDao quiropraxistaRepository;

    private static Logger logger = Logger.getLogger("QuiropraxistaController");

    @RequestMapping("/quiropraxista")
    @ViewName(name = "Quiropraxista")
    public ModelAndView criarPaginaQuiropraxista(ModelAndView modelAndView, @ModelAttribute CRUDView crudView) {
        modelAndView.getModelMap().addAttribute("crudview", crudView);
        achaTodosQuiropraxistas(modelAndView, null);
        return modelAndView;

    }

    private void achaTodosQuiropraxistas(ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        Iterable<Quiropraxista> listaTodosQuiropraxistas = quiropraxistaRepository.findAll();
        List<Quiropraxista> quiropraxistasView = com.google.common.collect.Lists.newArrayList();
        for (Quiropraxista quiropraxista : listaTodosQuiropraxistas) {
            quiropraxistasView.add(quiropraxista);
        }

        modelAndView.getModelMap().addAttribute("quiropraxistas", quiropraxistasView);
    }

    @RequestMapping(value = "/deletarQuiropraxista")
    @ViewName(name = "redirect:/admin/quiropraxista?" +
            "isCadastroQuiropraxista=false" +
            "&isPesquisaQuiropraxista=false" +
            "&isDeleteQuiropraxista=true" +
            "&isEditarQuiropraxista=false" +
            "&isExibirQuiropraxista=false")
    @NotNullArgs
    public ModelAndView deletarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista, ModelAndView modelAndView) {
        Quiropraxista quiropraxistaEncontrado = quiropraxistaRepository.findById(quiropraxista.getId());
        try {
            quiropraxistaRepository.delete(quiropraxistaEncontrado);
        } catch (RuntimeException exception) {
            logger.info("Deletando o quiropraxista.");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrarQuiropraxista")
    @ViewName(name = "redirect:/admin/quiropraxista?" +
            "isCadastroQuiropraxista=true" +
            "&isPesquisaQuiropraxista=false" +
            "&isDeleteQuiropraxista=false" +
            "&isEditarQuiropraxista=false" +
            "&isExibirQuiropraxista=false")
    @NotNullArgs
    public ModelAndView cadastrarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista, ModelAndView modelAndView) {
        quiropraxistaRepository.save(quiropraxista);
        return modelAndView;
    }

    @RequestMapping(value = "/editarQuiropraxista")
    @ViewName(name = "redirect:/admin/quiropraxista?" +
            "isCadastroQuiropraxista=false" +
            "&isPesquisaQuiropraxista=false" +
            "&isDeleteQuiropraxista=false" +
            "&isEditarQuiropraxista=true" +
            "&isExibirQuiropraxista=false")
    @NotNullArgs
    public ModelAndView editarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista, ModelAndView modelAndView) {
        quiropraxistaRepository.save(quiropraxista);
        return modelAndView;
    }
}
