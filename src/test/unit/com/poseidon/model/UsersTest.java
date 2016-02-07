package com.poseidon.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    ContaView contaView;
    Users user;


    @Before
    public void setUp() throws Exception {
    	contaView = new ContaView().comUsername("name").comPassword("123").comRoles("ADMIN");
    }

    @Test
    public void testCreateUser() throws Exception {
        user = Users.createUser(contaView);
        assertEquals(user.getUsername(), "name");
        assertEquals(user.getPassword(), "123");
        assertTrue(user.isEnabled());
    }

}