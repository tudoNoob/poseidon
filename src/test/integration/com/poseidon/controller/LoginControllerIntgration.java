package com.poseidon.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by wahrons on 2/7/16.
 */
public class LoginControllerIntgration extends PoseidonApplicationTests {


    private MockMvc mockMvc;

    @Autowired
    LoginController loginController;

    @Before
    public void setUp(){
        mockMvc= standaloneSetup(loginController).build();
    }


    @Test
    public void loginTest() throws Exception {

        this.mockMvc.perform(get("/loginPage")).andExpect(model().attributeExists("user"));

    }

}
