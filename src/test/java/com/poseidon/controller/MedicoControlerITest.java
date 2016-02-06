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
public class MedicoControlerITest extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private MedicoController medicoController;

    @Before
    public void setUp(){
        mockMvc= standaloneSetup(medicoController).build();
    }

    @Test
    public void medicoTest() throws Exception {

        this.mockMvc.perform(get("/medico").param("isCadastroMedico","true").param("isPesquisaMedico","false").param("isDeleteMedico","false").param("isEditarMedico","false").param("isExibirMedico","false")).andExpect(status().isOk())
                .andExpect(view().name("Medico")).andExpect(model().attribute("isCadastroMedico","true")).andExpect(model().attribute("isPesquisaMedico","false")).andExpect(model().attribute("isDeleteMedico","false")).andExpect(model().attribute("isEditarMedico","false")).andExpect(model().attribute("isExibirMedico","false"));
    }

}
