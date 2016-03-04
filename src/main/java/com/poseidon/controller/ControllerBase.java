package com.poseidon.controller;

import com.poseidon.enums.CRUDViewEnum;
import com.poseidon.model.CRUDView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Field;

public class ControllerBase {

    public static final String CRUDVIEW_CLASS_NAME = "crudview";

    protected RedirectAttributes buildRedirectFlashAttributes(RedirectAttributes redirectAttributes, CRUDViewEnum crudViewEnum) {

        Field[] fields = CRUDView.class.getDeclaredFields();

        for (Field field : fields) {
            String[] fieldName = field.getName().split(" ");
            if (fieldName[fieldName.length - 1].equals(crudViewEnum.getOperation())) {
                redirectAttributes.addFlashAttribute(field.getName(), "true");
            } else {
                redirectAttributes.addFlashAttribute(field.getName(), "false");
            }
        }

        return redirectAttributes;
    }


}
