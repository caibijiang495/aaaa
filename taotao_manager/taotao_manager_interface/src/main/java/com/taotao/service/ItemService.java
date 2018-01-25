package com.taotao.service;

import com.taotao.common.pojo.EasyUI;

public interface ItemService {
    //分页查询 page当前页码 rows每页显示数量
    public EasyUI getIetmList(Integer page,Integer rows);
}
