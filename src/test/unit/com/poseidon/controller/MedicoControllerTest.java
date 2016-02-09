package com.poseidon.controller;

import com.poseidon.dao.MedicoDao;
import com.poseidon.model.Medico;
import com.poseidon.model.MedicoBuilder;
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
public class MedicoControllerTest {

    private MedicoController medicoController;

    private MedicoDao medicoDao;


    @Before
    public void setUp(){

        medicoController= new MedicoController();
        medicoDao= mock(MedicoDao.class);
        medicoController.medicoRepository=medicoDao;//injecting dependency into controller.
    }

    @Test
    public void shouldChangeMedico(){

        Medico medico = new MedicoBuilder().withName("Saruman").build();

        when(medicoDao.save(medico)).thenReturn(medico);

        ModelAndView response = medicoController.editarMedico(medico, new ModelAndView());
        assertNotNull(response);
        assertNull(response.getViewName());

    }

    @Test
    public void shouldBuildMedicoPageForCadastro() {

        List<Medico> medicos = new MedicoBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(medicoDao.findAll()).thenReturn(medicos);

        String isCadastroMedico = "true";
        String isPesquisaMedico = "false";
        String isDeleteMedico = "false";
        String isEditarMedico = "false";
        String isExibirMedico = "false";

        ModelAndView response = medicoController.criarPaginaMedico(new ModelAndView(),
                isCadastroMedico,
                isPesquisaMedico,
                isDeleteMedico,
                isEditarMedico,
                isExibirMedico);

        assertEquals(isCadastroMedico, response.getModelMap().get("isCadastroMedico"));
        assertEquals(isPesquisaMedico, response.getModelMap().get("isPesquisaMedico"));
        assertEquals(isDeleteMedico, response.getModelMap().get("isDeleteMedico"));
        assertEquals(isEditarMedico, response.getModelMap().get("isEditarMedico"));
        assertEquals(isExibirMedico, response.getModelMap().get("isExibirMedico"));
        assertEquals(medicos,response.getModelMap().get("medicos"));
    }

    @Test
    public void shouldBuildMedicoPageForPesquisa(){

        List<Medico> medicos = new MedicoBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(medicoDao.findAll()).thenReturn(medicos);

        String isCadastroMedico="false";
        String isPesquisaMedico="true";
        String isDeleteMedico="false";
        String isEditarMedico="false";
        String isExibirMedico="false";

        ModelAndView response = medicoController.criarPaginaMedico(new ModelAndView(),
                isCadastroMedico,
                isPesquisaMedico,
                isDeleteMedico,
                isEditarMedico,
                isExibirMedico);

        assertEquals(isCadastroMedico,response.getModelMap().get("isCadastroMedico"));
        assertEquals(isPesquisaMedico,response.getModelMap().get("isPesquisaMedico"));
        assertEquals(isDeleteMedico,response.getModelMap().get("isDeleteMedico"));
        assertEquals(isEditarMedico,response.getModelMap().get("isEditarMedico"));
        assertEquals(isExibirMedico,response.getModelMap().get("isExibirMedico"));
        assertEquals(medicos,response.getModelMap().get("medicos"));
    }


    @Test
    public void shouldBuildMedicoPageForDelete(){

        List<Medico> medicos = new MedicoBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(medicoDao.findAll()).thenReturn(medicos);

        String isCadastroMedico="false";
        String isPesquisaMedico="false";
        String isDeleteMedico="true";
        String isEditarMedico="false";
        String isExibirMedico="false";

        ModelAndView response = medicoController.criarPaginaMedico(new ModelAndView(),
                isCadastroMedico,
                isPesquisaMedico,
                isDeleteMedico,
                isEditarMedico,
                isExibirMedico);

        assertEquals(isCadastroMedico,response.getModelMap().get("isCadastroMedico"));
        assertEquals(isPesquisaMedico,response.getModelMap().get("isPesquisaMedico"));
        assertEquals(isDeleteMedico,response.getModelMap().get("isDeleteMedico"));
        assertEquals(isEditarMedico,response.getModelMap().get("isEditarMedico"));
        assertEquals(isExibirMedico,response.getModelMap().get("isExibirMedico"));
        assertEquals(medicos,response.getModelMap().get("medicos"));
    }


    @Test
    public void shouldBuildMedicoPageForEditar(){

        List<Medico> medicos = new MedicoBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(medicoDao.findAll()).thenReturn(medicos);

        String isCadastroMedico="false";
        String isPesquisaMedico="false";
        String isDeleteMedico="false";
        String isEditarMedico="true";
        String isExibirMedico="false";

        ModelAndView response = medicoController.criarPaginaMedico(new ModelAndView(),
                isCadastroMedico,
                isPesquisaMedico,
                isDeleteMedico,
                isEditarMedico,
                isExibirMedico);

        assertEquals(isCadastroMedico,response.getModelMap().get("isCadastroMedico"));
        assertEquals(isPesquisaMedico,response.getModelMap().get("isPesquisaMedico"));
        assertEquals(isDeleteMedico,response.getModelMap().get("isDeleteMedico"));
        assertEquals(isEditarMedico,response.getModelMap().get("isEditarMedico"));
        assertEquals(isExibirMedico,response.getModelMap().get("isExibirMedico"));
        assertEquals(medicos,response.getModelMap().get("medicos"));
    }

    @Test
    public void shouldBuildMedicoPageForExibir(){

        List<Medico> medicos = new MedicoBuilder().withId(1).withName("Mordor").add().withId(2).withName("Saruman").add().buildAsList();

        when(medicoDao.findAll()).thenReturn(medicos);

        String isCadastroMedico="false";
        String isPesquisaMedico="false";
        String isDeleteMedico="false";
        String isEditarMedico="false";
        String isExibirMedico="true";

        ModelAndView response = medicoController.criarPaginaMedico(new ModelAndView(),
                isCadastroMedico,
                isPesquisaMedico,
                isDeleteMedico,
                isEditarMedico,
                isExibirMedico);

        assertEquals(isCadastroMedico,response.getModelMap().get("isCadastroMedico"));
        assertEquals(isPesquisaMedico,response.getModelMap().get("isPesquisaMedico"));
        assertEquals(isDeleteMedico,response.getModelMap().get("isDeleteMedico"));
        assertEquals(isEditarMedico,response.getModelMap().get("isEditarMedico"));
        assertEquals(isExibirMedico,response.getModelMap().get("isExibirMedico"));
        assertEquals(medicos,response.getModelMap().get("medicos"));
    }


    @Test
    public void shouldDeleteMedico(){

        Medico medico = new MedicoBuilder().withName("Potter").withId(1).build();

        when(medicoDao.findById(medico.getId())).thenReturn(medico);

        ModelAndView response = medicoController.deletarMedico(medico, new ModelAndView());

        assertNotNull(response);

    }

    @Test
    public void shouldCadastrarMedico(){

        Medico medico = new MedicoBuilder().withId(1).withName("Dumbledore").build();

        when(medicoDao.save(medico)).thenReturn(medico);

        ModelAndView response = medicoController.cadastrarMedico(medico, new ModelAndView());

        assertNotNull(response);

    }

}
