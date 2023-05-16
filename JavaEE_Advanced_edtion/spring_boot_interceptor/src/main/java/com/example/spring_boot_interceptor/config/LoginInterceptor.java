package com.example.spring_boot_interceptor.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 方锐
 * @since 2023/5/16 14:34
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 方法返回 boolean类型，如果为true,表示验证成功，可以继续执行后续流程
     * 如果为 false，表示验证失败，后面的流程就不能执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 用户登录业务判断
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userinfo") != null) {
            // 说明用户已经登录
            return true;
        }
        // 走到这里说明用户没有登录，可以跳转到登录页面 或者 返回一个 401/403 表示没有权限
        response.sendRedirect("/login.html");
        //response.setStatus(401);
        return false;
    }
}
