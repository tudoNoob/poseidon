package com.poseidon.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class QuiropraxistaTest {

    @Test
    public void shouldCreateAQuiropraxist() {
    	Quiropraxista quiropraxista = new Quiropraxista(1, "quiropraxista");
        assertEquals("1", quiropraxista.getId().toString());
        assertEquals("quiropraxista",quiropraxista.getNome());
    }
}