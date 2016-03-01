package com.poseidon.controller;


import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNull;
import static org.testng.AssertJUnit.assertNotNull;


@Test
public class SobreControllerTest {

    private  SobreController sobreController;

    @BeforeTest
    public  void setUp(){
        sobreController = new SobreController();
    }

    @Test
    public void sobreTest(){
        ModelAndView modelAndView = sobreController.sobre(new ModelAndView());
        assertNotNull(modelAndView);
        assertNull(modelAndView.getViewName());
    }

}
