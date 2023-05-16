package com.example.spring_aop_demo1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 方锐
 * @since 2023/5/15 19:35
 */
@Aspect  // 该类为切面
@Component // 添加五大注解，随着框架启动而启动
public class UserAspect {
    /**
     * 切点（配置拦截规则）
     */
    @Pointcut("execution(* com.example.spring_aop_demo1.controller.UserController.*(..))")
    public void pointcut(){

    }

    /**
     * 前置通知
     */
    @Before("pointcut()")
    public void beforeAdvice() {
        System.out.println("执行了前置通知。");
    }

    /**
     * 后置通知
     */
    @After("pointcut()")
    public void AfterAdvice() {
        System.out.println("执行了后置通知。");
    }

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     */
    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("进入环绕通知");
        Object obj = null;
        // 执行目标方法
        obj = joinPoint.proceed();
        System.out.println("退出环绕通知");
        return obj;
    }
}
