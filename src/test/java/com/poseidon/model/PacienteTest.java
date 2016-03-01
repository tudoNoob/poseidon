package com.poseidon.model;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

@Test
public class PacienteTest {

    @BeforeTest
    public void setUp() throws Exception {

    }

    @Test
    public void shouldCreateAPaciente() {
        Paciente paciente = new Paciente();
        paciente.setId(1);
        paciente.setNome("paciente");
        paciente.setSobrenome("paciente");
        paciente.setEmail("paciente@clinica.com");
        paciente.setCelular("000000");
        paciente.setTelefone("00000");
        paciente.setEndereco("rua vera cruz");
        paciente.setCep("00000-000");
        paciente.setCpf("000.000.000-00");
        paciente.setForma_de_pagamento("dinheiro");

        assertNotNull(paciente.getId());
        assertEquals("paciente",paciente.getNome());
        assertEquals("paciente",paciente.getSobrenome());
        assertEquals("paciente@clinica.com",paciente.getEmail());
        assertEquals("000000",paciente.getCelular());
        assertEquals("00000",paciente.getTelefone());
        assertEquals("rua vera cruz", paciente.getEndereco());
        assertEquals("00000-000",paciente.getCep());
        assertEquals("000.000.000-00", paciente.getCpf());
        assertEquals("dinheiro", paciente.getForma_de_pagamento());


    }
}