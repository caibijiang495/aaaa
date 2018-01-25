package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

//如果要在不同系统之间传递对象,必须将对象序列化成二进制,变成流进行传递
public class EasyUI implements Serializable{
    private Long total;//总记录数
    private List rows;//对象的集合
    //生成get set 方法 Alt+Ins
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
