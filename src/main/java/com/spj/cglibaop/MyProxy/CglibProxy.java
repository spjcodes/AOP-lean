package com.spj.cglibaop.MyProxy;

import com.spj.jdkaop.myAspect.MyAspeact;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {


    public Object createProxy(Object object) {

        //创建一个动态类对象 增强对象
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类，设置其父类
        enhancer.setSuperclass(object.getClass());
        /**
         * 添加回调函数在该方法执行完后回调该方法，
         * 即在代理对象创建成功返回后回调该方法,
         * 在该方法执行时会自动调用拦截的方法 intercept()
         */
        enhancer.setCallback(this);
        //返回创建的代理类
        return enhancer.create();
    }

    /**
     * 拦截方法
     * @param proxy 根据指定父类生成的cglib代理对象
     * @param method 拦截的方法
     * @param args 拦截方法的参数数组
     * @param methodProxy 方法的代理对象，用来执行父类的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //声明切面类
        MyAspeact myAspeact = new MyAspeact();
        //前置增强
        myAspeact.permissionCheck();
        //目标方法执行,执行父类方法
        Object object = methodProxy.invokeSuper(proxy,args);
        //后增强
        myAspeact.log();
        //返回对象
        return object;
    }
}
