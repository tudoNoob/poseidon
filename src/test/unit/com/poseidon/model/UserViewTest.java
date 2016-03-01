package com.poseidon.model;

import com.poseidon.builder.UsersBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class UserViewTest {

    ContaView contaView;
    Users user;

    @BeforeTest
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