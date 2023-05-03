package com.example.spring_mvc_demo.controller;

import com.example.spring_mvc_demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 方锐
 * @since 2023/5/3 14:52
 */
@RequestMapping("/test")
// @ResponseBody  // 默认情况下，返回的 vue(一个网页页面），加上@ResponseBody表明返回的是一个数据而非页面
// @Controller // 让框架启动的时候，加载当前类（只有加载成功的类，才能被访问）
// @Service 换成其他注解也可以执行，原理同上，但是语义不通过，因为不符合注解表示的这个类的作用
@RestController // 等于Controller和ResponseBody 两个注解复合
public class TestController {

    // @RequestMapping("/hi") 等同于：@RequestMapping(value = "/hi")
    // @RequestMapping(value = "/hi",method = RequestMethod.POST) 等同于
    // @PostMapping("/hi")
    @GetMapping("/hi")
    public String sayHi(String name,int v) {
        return "Hi," + name + " v," + v;
    }

    @GetMapping("/num")
    public String getNum(Integer num) {
        return "num=" + num;
    }

    // 直接传送一个对象
    // @GetMapping("/show_user")
    @PostMapping("/show_user")
    public String showUser(User user) {
        return user.toString();
    }

    // 接收 JSON 对象（和第三方系统通讯时常见的场景） 可能是不同的语言，普通对象就无法传，
    // JSON 对象规范了传递对象的格式，去除了不同语言之间的差距
    @GetMapping("/show_json_user")
    //@PostMapping("/show_json_user")
    public String showJSONUser(@RequestBody User user) {
        return user.toString();
    }

    @GetMapping("/show_time")
//    public String showTime( String t, String t2) {
    public String showTime(@RequestParam(value = "t",required = false) String startTime, @RequestParam("t2") String endTime) {
        return "开始时间： " + startTime + " | 结束时间： " + endTime;
    }
}
