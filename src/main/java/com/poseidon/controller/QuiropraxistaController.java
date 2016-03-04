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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class QuiropraxistaController extends ControllerBase {

    public static final String REDIRECT_ADMIN_QUIROPRAXISTA = "redirect:/admin/quiropraxista";
    public static final String QUIROPRAXISTA_VIEW_NAME = "Quiropraxista";
    @Autowired
    QuiropraxistaDao quiropraxistaRepository;

    private static Logger logger = Logger.getLogger("QuiropraxistaController");

    @RequestMapping("/quiropraxista")
    @ViewName(name = QUIROPRAXISTA_VIEW_NAME)
    public ModelAndView criarPaginaQuiropraxista(ModelAndView modelAndView, @ModelAttribute CRUDView crudView) {
        modelAndView.getModelMap().addAttribute(CRUDVIEW_CLASS_NAME, crudView);
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
    @ViewName(name = REDIRECT_ADMIN_QUIROPRAXISTA)
    @NotNullArgs
    public ModelAndView deletarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista,
                                             ModelAndView modelAndView,
                                             RedirectAttributes redirectAttributes) {
        Quiropraxista quiropraxistaEncontrado = quiropraxistaRepository.findById(quiropraxista.getId());
        try {
            quiropraxistaRepository.delete(quiropraxistaEncontrado);
        } catch (RuntimeException exception) {
            logger.info("Deletando o quiropraxista.");
        }
        this.buildRedirectFlashAttributes(redirectAttributes,CRUDViewEnum.IS_DELETE);
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrarQuiropraxista")
    @ViewName(name = REDIRECT_ADMIN_QUIROPRAXISTA)
    @NotNullArgs
    public ModelAndView cadastrarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista,
                                               ModelAndView modelAndView,
                                               RedirectAttributes redirectAttributes) {
        quiropraxistaRepository.save(quiropraxista);
        this.buildRedirectFlashAttributes(redirectAttributes,CRUDViewEnum.IS_SAVE);
        return modelAndView;
    }

    @RequestMapping(value = "/editarQuiropraxista")
    @ViewName(name = REDIRECT_ADMIN_QUIROPRAXISTA)
    @NotNullArgs
    public ModelAndView editarQuiropraxista(@ModelAttribute Quiropraxista quiropraxista,
                                            ModelAndView modelAndView,
                                            RedirectAttributes redirectAttributes) {
        quiropraxistaRepository.save(quiropraxista);
        this.buildRedirectFlashAttributes(redirectAttributes,CRUDViewEnum.IS_UPDATE);
        return modelAndView;
    }
}
