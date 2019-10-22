package com.spj.springaop.advice.dao;

public class UserDao {

    public void UserDao() {}

    public void addUser() {
        System.out.println("add user ......");
    }
    public void deleteUser() {
        System.out.println("delete user ......");
    }

    public void userLogout() {
        System.out.println("user logout ......");
    }

    public void modleZero() {
        int a = 1/0;
    }
}
