package com.poseidon.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by william on 29/01/16.
 */
public class LoginControllerTest {

    private LoginController loginController;

    @Before
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
