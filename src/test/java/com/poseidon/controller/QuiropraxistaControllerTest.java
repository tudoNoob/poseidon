package com.poseidon.controller;


import com.poseidon.builder.QuiropraxistaBuilder;
import com.poseidon.dao.QuiropraxistaDao;
import com.poseidon.model.CRUDView;
import com.poseidon.model.Quiropraxista;

import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

@Test()
public class QuiropraxistaControllerTest {

    private QuiropraxistaController quiropraxistaController;

    private QuiropraxistaDao quiropraxistaDao;


    @BeforeTest
    public void setUp() {
        quiropraxistaController = new QuiropraxistaController();
        quiropraxistaDao = mock(QuiropraxistaDao.class);
        quiropraxistaController.quiropraxistaRepository = quiropraxistaDao;//injecting dependency into controller.
    }

    @Test
    public void shouldChangeQuiropraxista() {

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


        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(), new CRUDView());

        assertNotNull(response.getModelMap().get("crudview"));
    }

    @Test
    public void shouldBuildQuiropraxistaPageForPesquisa() {

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(), new CRUDView());

        assertNotNull(response.getModelMap().get("crudview"));
    }


    @Test
    public void shouldBuildQuiropraxistaPageForDelete() {

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(), new CRUDView());

        assertNotNull(response.getModelMap().get("crudview"));
    }


    @Test
    public void shouldBuildQuiropraxistaPageForEditar() {

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(), new CRUDView());

        assertNotNull(response.getModelMap().get("crudview"));
    }

    @Test
    public void shouldBuildQuiropraxistaPageForExibir() {

        List<Quiropraxista> quiropraxistas = new QuiropraxistaBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(quiropraxistaDao.findAll()).thenReturn(quiropraxistas);

        ModelAndView response = quiropraxistaController.criarPaginaQuiropraxista(new ModelAndView(), new CRUDView());

        assertNotNull(response.getModelMap().get("crudview"));

    }


    @Test
    public void shouldDeleteQuiropraxista() {

        Quiropraxista quiropraxista = new QuiropraxistaBuilder().withName("Potter").withId(1).build();

        when(quiropraxistaDao.findById(quiropraxista.getId())).thenReturn(quiropraxista);

        ModelAndView response = quiropraxistaController.deletarQuiropraxista(quiropraxista, new ModelAndView());

        assertNotNull(response);

    }

    @Test
    public void shouldCadastrarQuiropraxista() {

        Quiropraxista quiropraxista = new QuiropraxistaBuilder().withId(1).withName("Dumbledore").build();

        when(quiropraxistaDao.save(quiropraxista)).thenReturn(quiropraxista);

        ModelAndView response = quiropraxistaController.cadastrarQuiropraxista(quiropraxista, new ModelAndView());

        assertNotNull(response);

    }

}
