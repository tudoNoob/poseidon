package com.poseidon.model;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by psilva on 1/12/16.
 */
public class UsersTest {

    UserView userView;
    Users user;


    @Before
    public void setUp() throws Exception {
        userView = new UserView().comUsername("name").comPassword("123").comRoles("ADMIN");
    }

    @Test
    public void testCreateUser() throws Exception {
        user = Users.createUser(userView);
        assertEquals(user.getUsername(), "name");
        assertEquals(user.getPassword(), "123");
        assertTrue(user.isEnabled());


    }

}