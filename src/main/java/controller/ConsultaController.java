package controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.dao.*;
import com.poseidon.model.*;


@Controller
public class ConsultaController {

    @Autowired
    private ConsultaDao consultaRepository;

    private static Logger logger = Logger.getLogger("ConsultaController");
    
    @RequestMapping("/cadastrarConsulta")
    @ViewName(name = "cadastrarConsulta")
    public ModelAndView cadastrarConsulta(ModelAndView modelAndView) {
        logger.info("CADASTRA CONSULTA.");
        modelAndView.getModelMap().addAttribute("consulta", new Consulta());
        return modelAndView;
    }
    
    @RequestMapping(value = "/createConsulta")
    @ViewName(name = "home")
    @NotNullArgs
    public ModelAndView createConsulta(ModelAndView modelAndView, @ModelAttribute Consulta consulta) {
        logger.info("CREATE CONSULTA");
        logger.info("consulta>" + consulta.toString());
        consultaRepository.save(consulta);
        logger.info("salvou consulta.");
        return modelAndView;
    }
}
