package com.poseidon.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserViewTest {

    ContaView contaView;
    Users user;

    @Before
    public void setUp() throws Exception {
        user = new Users().comUsername("name").comPassword("123");
    }

    @Test
    public void testBuildContaView() throws Exception {
    	contaView = contaView.buildContaView(user);
        assertEquals(contaView.getUsername(), "name");
        assertEquals(contaView.getPassword(), "123");
    }
}