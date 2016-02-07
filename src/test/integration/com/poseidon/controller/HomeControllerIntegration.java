package com.poseidon.controller;

import com.poseidon.PoseidonApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by william on 01/02/16.
 */
public class HomeControllerIntegration extends PoseidonApplicationTests  {

    private MockMvc mockMvc;

    @Autowired
    private HomeControllerIntegration homeController;

    @Before
    public void setUp(){
        mockMvc= standaloneSetup(homeController).build();
    }

    @Test
    public void homeTest() throws Exception {

       this.mockMvc.perform(get("/homePage")).andExpect(status().isOk()).andExpect(view().name("home"));
    }



}
