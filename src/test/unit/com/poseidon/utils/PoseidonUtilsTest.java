package com.poseidon.utils;

import com.poseidon.model.ContaView;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;


public class PoseidonUtilsTest {

    @Test
    public void testConvertDateToString() throws Exception {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

        date = dateformat.parse("10/10/2010");
        assertEquals(PoseidonUtils.convertDateToString(date),"10/10/2010");
    }

    @Test
    public void testConvertToDate1() throws Exception {

    }

    @Test
    public void testConvertToTime() throws Exception {

    }

    @Test
    public void testConvertStringtoJSON() throws Exception {
    	ContaView user= new ContaView().comUsername("user").comPassword("pass").comRoles("ADMIN");
    	
    	assertEquals(PoseidonUtils.convertStringtoJSON(user),"{\"username\":\"user\",\"password\":\"pass\",\"role\":\"ADMIN\"}");
    }
}