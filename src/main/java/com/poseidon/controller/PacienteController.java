package com.poseidon.controller;

import com.poseidon.dao.PacienteDao;
import com.poseidon.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PacienteController {
    @Autowired
    private PacienteDao pacienteDao;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/salvarPaciente")
    public String salvarPaciente(@ModelAttribute Paciente paciente) {
        pacienteDao.save(paciente);
        return "home";
    }
}
