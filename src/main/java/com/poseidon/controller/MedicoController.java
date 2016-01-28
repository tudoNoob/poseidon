package com.poseidon.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.MedicoDao;
import com.poseidon.model.Medico;

@Controller
public class MedicoController {

    @Autowired
    private MedicoDao medicoRepository;

    private static Logger logger = Logger.getLogger("MedicoController");

    @RequestMapping("/medico")
    @ViewName(name = "Medico")
    public ModelAndView criarPaginaMedico(ModelAndView modelAndView,@RequestParam("isCadastroMedico") String isCadastroMedico,@RequestParam("isPesquisaMedico") String isPesquisaMedico,@RequestParam("isDeleteMedico") String isDeleteMedico, @RequestParam("isEditarMedico") String isEditarMedico){
        modelAndView.getModelMap().addAttribute("isCadastroMedico", isCadastroMedico);
        modelAndView.getModelMap().addAttribute("isPesquisaMedico", isPesquisaMedico);
        modelAndView.getModelMap().addAttribute("isDeleteMedico", isDeleteMedico);
        modelAndView.getModelMap().addAttribute("isEditarMedico", isEditarMedico);
        achaTodosMedicos(modelAndView);
        return  modelAndView;

    }

    private void achaTodosMedicos(ModelAndView modelAndView) {
        Iterable<Medico> medicoList = medicoRepository.findAll();
        List<Medico> medicoView= com.google.common.collect.Lists.newArrayList();
        for(Medico medico : medicoList){
            medicoView.add(medico);
        }

        modelAndView.getModelMap().addAttribute("medicos", medicoView);
    }

    @RequestMapping(value = "/deletarMedico")
    @ViewName(name = "redirect://medico?isCadastroMedico=false&isPesquisaMedico=false&isDeleteMedico=true&isEditarMedico=false")
    @NotNullArgs
    public ModelAndView deletarMedico(@ModelAttribute Medico medic, ModelAndView modelAndView) {
        logger.info("DELETE MEDICO");
        logger.info("medico>" + medic.toString());
        medicoRepository.delete(medic);
        logger.info("deletou medico.");
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrarMedico")
    @ViewName(name = "redirect:/medico?isCadastroMedico=true&isPesquisaMedico=false&isDeleteMedico=false&isEditarMedico=false")
    @NotNullArgs
    public ModelAndView cadastrarMedico(@ModelAttribute Medico medic, ModelAndView modelAndView) {
        logger.info("CREATE MEDICO");
        logger.info("medico>" + medic.toString());
        medicoRepository.save(medic);
        logger.info("salvou medico.");
        return modelAndView;
    }
    
    @RequestMapping(value = "/editarMedico")
    @ViewName(name = "redirect:/medico?isCadastroMedico=false&isPesquisaMedico=false&isDeleteMedico=false&isEditarMedico=true")
    @NotNullArgs
    public ModelAndView editarMedico(@ModelAttribute Medico medic, ModelAndView modelAndView) {
        logger.info("EDIT MEDICO");
        logger.info("medico>" + medic.toString());
        medicoRepository.save(medic);
        logger.info("editou medico.");
        return modelAndView;
    }
}
