package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    //首页
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    //列表页面跳转
    //如果url:/item-list 对应访问的页面就是item-list.jsp
    //那么使用一个通用方法,页面传什么就访问什么
    // /{page} 加了斜杆 需要加上@PathVariable注解
    @RequestMapping("/{page}")
    public String showItemListPage(@PathVariable String page){
        return page;
    }
}
