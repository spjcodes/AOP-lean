package com.spj.jdkaop.test;

import com.spj.jdkaop.myProxy.MyProxy;
import com.spj.jdkaop.service.UserService;
import com.spj.jdkaop.service.serviceImpl.UserServiceImpl;

public class TestMethod {

    public static void main(String[] args) {
        UserServiceImpl userSerImpl = new UserServiceImpl();
        UserService user = (UserService) new MyProxy().createProxy(userSerImpl);
        user.addUser();
        user.deleteUser();
    }


}
