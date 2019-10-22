package com.spj.jdkaop.myProxy;

import com.spj.jdkaop.myAspect.MyAspeact;
import com.spj.jdkaop.service.UserService;
import com.spj.jdkaop.service.serviceImpl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pjs
 */
public class MyProxy implements InvocationHandler {
    //1.声明目标类接口
    UserService userService = null;
    //2.创建代理方法
    public Object createProxy(Object object) {
        userService = (UserService) object;
        //匹配是否为目标接口类
        Class<?>[] t = UserServiceImpl.class.getInterfaces();
        Class<?>[] t2 = object.getClass().getInterfaces();
        Boolean ifEquals = false;
        for(int i=0; i<t.length; i++) {
            for(int j=0; j<t2.length; j++)
                if(t[i] == t2[j])
                    ifEquals = true;
        }
        if(!ifEquals)
            return object;

        /**
         *  @param 参数1 目标代理类类加载器
         *  @param 参数2 目标类实现的所有接口
         *  @param 参数3 处理器（这里为类本身 this, 也可以new InvocationHandler())
         * @return 被invoke()方法增强了的代理对象
         */
        // 返回使用代理类进行增强，返回代理后的对象
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),  //classLoader 类加载器
                object.getClass().getInterfaces(), //interfaces 被代理对象实现的所有接口 clazz[]
                this
        );
    }

    /**
     * 在该类调用是回自动调用该方法
     * @param proxy 代理的目标对象
     * @param method 调用的方法
     * @param args  方法差数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //声明切面
        MyAspeact myAspeact = new MyAspeact();
        //前置增强
        myAspeact.permissionCheck();
        //在目标类上调用方法，传入差数, 第一个参数为目标类， 第二为目标method的参数
        Object object1 = method.invoke(userService, args);
        //后置增强
        myAspeact.log();
        //所表示的方法的调度结果
        //这个对象在object上带有参数
        return object1;
    }
}
