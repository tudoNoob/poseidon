package com.poseidon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class PacienteControllerIntegrationTest extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private PacienteController pacienteController;

    @BeforeMethod
    public void setUp(){
        mockMvc= standaloneSetup(pacienteController).build();
    }

    @Test
    public void paciente_cadastro() throws Exception {
        this.mockMvc.perform(get("/user/paciente")
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
        this.mockMvc.perform(get("/user/paciente")
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
        this.mockMvc.perform(get("/user/paciente")
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

    @Test
    public void pesquisarPaciente() throws Exception {
        this.mockMvc.perform(get("/user/pesquisarPaciente"))
                .andExpect(view().name("redirect:/user/paciente?" +
                        "isCadastroPaciente=false" +
                        "&isDeletePaciente=false" +
                        "&isPesquisaPaciente=true"));
    }

    @Test
    public void cadastrarPaciente() throws Exception {
        this.mockMvc.perform(get("/user/cadastrarPaciente")
                .param("nome","Frodo"))
                .andExpect(view().name("redirect:/user/paciente?" +
                        "isCadastroPaciente=true" +
                        "&isDeletePaciente=false" +
                        "&isPesquisaPaciente=false"));
    }



    @Test
    public void editarPaciente() throws Exception {
        this.mockMvc.perform(get("/user/cadastrarPaciente")
                .param("nome","Sam"))
                .andExpect(view().name("redirect:/user/paciente?" +
                        "isCadastroPaciente=true" +
                        "&isDeletePaciente=false&" +
                        "isPesquisaPaciente=false"));

        this.mockMvc.perform(get("/user/editarPaciente")
                .param("id","76")
                .param("nome","Mordor"))
                .andExpect(view().name("/paciente"));
    }

    @Test
    public void procurarPaciente() throws Exception {
        this.mockMvc.perform(get("/user/cadastrarPaciente")
                .param("nome","Saruman"))
                .andExpect(view().name("redirect:/user/paciente?" +
                        "isCadastroPaciente=true" +
                        "&isDeletePaciente=false" +
                        "&isPesquisaPaciente=false"));


        this.mockMvc.perform(get("/user/procurarPaciente")
                .param("nome","Saruman"))
                .andExpect(view().name("Paciente"));
    }

}
