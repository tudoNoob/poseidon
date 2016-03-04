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
                .param("isSave","true")
                .param("isSearch","false")
                .param("isDelete","false")
                .param("isUpdate","false")
                .param("isToShowAll","false"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista")).andExpect(model().attributeExists("crudview"));
    }

    @Test
    public void quiropraxistaCadastro_pesquisaTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isSave","false")
                .param("isSearch","true")
                .param("isDelete","false")
                .param("isUpdate","false")
                .param("isToShowAll","false"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista")).andExpect(model().attributeExists("crudview"));
    }

    @Test
    public void quiropraxistaCadastro_deleteTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isSave","false")
                .param("isSearch","false")
                .param("isDelete","true")
                .param("isUpdate","false")
                .param("isToShowAll","false"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista")).andExpect(model().attributeExists("crudview"));
    }

    @Test
    public void quiropraxistaCadastro_editarTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isSave","false")
                .param("isSearch","false")
                .param("isDelete","false")
                .param("isUpdate","true")
                .param("isToShowAll","false"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista")).andExpect(model().attributeExists("crudview"));
    }

    @Test
    public void quiropraxistaCadastro_exibirTest() throws Exception {

        this.mockMvc.perform(get("/admin/quiropraxista")
                .param("isSave","false")
                .param("isSearch","false")
                .param("isDelete","false")
                .param("isUpdate","false")
                .param("isToShowAll","true"))
                .andExpect(status().isOk())
                .andExpect(view().name("Quiropraxista")).andExpect(model().attributeExists("crudview"));
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
