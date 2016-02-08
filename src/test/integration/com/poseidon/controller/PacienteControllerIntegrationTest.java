package com.poseidon.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by wahrons on 2/8/16.
 */
public class PacienteControllerIntegrationTest extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private PacienteController pacienteController;

    @Before
    public void setUp(){
        mockMvc= standaloneSetup(pacienteController).build();
    }

    @Test
    public void paciente_cadastro() throws Exception {
        this.mockMvc.perform(get("/paciente")
                .param("isCadastroPaciente","true")
                .param("isDeletePaciente","false")
                .param("isPesquisaPaciente","false"))
                .andExpect(view().name("Paciente"))
                .andExpect(model().attribute("isCadastroPaciente","true"))
                .andExpect(model().attribute("isDeletePaciente","false"))
                .andExpect(model().attribute("isPesquisaPaciente","false"))
                .andExpect(model().attributeExists("cadastroPageModel"))
                .andExpect(model().attributeExists("paciente"));
    }


    @Test
    public void paciente_delete() throws Exception {
        this.mockMvc.perform(get("/paciente")
                .param("isCadastroPaciente","false")
                .param("isDeletePaciente","true")
                .param("isPesquisaPaciente","false"))
                .andExpect(view().name("Paciente"))
                .andExpect(model().attribute("isCadastroPaciente","false"))
                .andExpect(model().attribute("isDeletePaciente","true"))
                .andExpect(model().attribute("isPesquisaPaciente","false"))
                .andExpect(model().attributeExists("cadastroPageModel"))
                .andExpect(model().attributeExists("paciente"));
    }

    @Test
    public void paciente_pesquisa() throws Exception {
        this.mockMvc.perform(get("/paciente")
                .param("isCadastroPaciente","false")
                .param("isDeletePaciente","false")
                .param("isPesquisaPaciente","true"))
                .andExpect(view().name("Paciente"))
                .andExpect(model().attribute("isCadastroPaciente","false"))
                .andExpect(model().attribute("isDeletePaciente","false"))
                .andExpect(model().attribute("isPesquisaPaciente","true"))
                .andExpect(model().attributeExists("cadastroPageModel"))
                .andExpect(model().attributeExists("paciente"));
    }

}
