package com.poseidon.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class AuthoritiesTest {

    @Test
    public void shouldCreateAnAuthoritiesModelInEmptyConstructor() {
        Authorities authorities = new Authorities();
        authorities.setId(1L);
        authorities.setUsername("authorities");
        authorities.setAuthority("admin");

        assertEquals(1L, authorities.getId().longValue());
        assertEquals("authorities",authorities.getUsername());
        assertEquals("admin",authorities.getAuthority());
    }

    @Test
    public void shouldCreateAnAuthorities() {
        Authorities authorities = new Authorities("authorities","admin");
        authorities.setId(1L);

        assertEquals("authorities",authorities.getUsername());
        assertEquals("admin",authorities.getAuthority());
        assertEquals("Authorities [id=1, username=authorities, authority=admin]",authorities.toString());

    }
}