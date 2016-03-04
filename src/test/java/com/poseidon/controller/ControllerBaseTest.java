package com.poseidon.controller;

import com.poseidon.enums.CRUDViewEnum;
import com.poseidon.utils.RedirectAttributesMock;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

@Test
public class ControllerBaseTest {


    private ControllerBase controllerBase;


    @BeforeMethod
    public void setUp(){
        controllerBase= new ControllerBase();
    }


    @Test
    public void shouldPutAllFalseExceptIsSave() {

        RedirectAttributes attributeRedirected = controllerBase.buildRedirectFlashAttributes(new RedirectAttributesMock(), CRUDViewEnum.IS_SAVE);

        assertNotNull(attributeRedirected);

        Map<String, ?> flashAttributes = attributeRedirected.getFlashAttributes();

        assertEquals("false",flashAttributes.get("isDelete"));
        assertEquals("false",flashAttributes.get("isSearch"));
        assertEquals("false",flashAttributes.get("isUpdate"));
        assertEquals("true",flashAttributes.get("isSave"));

    }

    @Test
    public void shouldPutAllFalseExceptIsDelete(){

        RedirectAttributes attributeRedirected = controllerBase.buildRedirectFlashAttributes(new RedirectAttributesMock(), CRUDViewEnum.IS_DELETE);

        assertNotNull(attributeRedirected);

        Map<String, ?> flashAttributes = attributeRedirected.getFlashAttributes();

        assertEquals("true",flashAttributes.get("isDelete"));
        assertEquals("false",flashAttributes.get("isSearch"));
        assertEquals("false",flashAttributes.get("isUpdate"));
        assertEquals("false",flashAttributes.get("isSave"));

    }


    @Test
    public void shouldPutAllFalseExceptISearch(){

        RedirectAttributes attributeRedirected = controllerBase.buildRedirectFlashAttributes(new RedirectAttributesMock(), CRUDViewEnum.IS_SEARCH);

        assertNotNull(attributeRedirected);

        Map<String, ?> flashAttributes = attributeRedirected.getFlashAttributes();

        assertEquals("false",flashAttributes.get("isDelete"));
        assertEquals("true",flashAttributes.get("isSearch"));
        assertEquals("false",flashAttributes.get("isUpdate"));
        assertEquals("false",flashAttributes.get("isSave"));
    }

    @Test
    public void shouldPutAllFalseExceptIsUpdate(){

        RedirectAttributes attributeRedirected = controllerBase.buildRedirectFlashAttributes(new RedirectAttributesMock(), CRUDViewEnum.IS_UPDATE);

        assertNotNull(attributeRedirected);

        Map<String, ?> flashAttributes = attributeRedirected.getFlashAttributes();

        assertEquals("false",flashAttributes.get("isDelete"));
        assertEquals("false",flashAttributes.get("isSearch"));
        assertEquals("true",flashAttributes.get("isUpdate"));
        assertEquals("false",flashAttributes.get("isSave"));
    }



}
