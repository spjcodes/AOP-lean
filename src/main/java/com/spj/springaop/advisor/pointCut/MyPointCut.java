package com.spj.springaop.advisor.pointCut;

import com.spj.springaop.advisor.utils.ClassFilter;
import com.spj.springaop.advisor.utils.MethodMatcher;
import org.springframework.aop.Pointcut;

public class MyPointCut implements Pointcut {

    ClassFilter classFilter = new ClassFilter();
    MethodMatcher methodMatcher = new MethodMatcher();

    public void setClassFilter(ClassFilter classFilter) {
        this.classFilter = classFilter;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }

    @Override
    public ClassFilter getClassFilter() {
        return this.classFilter;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this.methodMatcher;
    }
}
