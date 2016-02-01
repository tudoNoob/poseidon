package com.poseidon.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by william on 29/01/16.
 */
public class SobreControllerTest {

    private  SobreController sobreController;

    @Before
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
