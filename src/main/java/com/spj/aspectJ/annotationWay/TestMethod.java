package com.spj.aspectJ.annotationWay;

import com.spj.springaop.advice.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMethod {

    @Test
    public void aspectJTest() {

        ApplicationContext context = new ClassPathXmlApplicationContext("springAop_aspectJAnnoation.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.addUser();
        System.out.println("..........................................................");
        userDao.deleteUser();
        System.out.println("..........................................................");
        userDao.modleZero();

    }
}
