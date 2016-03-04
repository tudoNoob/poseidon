package com.poseidon.utils;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RedirectAttributesMock implements RedirectAttributes {


    private HashMap<String,Object> map=new HashMap<>();

    @Override
    public RedirectAttributes addAttribute(String s, Object o) {
        return null;
    }

    @Override
    public RedirectAttributes addAttribute(Object o) {
        return null;
    }

    @Override
    public RedirectAttributes addAllAttributes(Collection<?> collection) {
        return null;
    }

    @Override
    public Model addAllAttributes(Map<String, ?> map) {
        return null;
    }

    @Override
    public RedirectAttributes mergeAttributes(Map<String, ?> map) {
        return null;
    }

    @Override
    public boolean containsAttribute(String s) {
        return false;
    }

    @Override
    public Map<String, Object> asMap() {
        return null;
    }

    @Override
    public RedirectAttributes addFlashAttribute(String s, Object o) {
        map.put(s,o);
        return  this;
    }

    @Override
    public RedirectAttributes addFlashAttribute(Object o) {
        return null;
    }

    @Override
    public Map<String, ?> getFlashAttributes() {
        return map;
    }
}
