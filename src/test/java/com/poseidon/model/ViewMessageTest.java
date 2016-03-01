package com.poseidon.model;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

@Test
public class ViewMessageTest {

    @Test
    public void shouldCreateAMessage() {
        ViewMessage viewMessage = new ViewMessage();

        assertNull(viewMessage.getError());
        assertNull(viewMessage.getSuccess());
        assertEquals("ViewMessage [error=null, success=null]",viewMessage.toString());
    }
}