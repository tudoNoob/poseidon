package com.poseidon.model;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class DadoSessaoTest {

    @Test
    public void shouldIniciateANewSession() {
        DadoSessao dadoSessao = new DadoSessao();
        dadoSessao.setId(1);
        dadoSessao.setIdUsuario(1L);

        assertEquals("1",dadoSessao.getId().toString());
        assertEquals(1L, dadoSessao.getIdUsuario().longValue());
        assertEquals("DadoSessao [id=1, idUsuario=1]",dadoSessao.toString());
    }
}