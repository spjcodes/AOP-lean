package com.spj.springaop.advice.myAspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import com.spj.jdkaop.myAspect.MyAspeact;
import org.springframework.aop.DynamicIntroductionAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;
import java.lang.reflect.Method;

/**
 * 可以实现的模式接口
 *  MethodBeforeAdvice,
 *  ThrowsAdvice,
 *  AfterReturningAdvice,
 *  DynamicIntroductionAdvice
 */

public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        MyAspeact myAspect = new MyAspeact();
        myAspect.permissionCheck();
        //执行目标方法
        Object obj = methodInvocation.proceed();
        myAspect.log();
        return obj;
//        return null;
    }


   /* @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("后置通知");
    }



    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("前置通知");

    }



    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕通知");
        return null;
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        return false;
    }*/
}
