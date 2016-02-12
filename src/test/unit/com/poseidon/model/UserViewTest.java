package com.poseidon.model;

import com.poseidon.builder.UsersBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserViewTest {

    ContaView contaView;
    Users user;

    @Before
    public void setUp() throws Exception {
        user = new UsersBuilder().withUsername("name").withPassword("123").build();
    }

    @Test
    public void testBuildContaView() throws Exception {
    	contaView = contaView.buildContaView(user);
        assertEquals(contaView.getUsername(), "name");
        assertEquals(contaView.getPassword(), "123");
    }
}