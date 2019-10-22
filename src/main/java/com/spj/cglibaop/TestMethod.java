package com.spj.cglibaop;

import com.spj.cglibaop.MyProxy.CglibProxy;
import com.spj.cglibaop.dao.UserDao;

public class TestMethod {


    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDaoPoxy = (UserDao) cglibProxy.createProxy(userDao);
        userDaoPoxy.addUser(1,"小军");
    }


}
