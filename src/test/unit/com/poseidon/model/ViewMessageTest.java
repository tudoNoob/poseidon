package com.poseidon.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class ViewMessageTest {

    @Test
    public void shouldCreateAMessage() {
        ViewMessage viewMessage = new ViewMessage();

        assertNull(viewMessage.getError());
        assertNull(viewMessage.getSuccess());
        assertEquals("ViewMessage [error=null, success=null]",viewMessage.toString());
    }
}