package com.poseidon.controller;

import com.poseidon.PoseidonApplication;
import com.poseidon.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class ContaControllerIntegrationTest extends PoseidonApplicationTests {

        private MockMvc mockMvc;

        @Autowired
        ContaController contaController;

        @BeforeMethod
        public void setUp(){
            mockMvc= standaloneSetup(
                    contaController).build();
        }

        @Test
        public void contaCadastro_cadastroTest() throws Exception {

            this.mockMvc.perform(get("/admin/conta")
                    .param("isCadastroConta","true")
                    .param("isEditarConta","false")
                    .param("isDeleteConta","false")
                    .param("isExibirConta","false"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("Conta"))
                    .andExpect(model().attributeExists("contas"))
                    .andExpect(model().attribute("isCadastroConta","true"))
                    .andExpect(model().attribute("isEditarConta","false"))
                    .andExpect(model().attribute("isDeleteConta","false"))
                    .andExpect(model().attribute("isExibirConta","false"));
        }

        @Test
        public void contaCadastro_editarTest() throws Exception {
            this.mockMvc.perform(get("/admin/conta")
                    .param("isCadastroConta","false")
                    .param("isEditarConta","true")
                    .param("isDeleteConta","false")
                    .param("isExibirConta","false"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("Conta"))
                    .andExpect(model().attributeExists("contas"))
                    .andExpect(model().attribute("isCadastroConta","false"))
                    .andExpect(model().attribute("isEditarConta","true"))
                    .andExpect(model().attribute("isDeleteConta","false"))
                    .andExpect(model().attribute("isExibirConta","false"));
        }

        @Test
        public void contaCadastro_deleteTest() throws Exception {
            this.mockMvc.perform(get("/admin/conta")
                    .param("isCadastroConta","false")
                    .param("isEditarConta","false")
                    .param("isDeleteConta","true")
                    .param("isExibirConta","false"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("Conta"))
                    .andExpect(model().attributeExists("contas"))
                    .andExpect(model().attribute("isCadastroConta","false"))
                    .andExpect(model().attribute("isEditarConta","false"))
                    .andExpect(model().attribute("isDeleteConta","true"))
                    .andExpect(model().attribute("isExibirConta","false"));
        }

        @Test
        public void contaCadastro_exibirTest() throws Exception {
            this.mockMvc.perform(get("/admin/conta")
                    .param("isCadastroConta","false")
                    .param("isEditarConta","false")
                    .param("isDeleteConta","false")
                    .param("isExibirConta","true"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("Conta"))
                    .andExpect(model().attributeExists("contas"))
                    .andExpect(model().attribute("isCadastroConta","false"))
                    .andExpect(model().attribute("isEditarConta","false"))
                    .andExpect(model().attribute("isDeleteConta","false"))
                    .andExpect(model().attribute("isExibirConta","true"));
        }

        @Test
        public void cadastrarContaTest() throws Exception {
            this.mockMvc.perform(get("/admin/cadastrarConta")
                    .param("username","Legolas")
                    .param("password","1234")
                    .param("role","ROLE_ADMIN"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:/admin/conta?" +
                            "isCadastroConta=true" +
                            "&isEditarConta=false" +
                            "&isDeleteConta=false" +
                            "&isExibirConta=false"));
        }

        @Test
        public void editarContaTest() throws Exception {
            this.mockMvc.perform(get("/admin/editarConta")
                    .param("username","user"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:/admin/conta?" +
                            "isCadastroConta=false" +
                            "&isEditarConta=true" +
                            "&isDeleteConta=false" +
                            "&isExibirConta=false"));
        }

        @Test
        public void deleteContaTest() throws Exception {
            this.mockMvc.perform(get("/admin/deletarConta")
                    .param("username","user"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:/admin/conta?" +
                            "isCadastroConta=false" +
                            "&isEditarConta=false" +
                            "&isDeleteConta=true" +
                            "&isExibirConta=false"));
        }


}


