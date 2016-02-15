package com.poseidon.controller;

import com.poseidon.dao.MedicoDao;
import com.poseidon.model.Medico;
import com.poseidon.builder.MedicoBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by wahrons on 2/8/16.
 */
public class QuiropraxistaControllerTest {

    private QuiropraxistaController quiropraxistaController;

    private QuiropraxistaDao quiropraxistaDao;


    @Before
    public void setUp(){

    	quiropraxistaController= new MedicoController();
    	quiropraxistaDao= mock(QuiropraxistaDao.class);
        quiropraxistaController.quiropraxistaRepository=quiropraxistaDao;//injecting dependency into controller.
    }

    @Test
    public void shouldChangeQuiropraxista(){

    	Quiropraxista quiropraxista = new QuiropraxistaBuilder().withName("Saruman").build();

        when(quiropraxistaDao.save(quiropraxista)).thenReturn(quiropraxista);

        ModelAndView response = quiropraxistaController.editarQuiropraxista(quiropraxista, new ModelAndView());
        assertNotNull(response);
        assertNull(response.getViewName());

    }

    @Test
    public void shouldBuildQuiropraxistaPageForCadastro() {

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        String isCadastroQuiropraxista = "true";
        String isPesquisaQuiropraxista = "false";
        String isDeleteQuiropraxista = "false";
        String isEditarQuiropraxista = "false";
        String isExibirQuiropraxista = "false";

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(),
        		isCadastroQuiropraxista,
        		isPesquisaQuiropraxista,
        		isDeleteQuiropraxista,
        		isEditarQuiropraxista,
        		isExibirQuiropraxista);

        assertEquals(isCadastroQuiropraxista, response.getModelMap().get("isCadastroQuiropraxista"));
        assertEquals(isPesquisaQuiropraxista, response.getModelMap().get("isPesquisaQuiropraxista"));
        assertEquals(isDeleteQuiropraxista, response.getModelMap().get("isDeleteQuiropraxista"));
        assertEquals(isEditarQuiropraxista, response.getModelMap().get("isEditarQuiropraxista"));
        assertEquals(isExibirQuiropraxista, response.getModelMap().get("isExibirQuiropraxista"));
        assertEquals(quiropraxistas,response.getModelMap().get("quiropraxistas"));
    }

    @Test
    public void shouldBuildQuiropraxistaPageForPesquisa(){

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        String isCadastroQuiropraxista = "false";
        String isPesquisaQuiropraxista = "true";
        String isDeleteQuiropraxista = "false";
        String isEditarQuiropraxista = "false";
        String isExibirQuiropraxista = "false";

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(),
        		isCadastroQuiropraxista,
        		isPesquisaQuiropraxista,
        		isDeleteQuiropraxista,
        		isEditarQuiropraxista,
        		isExibirQuiropraxista);

        assertEquals(isCadastroQuiropraxista, response.getModelMap().get("isCadastroQuiropraxista"));
        assertEquals(isPesquisaQuiropraxista, response.getModelMap().get("isPesquisaQuiropraxista"));
        assertEquals(isDeleteQuiropraxista, response.getModelMap().get("isDeleteQuiropraxista"));
        assertEquals(isEditarQuiropraxista, response.getModelMap().get("isEditarQuiropraxista"));
        assertEquals(isExibirQuiropraxista, response.getModelMap().get("isExibirQuiropraxista"));
        assertEquals(quiropraxistas,response.getModelMap().get("quiropraxistas"));
    }


    @Test
    public void shouldBuildQuiropraxistaPageForDelete(){

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        String isCadastroQuiropraxista = "false";
        String isPesquisaQuiropraxista = "false";
        String isDeleteQuiropraxista = "true";
        String isEditarQuiropraxista = "false";
        String isExibirQuiropraxista = "false";

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(),
        		isCadastroQuiropraxista,
        		isPesquisaQuiropraxista,
        		isDeleteQuiropraxista,
        		isEditarQuiropraxista,
        		isExibirQuiropraxista);

        assertEquals(isCadastroQuiropraxista, response.getModelMap().get("isCadastroQuiropraxista"));
        assertEquals(isPesquisaQuiropraxista, response.getModelMap().get("isPesquisaQuiropraxista"));
        assertEquals(isDeleteQuiropraxista, response.getModelMap().get("isDeleteQuiropraxista"));
        assertEquals(isEditarQuiropraxista, response.getModelMap().get("isEditarQuiropraxista"));
        assertEquals(isExibirQuiropraxista, response.getModelMap().get("isExibirQuiropraxista"));
        assertEquals(quiropraxistas,response.getModelMap().get("quiropraxistas"));
    }


    @Test
    public void shouldBuildQuiropraxistaPageForEditar(){

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        String isCadastroQuiropraxista = "false";
        String isPesquisaQuiropraxista = "false";
        String isDeleteQuiropraxista = "false";
        String isEditarQuiropraxista = "true";
        String isExibirQuiropraxista = "false";

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(),
        		isCadastroQuiropraxista,
        		isPesquisaQuiropraxista,
        		isDeleteQuiropraxista,
        		isEditarQuiropraxista,
        		isExibirQuiropraxista);

        assertEquals(isCadastroQuiropraxista, response.getModelMap().get("isCadastroQuiropraxista"));
        assertEquals(isPesquisaQuiropraxista, response.getModelMap().get("isPesquisaQuiropraxista"));
        assertEquals(isDeleteQuiropraxista, response.getModelMap().get("isDeleteQuiropraxista"));
        assertEquals(isEditarQuiropraxista, response.getModelMap().get("isEditarQuiropraxista"));
        assertEquals(isExibirQuiropraxista, response.getModelMap().get("isExibirQuiropraxista"));
        assertEquals(quiropraxistas,response.getModelMap().get("quiropraxistas"));
    }

    @Test
    public void shouldBuildQuiropraxistaPageForExibir(){

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        String isCadastroQuiropraxista = "false";
        String isPesquisaQuiropraxista = "false";
        String isDeleteQuiropraxista = "false";
        String isEditarQuiropraxista = "false";
        String isExibirQuiropraxista = "true";

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(),
        		isCadastroQuiropraxista,
        		isPesquisaQuiropraxista,
        		isDeleteQuiropraxista,
        		isEditarQuiropraxista,
        		isExibirQuiropraxista);

        assertEquals(isCadastroQuiropraxista, response.getModelMap().get("isCadastroQuiropraxista"));
        assertEquals(isPesquisaQuiropraxista, response.getModelMap().get("isPesquisaQuiropraxista"));
        assertEquals(isDeleteQuiropraxista, response.getModelMap().get("isDeleteQuiropraxista"));
        assertEquals(isEditarQuiropraxista, response.getModelMap().get("isEditarQuiropraxista"));
        assertEquals(isExibirQuiropraxista, response.getModelMap().get("isExibirQuiropraxista"));
        assertEquals(quiropraxistas,response.getModelMap().get("quiropraxistas"));
    }


    @Test
    public void shouldDeleteQuiropraxista(){

        Quiropraxista quiropraxista = new QuiropraxistaBuilder().withName("Potter").withId(1).build();

        when(quiropraxistaDao.findById(quiropraxista.getId())).thenReturn(quiropraxista);

        ModelAndView response = quiropraxistaController.deletarQuiropraxista(quiropraxista, new ModelAndView());

        assertNotNull(response);

    }

    @Test
    public void shouldCadastrarQuiropraxista(){

    	Quiropraxista quiropraxista = new QuiropraxistaBuilder().withId(1).withName("Dumbledore").build();

        when(quiropraxistaDao.save(quiropraxista)).thenReturn(quiropraxista);

        ModelAndView response = quiropraxistaController.cadastrarQuiropraxista(quiropraxista, new ModelAndView());

        assertNotNull(response);

    }

}
