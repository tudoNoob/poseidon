package com.poseidon.controller;

import com.poseidon.PoseidonApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by wahrons on 2/6/16.
 */
public class MedicoControlerIntegration extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private MedicoController medicoController;

    @Before
    public void setUp(){
        mockMvc= standaloneSetup(medicoController).build();
    }

    @Test
    public void medicoCadastro_cadastroTest() throws Exception {

        this.mockMvc.perform(get("/medico").param("isCadastroMedico","true").param("isPesquisaMedico","false").param("isDeleteMedico","false").param("isEditarMedico","false").param("isExibirMedico","false")).andExpect(status().isOk())
                .andExpect(view().name("Medico")).andExpect(model().attribute("isCadastroMedico","true")).andExpect(model().attribute("isPesquisaMedico","false")).andExpect(model().attribute("isDeleteMedico","false")).andExpect(model().attribute("isEditarMedico","false")).andExpect(model().attribute("isExibirMedico","false"));
    }

    @Test
    public void medicoCadastro_pesquisaTest() throws Exception {

        this.mockMvc.perform(get("/medico").param("isCadastroMedico","false").param("isPesquisaMedico","true").param("isDeleteMedico","false").param("isEditarMedico","false").param("isExibirMedico","false")).andExpect(status().isOk())
                .andExpect(view().name("Medico")).andExpect(model().attribute("isCadastroMedico","false")).andExpect(model().attribute("isPesquisaMedico","true")).andExpect(model().attribute("isDeleteMedico","false")).andExpect(model().attribute("isEditarMedico","false")).andExpect(model().attribute("isExibirMedico","false"));
    }

    @Test
    public void medicoCadastro_deleteTest() throws Exception {

        this.mockMvc.perform(get("/medico").param("isCadastroMedico","false").param("isPesquisaMedico","false").param("isDeleteMedico","true").param("isEditarMedico","false").param("isExibirMedico","false")).andExpect(status().isOk())
                .andExpect(view().name("Medico")).andExpect(model().attribute("isCadastroMedico","false")).andExpect(model().attribute("isPesquisaMedico","false")).andExpect(model().attribute("isDeleteMedico","true")).andExpect(model().attribute("isEditarMedico","false")).andExpect(model().attribute("isExibirMedico","false"));
    }

    @Test
    public void medicoCadastro_editarTest() throws Exception {

        this.mockMvc.perform(get("/medico").param("isCadastroMedico","false").param("isPesquisaMedico","false").param("isDeleteMedico","false").param("isEditarMedico","true").param("isExibirMedico","false")).andExpect(status().isOk())
                .andExpect(view().name("Medico")).andExpect(model().attribute("isCadastroMedico","false")).andExpect(model().attribute("isPesquisaMedico","false")).andExpect(model().attribute("isDeleteMedico","false")).andExpect(model().attribute("isEditarMedico","true")).andExpect(model().attribute("isExibirMedico","false"));
    }

    @Test
    public void medicoCadastro_exibirTest() throws Exception {

        this.mockMvc.perform(get("/medico").param("isCadastroMedico","false").param("isPesquisaMedico","false").param("isDeleteMedico","false").param("isEditarMedico","false").param("isExibirMedico","true")).andExpect(status().isOk())
                .andExpect(view().name("Medico")).andExpect(model().attribute("isCadastroMedico","false")).andExpect(model().attribute("isPesquisaMedico","false")).andExpect(model().attribute("isDeleteMedico","false")).andExpect(model().attribute("isEditarMedico","false")).andExpect(model().attribute("isExibirMedico","true"));
    }

    @Test
    public void medicoCadastroTest() throws Exception {
            this.mockMvc.perform(get("/cadastrarMedico").param("nome","Legolas")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/medico?isCadastroMedico=true&isPesquisaMedico=false&isDeleteMedico=false&isEditarMedico=false&isExibirMedico=false"));

    }

    @Test
    public void medicoEditarMedicoTest() throws Exception {
        this.mockMvc.perform(get("/editarMedico").param("id","1")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/medico?isCadastroMedico=false&isPesquisaMedico=false&isDeleteMedico=false&isEditarMedico=true&isExibirMedico=false"));
    }

}
