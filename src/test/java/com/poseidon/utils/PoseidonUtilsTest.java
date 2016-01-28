package com.poseidon.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.poseidon.model.ContaView;


public class PoseidonUtilsTest {

    @Test
    public void testConvertToDate() throws Exception {
        java.util.Date date = new java.util.Date();
        Date sqlDate = new Date(date.getTime());
        date.getTime();
        String dateString = PoseidonUtils.convertDateToString(date);

        assertThat(PoseidonUtils.convertToDate(dateString)).isEqualToIgnoringHours(sqlDate);
    }

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