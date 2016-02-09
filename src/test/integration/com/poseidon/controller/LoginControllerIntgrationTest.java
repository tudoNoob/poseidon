package com.poseidon.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by wahrons on 2/7/16.
 */
public class LoginControllerIntgrationTest extends PoseidonApplicationTests {


    private MockMvc mockMvc;

    @Autowired
    LoginController loginController;

    @Before
    public void setUp(){
        mockMvc= standaloneSetup(loginController).build();
    }


    @Test
    public void loginTest() throws Exception {

        this.mockMvc.perform(get("/loginPage"))
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("login"));
    }

    @Test
    public void loginErrorPageTest() throws Exception {

        this.mockMvc.perform(get("/login-Error"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("error", Matchers.is(true)))
                .andExpect(view().name("login"));;
    }

}
