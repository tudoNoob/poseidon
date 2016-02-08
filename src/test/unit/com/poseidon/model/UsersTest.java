package com.poseidon.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        user.setId(1L);
        user.setEnabled(true);
        String toStringReturn = "Users [id=1, username=name, password=123, enabled=true]";

        assertEquals(1L, user.getId().longValue());
        assertEquals(user.getUsername(), "name");
        assertEquals(user.getPassword(), "123");
        assertTrue(user.isEnabled());
        assertEquals(toStringReturn,user.toString());
    }

}