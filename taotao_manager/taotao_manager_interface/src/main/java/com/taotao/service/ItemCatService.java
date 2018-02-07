package com.taotao.service;

import com.taotao.common.pojo.TreeNode;

import java.util.List;

public interface ItemCatService {
    //根据页面传递的参数parentId 获取类目(封装到TreeNode)
    public List<TreeNode> getItemCatList(Long parentId);
}
