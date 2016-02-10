package com.poseidon.builder;

import com.poseidon.model.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wahrons on 2/9/16.
 */
public class UsersBuilder {

    private Users myObject;
    private List<Users> usersList;

    public UsersBuilder(){
        myObject= new Users();
        usersList= new ArrayList<>();
    }

    public Users build(){
        return myObject;
    }

    public List<Users> buildAsList(){
        return usersList;
    }

    public UsersBuilder add(){
        usersList.add(myObject);
        myObject= new Users();
        return this;
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
