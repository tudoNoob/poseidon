package com.poseidon.controller;


import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;


@Test()
public class LoginControllerTest {

    private LoginController loginController;

    @BeforeTest
    public void setUp(){
        loginController= new LoginController();
    }

    @Test
    public void loginPageTest(){
        ModelAndView modelAndView = loginController.buildLoginPage(new ModelAndView());
        assertNotNull(modelAndView);
        assertNotNull(modelAndView.getModelMap().get("user"));
        assertNull(modelAndView.getViewName());
    }

    @Test
    public void loginPageError(){
        ModelAndView modelAndView = loginController.buildLoginErrorPage(new ModelAndView());
        assertNotNull(modelAndView);
        assertNotNull(modelAndView.getModelMap().get("user"));
        assertNotNull(modelAndView.getModelMap().get("error"));
        assertNull(modelAndView.getViewName());
    }


}
