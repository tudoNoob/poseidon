package com.poseidon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class HomeControllerIntegrationTest extends PoseidonApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private HomeController homeController;

    @BeforeMethod
    public void setUp() {
        mockMvc = standaloneSetup(homeController).build();
    }

    @Test
    public void homeTest() throws Exception {

        this.mockMvc.perform(get("/user/homePage"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

}
