package com.spj.aspectJ;

import com.spj.springaop.advice.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMethod {

    @Test
    public void aspectJTest() {

        ApplicationContext context = new ClassPathXmlApplicationContext("springAop_aspectJ.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.addUser();
        System.out.println("...................分割线..............................");
        userDao.deleteUser();
        System.out.println("...................分割线..............................");
        userDao.modleZero();
    }
}
