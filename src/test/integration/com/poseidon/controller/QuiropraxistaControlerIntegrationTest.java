package com.poseidon.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class QuiropraxistaControlerIntegrationTest extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private QuiropraxistaController quiropraxistaController;

    @BeforeMethod
    public void setUp(){
        mockMvc = standaloneSetup(quiropraxistaController).build();
    }

    @Test
    public void quiropraxistaCadastro_cadastroTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isCadastroQuiropraxista","true")
                .param("isPesquisaQuiropraxista","false")
                .param("isDeleteQuiropraxista","false")
                .param("isEditarQuiropraxista","false")
                .param("isExibirQuiropraxista","false"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista"))
                .andExpect(model().attribute("isCadastroQuiropraxista","true"))
                .andExpect(model().attribute("isPesquisaQuiropraxista","false"))
                .andExpect(model().attribute("isDeleteQuiropraxista","false"))
                .andExpect(model().attribute("isEditarQuiropraxista","false"))
                .andExpect(model().attribute("isExibirQuiropraxista","false"));
    }

    @Test
    public void quiropraxistaCadastro_pesquisaTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isCadastroQuiropraxista","false")
                .param("isPesquisaQuiropraxista","true")
                .param("isDeleteQuiropraxista","false")
                .param("isEditarQuiropraxista","false")
                .param("isExibirQuiropraxista","false"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista"))
                .andExpect(model().attribute("isCadastroQuiropraxista","false"))
                .andExpect(model().attribute("isPesquisaQuiropraxista","true"))
                .andExpect(model().attribute("isDeleteQuiropraxista","false"))
                .andExpect(model().attribute("isEditarQuiropraxista","false"))
                .andExpect(model().attribute("isExibirQuiropraxista","false"));
    }

    @Test
    public void quiropraxistaCadastro_deleteTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isCadastroQuiropraxista","false")
                .param("isPesquisaQuiropraxista","false")
                .param("isDeleteQuiropraxista","true")
                .param("isEditarQuiropraxista","false")
                .param("isExibirQuiropraxista","false"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista"))
                .andExpect(model().attribute("isCadastroQuiropraxista","false"))
                .andExpect(model().attribute("isPesquisaQuiropraxista","false"))
                .andExpect(model().attribute("isDeleteQuiropraxista","true"))
                .andExpect(model().attribute("isEditarQuiropraxista","false"))
                .andExpect(model().attribute("isExibirQuiropraxista","false"));
    }

    @Test
    public void quiropraxistaCadastro_editarTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isCadastroQuiropraxista","false")
                .param("isPesquisaQuiropraxista","false")
                .param("isDeleteQuiropraxista","false")
                .param("isEditarQuiropraxista","true")
                .param("isExibirQuiropraxista","false"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista"))
                .andExpect(model().attribute("isCadastroQuiropraxista","false"))
                .andExpect(model().attribute("isPesquisaQuiropraxista","false"))
                .andExpect(model().attribute("isDeleteQuiropraxista","false"))
                .andExpect(model().attribute("isEditarQuiropraxista","true"))
                .andExpect(model().attribute("isExibirQuiropraxista","false"));
    }

    @Test
    public void quiropraxistaCadastro_exibirTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isCadastroQuiropraxista","false")
                .param("isPesquisaQuiropraxista","false")
                .param("isDeleteQuiropraxista","false")
                .param("isEditarQuiropraxista","false")
                .param("isExibirQuiropraxista","true"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista"))
                .andExpect(model().attribute("isCadastroQuiropraxista","false"))
                .andExpect(model().attribute("isPesquisaQuiropraxista","false"))
                .andExpect(model().attribute("isDeleteQuiropraxista","false"))
                .andExpect(model().attribute("isEditarQuiropraxista","false"))
                .andExpect(model().attribute("isExibirQuiropraxista","true"));
    }

    @Test
    public void quiropraxistaCadastroTest() throws Exception {
            this.mockMvc.perform(get("/admin/cadastrarQuiropraxista")
                    .param("nome","Legolas"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:/admin/quiropraxista?" +
                            "isCadastroQuiropraxista=true" +
                            "&isPesquisaQuiropraxista=false" +
                            "&isDeleteQuiropraxista=false" +
                            "&isEditarQuiropraxista=false" +
                            "&isExibirQuiropraxista=false"));

    }

    @Test
    public void quiropraxistaEditarQuiropraxistaTest() throws Exception {
        this.mockMvc.perform(get("/admin/editarQuiropraxista")
                .param("id","1")).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/admin/quiropraxista?" +
                        "isCadastroQuiropraxista=false" +
                        "&isPesquisaQuiropraxista=false" +
                        "&isDeleteQuiropraxista=false" +
                        "&isEditarQuiropraxista=true" +
                        "&isExibirQuiropraxista=false"));
    }

}
