package com.poseidon.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by william on 29/01/16.
 */
public class HomeControllerTest {


    private HomeController homeController;

    @Before
    public void setUp(){
        homeController = new HomeController();
    }

    @Test
    public void homeTest(){
        ModelAndView modelAndView = homeController.home(new ModelAndView());
        assertNotNull(modelAndView);
        assertNull(modelAndView.getViewName());
    }

}
