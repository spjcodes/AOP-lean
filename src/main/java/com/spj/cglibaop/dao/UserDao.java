package com.spj.cglibaop.dao;

public class UserDao {

    public void addUser(int i, String username){
        System.out.println("add user values = id" + i + "username = " + username);
    }

    public void deleteUser(String id){
        System.out.println("delete user where id = " + id);
    }
}
