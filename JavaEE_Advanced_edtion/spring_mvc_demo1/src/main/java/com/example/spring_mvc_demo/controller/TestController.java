package com.example.spring_mvc_demo.controller;

import com.example.spring_mvc_demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author 方锐
 * @since 2023/5/3 14:52
 */
@RequestMapping("/test")
// @ResponseBody  // 默认情况下，返回的 vue(一个网页页面），加上@ResponseBody表明返回的是一个数据而非页面
// @Controller // 让框架启动的时候，加载当前类（只有加载成功的类，才能被访问）
// @Service 换成其他注解也可以执行，原理同上，但是语义不通过，因为不符合注解表示的这个类的作用
@RestController // 等于Controller和ResponseBody 两个注解复合
@Slf4j
public class TestController {

    // @RequestMapping("/hi") 等同于：@RequestMapping(value = "/hi")
    // @RequestMapping(value = "/hi",method = RequestMethod.POST) 等同于
    // @PostMapping("/hi")
    @GetMapping("/hi")
    public String sayHi(String name, int v) {
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
    public String showTime(@RequestParam(value = "t", required = false) String startTime, @RequestParam("t2") String endTime) {
        return "开始时间： " + startTime + " | 结束时间： " + endTime;
    }

    @RequestMapping("/login/{username}/{password}")
    public String login(@PathVariable("username") String username,
                        @PathVariable("password") String password) {
        return username + ":" + password;
    }

    @RequestMapping("/show/{username}/and/{password}")
    public String showInfo(@PathVariable("password") String pwd,
                           @PathVariable("username") String username) {
        return username + ":" + pwd;
    }

    @RequestMapping("/upfile")
    public String upfile(@RequestPart("myfile")MultipartFile file) throws IOException {
        // 确定路径
        // ...\\img.png 路径给定了，只能保存一张图片，每次添加图片都会覆盖之前的图片
        // 那么要怎么解决文件覆盖和上传文件类型不同的问题
        String path = "D:\\GithubResposities\\JavaEE.github.io\\JavaEE_Advanced_edtion\\spring_mvc_demo1\\Generate\\img.png";
        // 保存文件到本地地址
        file.transferTo(new File(path));
        return path;
    }

    @RequestMapping("/myupfile")
    public String myupFile(@RequestPart("myfile") MultipartFile file) throws IOException {
        // 根目录
        String path = "D:\\GithubResposities\\JavaEE.github.io\\JavaEE_Advanced_edtion\\spring_mvc_demo1\\Generate\\";
        // 根目录 + 唯一的文件名
        // path += UUID.randomUUID().toString();
        // 去除目录当中的 -
        path += UUID.randomUUID().toString().replace("-","");
        // 根目录 + 唯一的文件名 + 文件的后缀
        path += file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        return path;
    }


    // HttpServletRequest,HttpServletResponse 这两个参数是在 SpringMVC 中内置的，当启动的时候就会
    // 注入到这些变量当中，不用自己手动注入
    @GetMapping("/getparam")
    public String getParam(HttpServletRequest req) {
        return req.getParameter("username");
    }

    @RequestMapping("/getck")
    public String getCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for(Cookie item : cookies) {
            log.error(item.getName() + ":" + item.getValue());// error 颜色鲜艳
        }
        return "get cookie";
    }

    @RequestMapping("/getck2")
    public String getCookie2(@CookieValue("zhangsan") String val) {
        return "Cookie Value:" + val;
    }

    @RequestMapping("/getua")
    public String getUA(@RequestHeader("User-Agent")String userAgent) {
        return userAgent;
    }

    @RequestMapping("/getua2")
    public String getUA2(HttpServletResponse response, HttpServletRequest request) {
        String name = request.getParameter("name");
        // 获取所有 cookie 信息
        Cookie[] cookies = request.getCookies();
        String userAgent = request.getHeader("User-Agent");
        return name + "："+userAgent;
    }

    @RequestMapping("/setsess")
    public String setSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("userinfo","userinfo‘session");
        return "Set Session Success.";
    }

    @RequestMapping("/getsess")
    public String getSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userinfo") != null){
            return (String) session.getAttribute("userinfo");
        } else {
            return "暂无 session 信息";
        }
    }

    @RequestMapping("/getsess2")
    public String getSession2(@SessionAttribute(value = "userinfo's session",required = false) String userinfo){
        return userinfo;
    }

    @RequestMapping("/respjson")
    @ResponseBody
    public HashMap<String, String> respJson() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Java", "Java Value");
        map.put("MySQL", "MySQL Value");
        map.put("Redis", "Redis Value");
        return map;
    }














}
