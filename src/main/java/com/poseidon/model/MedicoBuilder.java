package com.poseidon.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wahrons on 2/8/16.
 */
public class MedicoBuilder {

    private Medico myObject;

    private List<Medico>  medicoList;

    public MedicoBuilder(){
        myObject= new Medico();
        medicoList= new ArrayList<>();
    }

    public Medico build(){
        return myObject;
    }

    public MedicoBuilder add(){
        medicoList.add(myObject);
        myObject= new Medico();
        return this;
    }

    public List<Medico> buildAsList(){
        return medicoList;
    }

    public MedicoBuilder withName(String nome){
        myObject.setNome(nome);
        return this;
    }

    public MedicoBuilder withId(Integer id){
        myObject.setId(id);
        return this;
    }




}
