package com.poseidon.controller;


import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;


@Test()
public class HomeControllerTest {


    private HomeController homeController;

    @BeforeTest
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
