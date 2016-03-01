package com.poseidon.model;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class QuiropraxistaTest {

    @Test
    public void shouldCreateAQuiropraxist() {
    	Quiropraxista quiropraxista = new Quiropraxista(1, "quiropraxista");
        assertEquals("1", quiropraxista.getId().toString());
        assertEquals("quiropraxista",quiropraxista.getNome());
    }
}