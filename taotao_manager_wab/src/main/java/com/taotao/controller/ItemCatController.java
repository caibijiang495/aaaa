package com.taotao.controller;

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;
    //url:/item/cat/list
    //参数:id
    //返回值:json
    //@RequestParam(value = "id",defaultValue = "0") 区分传递的参数id 默认值是0 根节点
    //每次点击节点发送一次请求
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        //1.引入服务
        //2.注入服务
        //3.调用服务
        List<TreeNode> itemCatList = itemCatService.getItemCatList(parentId);
        return itemCatList;
    }
}
