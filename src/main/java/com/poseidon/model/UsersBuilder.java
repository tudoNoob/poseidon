package com.poseidon.model;

/**
 * Created by wahrons on 2/9/16.
 */
public class UsersBuilder {

    private Users  myObject;

    public UsersBuilder(){
        myObject= new Users();
    }

    public Users build(){
        return myObject;
    }

    public UsersBuilder withPassword(String password){
       myObject.setPassword(password);
        return this;
    }

    public UsersBuilder withUsername(String username){
        myObject.setUsername(username);
        return this;
    }

}
