package com.poseidon.model;

/**
 * Created by wahrons on 2/5/16.
 */
public class ContaViewBuilder {

    private ContaView myObject;

    public ContaViewBuilder(){
        myObject= new ContaView();
    }

    public ContaView build(){
        return myObject;
    }

    public ContaViewBuilder convertUsersThroughContaView(Users users){
        myObject.setPassword(users.getPassword());
        myObject.setUsername(users.getUsername());
        return this;
    }

    public ContaViewBuilder withAuthority(String authority){
        myObject.setRole(authority);
        return this;
    }





}
