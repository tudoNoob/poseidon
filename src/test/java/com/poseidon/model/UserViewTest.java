package com.poseidon.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserViewTest {

    UserView userView;
    Users user;

    @Before
    public void setUp() throws Exception {
        user = new Users().comUsername("name").comPassword("123");
    }

    @Test
    public void testBuildUserView() throws Exception {
        userView = userView.buildUserView(user);
        assertEquals(userView.getUsername(), "name");
        assertEquals(userView.getPassword(), "123");
    }
}