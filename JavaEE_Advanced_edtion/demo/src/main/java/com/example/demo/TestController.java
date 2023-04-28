package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 方锐
 * @since 2023/4/28 15:15
 */
//@RestController
@Controller // 当前类为控制类
@ResponseBody // 返回的是数据，而不是页面
public class TestController {

    @RequestMapping("/hi")  // url 路由注册
    // 为了让浏览器认识这个类，要有一个路由注册
    public String sayHi(String name) {
        // 为空为 null, 默认值处理
        //if(name==null || name.equals("")) {
        if(!StringUtils.hasLength(name)) {
            name = "张三";
        }
        return "你好:" + name;
    }
}
