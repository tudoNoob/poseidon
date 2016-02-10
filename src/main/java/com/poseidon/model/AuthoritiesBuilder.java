package com.poseidon.model;

/**
 * Created by wahrons on 2/9/16.
 */
public class AuthoritiesBuilder {

    private Authorities  myObject;


    public AuthoritiesBuilder(){
        myObject= new Authorities();
    }

    public Authorities build(){
        return myObject;
    }

    public AuthoritiesBuilder withUsername(String username){
        myObject.setUsername(username);
        return this;
    }

    public AuthoritiesBuilder withAuthority(String authority){
        myObject.setAuthority(authority);
        return this;
    }



}
