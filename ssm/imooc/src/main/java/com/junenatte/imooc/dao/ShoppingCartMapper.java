package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.ShoppingCart;

import java.util.List;
import java.util.Map;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);

    ShoppingCart selectByUserIdAndProjectId(Map<String,Integer> map);

    List<Map> selectByUserId(Integer userId);

    int deleteByProjectId(Map<String,Integer> map);
}