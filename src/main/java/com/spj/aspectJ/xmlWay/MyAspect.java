package com.spj.aspectJ.xmlWay;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;

import java.lang.annotation.Annotation;

public class MyAspect  {
    //前置通知
    public void myBeforeAdvice(JoinPoint joinpoint) {
        System.out.println("权限检查");
        System.out.print("目标类：" + joinpoint.getTarget());
        System.out.println("被植入增强处理的方法为：" + joinpoint.getSignature().getName());
    }
    //后置通知
    public void myAfterRuturning(JoinPoint joinPoint) {
        System.out.println("被植入增强处理的方法为" + joinPoint.getSignature().getName());
        System.out.println("日志记录");
        System.out.println("关闭资源");
    }
    //环绕通知
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始...:开启事务");
        //执行目标方法
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束...:关闭日志");
        return obj;
    }
    //异常通知：在方法最后执行，当其仅当方法执行成功时执行
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知：" + "ERRO INFO:" + e.getMessage() );
        System.out.println("detail info for Stack Trace:" );
        e.printStackTrace();
        System.out.println("*********************************************");
    }
    //最终通知：在方法最后执行，不管方法是否执行成功
    public void myFinally() {
        System.out.println("最终通知" + "方法结束后的资源释放");
    }

}
