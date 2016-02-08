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
 * Created by william on 06/02/16.
 */
public class ContaControllerITest extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    ContaController contaController;

    @Before
    public void setUp(){
        mockMvc= standaloneSetup(contaController).build();
    }

    @Test
    public void contaCadastro_cadastroTest() throws Exception {
        this.mockMvc.perform(get("/conta").param("isCadastroConta","true").param("isEditarConta","false").param("isDeleteConta","false").param("isExibirConta","false")).andExpect(status().isOk())
                .andExpect(view().name("Conta")).andExpect(model().attribute("isCadastroConta","true")).andExpect(model().attribute("isEditarConta","false")).andExpect(model().attribute("isDeleteConta","false")).andExpect(model().attribute("isExibirConta","false"));
    }

    @Test
    public void contaCadastro_editarTest() throws Exception {
        this.mockMvc.perform(get("/conta").param("isCadastroConta","false").param("isEditarConta","true").param("isDeleteConta","false").param("isExibirConta","false")).andExpect(status().isOk())
                .andExpect(view().name("Conta")).andExpect(model().attribute("isCadastroConta","false")).andExpect(model().attribute("isEditarConta","true")).andExpect(model().attribute("isDeleteConta","false")).andExpect(model().attribute("isExibirConta","false"));
    }

    @Test
    public void contaCadastro_deleteTest() throws Exception {
        this.mockMvc.perform(get("/conta").param("isCadastroConta","false").param("isEditarConta","false").param("isDeleteConta","true").param("isExibirConta","false")).andExpect(status().isOk())
                .andExpect(view().name("Conta")).andExpect(model().attribute("isCadastroConta","false")).andExpect(model().attribute("isEditarConta","false")).andExpect(model().attribute("isDeleteConta","true")).andExpect(model().attribute("isExibirConta","false"));
    }

    @Test
    public void contaCadastro_exibirTest() throws Exception {
        this.mockMvc.perform(get("/conta").param("isCadastroConta","false").param("isEditarConta","false").param("isDeleteConta","false").param("isExibirConta","true")).andExpect(status().isOk())
                .andExpect(view().name("Conta")).andExpect(model().attribute("isCadastroConta","false")).andExpect(model().attribute("isEditarConta","false")).andExpect(model().attribute("isDeleteConta","false")).andExpect(model().attribute("isExibirConta","true"));
    }

    @Test
    public void cadastrarContaTest() throws Exception {
        this.mockMvc.perform(get("/cadastrarConta").param("username","Legolas").param("password","1234").param("role","ROLE_ADMIN")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/conta?isCadastroConta=true&isEditarConta=false&isDeleteConta=false&isExibirConta=false"));
    }

    @Test
    public void exibirContaTest() throws Exception {
        this.mockMvc.perform(get("/exibirConta")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/conta?isCadastroConta=false&isEditarConta=false&isDeleteConta=false&isExibirConta=true"));
    }

    @Test
    public void editarContaTest() throws Exception {
        this.mockMvc.perform(get("/editarConta").param("username","user")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/conta?isCadastroConta=false&isEditarConta=true&isDeleteConta=false&isExibirConta=false"));
    }

    @Test
    public void deletarContaTest() throws Exception {
        this.mockMvc.perform(get("/deletarConta").param("username","admin")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/conta?isCadastroConta=false&isEditarConta=false&isDeleteConta=true&isExibirConta=false"));
    }
}
