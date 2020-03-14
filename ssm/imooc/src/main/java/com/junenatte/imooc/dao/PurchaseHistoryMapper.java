package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.PurchaseHistory;

import java.util.List;
import java.util.Map;

public interface PurchaseHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseHistory record);

    int insertSelective(PurchaseHistory record);

    PurchaseHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseHistory record);

    int updateByPrimaryKey(PurchaseHistory record);

    List<Map> selectByUserId(Integer userId);

    PurchaseHistory selectByUserIdAndProjectId(Map<String,Integer> map);
}