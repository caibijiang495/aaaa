package com.taotao.controller;

import com.taotao.common.pojo.EasyUI;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    //分页查询
    //页面传递参数 是使用get方式传递 page 当前页码 和rows每页显示数量
    //method = RequestMethod.GET  get方式接收参数需要加这个
    //返回json对象
    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUI getItemList(Integer page,Integer rows){
        //1.引入服务
        //2.注入服务<dubbo:reference interface="com.taotao.service.ItemService" id="itemService" />
        //3.调用服务
        EasyUI easyUI = itemService.getIetmList(page, rows);
        return easyUI;
    }
}
