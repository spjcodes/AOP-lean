package com.spj.springaop.advisor.utils;

import com.spj.springaop.advice.dao.UserDao;

public class ClassFilter implements org.springframework.aop.ClassFilter {
    @Override
    public boolean matches(Class<?> clazz) {
        UserDao userDao = new UserDao();
        if (clazz == userDao.getClass()) {
            return true;
        }
        return false;
    }
}
