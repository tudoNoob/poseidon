package com.poseidon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
            .param("isSave","true")
            .param("isSearch","false")
            .param("isDelete","false")
            .param("isUpdate","false")
            .param("isToShowAll","false"))
            .andExpect(status().isOk())
            .andExpect(view().name(PacienteController.PACIENTE_VIEW_NAME))
            .andExpect(model().attributeExists(ControllerBase.CRUDVIEW_CLASS_NAME));
    }


    @Test
    public void paciente_delete() throws Exception {
        this.mockMvc.perform(get("/user/paciente")
                .param("isSave","false")
                .param("isSearch","false")
                .param("isDelete","true"))
                .andExpect(status().isOk())
                .andExpect(view().name(PacienteController.PACIENTE_VIEW_NAME))
                .andExpect(model().attributeExists(ControllerBase.CRUDVIEW_CLASS_NAME));
    }

    @Test
    public void paciente_pesquisa() throws Exception {
        this.mockMvc.perform(get("/user/paciente")
                .param("isSave","false")
                .param("isSearch","false")
                .param("isDelete","true"))
                .andExpect(status().isOk())
                .andExpect(view().name(PacienteController.PACIENTE_VIEW_NAME))
                .andExpect(model().attributeExists(ControllerBase.CRUDVIEW_CLASS_NAME));
    }

    @Test
    public void cadastrarPaciente() throws Exception {
        this.mockMvc.perform(get("/user/cadastrarPaciente")
                .param("nome","Frodo"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(PacienteController.REDIRECT_USER_PACIENTE));
    }

//    @Test
//    public void editarPaciente() throws Exception {
//        this.mockMvc.perform(get("/user/cadastrarPaciente")
//                .param("nome","Sam"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name(PacienteController.REDIRECT_USER_PACIENTE));
//
//        this.mockMvc.perform(get("/user/editarPaciente")
//                .param("id","76")
//                .param("nome","Mordor"))
//                .andExpect(view().name(PacienteController.REDIRECT_USER_PACIENTE));
//    }
//
//    @Test
//    public void procurarPaciente() throws Exception {
//        this.mockMvc.perform(get("/user/cadastrarPaciente")
//                .param("nome","Saruman"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name(PacienteController.REDIRECT_USER_PACIENTE));
//
//
//        this.mockMvc.perform(get("/user/procurarPaciente")
//                .param("nome","Saruman"))
//                .andExpect(view().name(PacienteController.REDIRECT_USER_PACIENTE));
//    }

}
