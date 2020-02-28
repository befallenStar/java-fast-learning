package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.PurchaseHistory;

public interface PurchaseHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseHistory record);

    int insertSelective(PurchaseHistory record);

    PurchaseHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseHistory record);

    int updateByPrimaryKey(PurchaseHistory record);
}