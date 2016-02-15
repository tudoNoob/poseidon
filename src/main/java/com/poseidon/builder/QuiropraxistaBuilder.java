package com.poseidon.builder;

import com.poseidon.model.Quiropraxista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wahrons on 2/8/16.
 */
public class QuiropraxistaBuilder {

    private Quiropraxista myObject;

    private List<Quiropraxista>  quiropraxistaList;

    public QuiropraxistaBuilder(){
        myObject= new Quiropraxista();
        quiropraxistaList= new ArrayList<>();
    }

    public Quiropraxista build(){
        return myObject;
    }

    public QuiropraxistaBuilder add(){
        quiropraxistaList.add(myObject);
        myObject= new Quiropraxista();
        return this;
    }

    public List<Quiropraxista> buildAsList(){
        return quiropraxistaList;
    }

    public QuiropraxistaBuilder withName(String nome){
        myObject.setNome(nome);
        return this;
    }

    public QuiropraxistaBuilder withId(Integer id){
        myObject.setId(id);
        return this;
    }




}
