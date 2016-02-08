package com.poseidon.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class MedicoTest {

    @Test
    public void shouldCreateAMedic() {
        Medico medico = new Medico(1, "medico");
        assertEquals("1", medico.getId().toString());
        assertEquals("medico",medico.getNome());
    }
}