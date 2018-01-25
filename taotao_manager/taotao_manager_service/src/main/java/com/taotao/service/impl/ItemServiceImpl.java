package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUI;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    //分页查询
    //注意:需要在dao的pom.xml添加依赖 和 SqlMapConfig.xml添加配置
    public EasyUI getIetmList(Integer page, Integer rows) {
        //1.设置分页 Pagehelper配置完才有这个方法
        PageHelper.startPage(page,rows);//设置之后第一个查询会被分页
        //2.查询所有
        List<TbItem> list = tbItemMapper.selectByExample(null);
        //3.构建分页查询对象
        PageInfo<TbItem> info = new PageInfo<TbItem>(list);
        long total = info.getTotal();//获取总记录数

        EasyUI e = new EasyUI();
        e.setTotal(total);//也可以为list.size
        e.setRows(info.getList());//也可以为list
        //4.发布服务 在applicationContext-service.xml发布 注意发布是接口的路径
        //  <dubbo:service interface="com.taotao.service.ItemService" ref="itemServiceImpl" />
        return e;
    }
}
