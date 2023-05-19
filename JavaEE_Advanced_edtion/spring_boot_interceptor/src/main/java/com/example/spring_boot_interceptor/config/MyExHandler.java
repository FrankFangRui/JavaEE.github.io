package com.example.spring_boot_interceptor.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author 方锐
 * @since 2023/5/16 20:30
 */
@ControllerAdvice
@ResponseBody
public class MyExHandler {
    /**
     * 拦截所有的空指针异常，进行统一的数据返回到前端当中
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public HashMap<String,Object> nullException(NullPointerException e){
        HashMap<String,Object> result = new HashMap<>();
        result.put("code","-1");
        result.put("msg","空指针异常：" + e.getMessage()); // 错误码的描述信息
        result.put("data", null);
        return result;
    }
    @ExceptionHandler(Exception.class)
    public HashMap<String,Object> exception(Exception e){
        HashMap<String,Object> result = new HashMap<>();
        result.put("code","-1");
        result.put("msg","异常：" + e.getMessage()); // 错误码的描述信息
        result.put("data", null);
        return result;
    }

}
