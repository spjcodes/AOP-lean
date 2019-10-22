package com.spj.springaop.advisor.utils;

import com.spj.springaop.advice.dao.UserDao;

import java.lang.reflect.Method;

public class MethodMatcher implements org.springframework.aop.MethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        Method targerMethod = null;

        try {
            targerMethod = new UserDao().getClass().getMethod("addUser");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
       if(targerMethod.getName() == method.getName())
            return true;
        return false;
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        return false;
    }
}
