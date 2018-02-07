package com.taotao.service.impl;

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    //根据页面传递的参数parentId 获取类目(封装到TreeNode)
    // 根据父节点的Id获取子节点列表
    public List<TreeNode> getItemCatList(Long parentId) {
        //1.注入mapper
        //2.创建examle对象 封装查询条件
        TbItemCatExample examle = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = examle.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //3.执行查询获取到的结果List<TbItemCat>
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(examle);
        //4.转成list<TreeNode>
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (TbItemCat tbItemCat : tbItemCats) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(tbItemCat.getId());
            treeNode.setText(tbItemCat.getName());
            treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
            list.add(treeNode);
        }
        return list;
    }
}
