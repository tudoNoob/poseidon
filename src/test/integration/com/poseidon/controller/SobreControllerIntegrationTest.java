package com.poseidon.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by wahrons on 2/7/16.
 */
public class SobreControllerIntegrationTest extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    SobreController sobreController;

    @Before
    public void setUp(){
        mockMvc= standaloneSetup(sobreController).build();
    }


    @Test
    public void sobreController() throws Exception {
        this.mockMvc.perform(get("/sobrePage"))
                .andExpect(view().name("sobre"));
    }


}
