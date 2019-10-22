package com.spj.springaop.advisor;

import com.spj.springaop.advice.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMethod {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springAop_advisor.xml");
        UserDao userDao = (UserDao)context.getBean("userDaoProxy");
        userDao.addUser();
        System.out.println(".....................................");
        userDao.deleteUser();
    }
}
