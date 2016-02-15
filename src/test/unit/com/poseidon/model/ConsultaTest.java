package com.poseidon.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;


public class ConsultaTest {

    @Test
    public void shouldCreateAConsultaModel() {
        Consulta consulta = new Consulta();
        consulta.setId(1);
        consulta.setId_quiropraxista(1);
        consulta.setId_paciente(1);
        consulta.setValor(2.00);

        assertEquals("1",consulta.getId().toString());
        assertEquals("1",consulta.getId_quiropraxista().toString());
        assertEquals("1",consulta.getId_paciente().toString());
        assertEquals(2.00,consulta.getValor(),2);
    }
}