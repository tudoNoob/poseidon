package com.poseidon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class SobreControllerIntegrationTest extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    SobreController sobreController;

    @BeforeMethod
    public void setUp(){
        mockMvc= standaloneSetup(sobreController).build();
    }


    @Test
    public void sobreController() throws Exception {
        this.mockMvc.perform(get("/sobrePage"))
                .andExpect(view().name("sobre"));
    }


}
