package com.oilman.spring4.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 描述：日志切面
 * Created by wangcw on 2019/4/8.
 */
@Component
@Aspect
public class LogAspect {
    @Pointcut("@annotation(Action)") //对使用@Action注解的方法进行拦截
    public void annotationPointCut(){}

    @Pointcut("execution(* com.oilman.spring4.aop.DemoMethodService.*(..))")
    public void methodPointCut(){}

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("基于注解规则的拦截：" + action.value());
    }

    @After("methodPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("基于方法规则的拦截：" + methodSignature.getName());
    }
}
