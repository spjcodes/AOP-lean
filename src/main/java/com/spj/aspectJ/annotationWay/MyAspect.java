package com.spj.aspectJ.annotationWay;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component //其是基于组件使用的故需要开启@Component
public class MyAspect {
    //配置切入点
    @Pointcut(value = "execution(* com.spj.springaop.advice.dao.UserDao.*(..))")
    /**
     *  切入点命名
     *  返回值为空
     *  方法体为空
     */
    public void UserDaoPointCut() {}

    //前置通知
    @Before(value = "UserDaoPointCut()")
    public void myBeforeAdvice(JoinPoint joinpoint) {
        System.out.println("权限检查");
        System.out.print("目标类：" + joinpoint.getTarget());
        System.out.println("被植入增强处理的方法为：" + joinpoint.getSignature().getName());
    }

    //后置通知
    @AfterReturning("UserDaoPointCut()")
    public void myAfterRuturning(JoinPoint joinPoint) {
        System.out.println("被植入增强处理的方法为" + joinPoint.getSignature().getName());
        System.out.println("日志记录");
        System.out.println("关闭资源");
    }

    //环绕通知
    @Around("UserDaoPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始...:开启事务");
        //执行目标方法
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束...:关闭日志");
        return obj;
    }

    //异常通知：在方法最后执行，程序抛出异常时执行
    @AfterThrowing(value = "UserDaoPointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知：" + "ERRO INFO:" + e.getMessage() );
        System.out.println("detail info for Stack Trace:" );
        e.printStackTrace();
        System.out.println("*********************************************");
    }

    //最终通知：在方法最后执行，不管方法是否执行成功
    @After("UserDaoPointCut()")
    public void myFinally() {
        System.out.println("最终通知" + "方法结束后的资源释放");
    }


}
