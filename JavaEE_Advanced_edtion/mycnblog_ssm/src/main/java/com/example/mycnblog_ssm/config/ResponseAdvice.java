package com.example.mycnblog_ssm.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 方锐
 * @since 2023/5/25 21:05
 * 实现同意数据返回的保底类
 * 说明： 在返回数据之前，检测数据的类型是否为统一的对象，如果不是，封装成统一的对象
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    /**
     * 这是一个开关，如果返回值为 true，才会调用 beforeBodyWrite
     * 创建的时候默认是  return false
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 对数据格式进行校验和封装
     * 如果是 AjaxResult 格式，直接通过，
     * 不是的话，或者是 String 格式，就要进行修改
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }
}
