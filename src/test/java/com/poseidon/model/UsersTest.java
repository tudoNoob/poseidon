package com.poseidon.model;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class UsersTest {

    ContaView contaView;
    Users user;


    @BeforeTest
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