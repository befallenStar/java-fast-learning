package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.ImoocUser;

import java.util.Map;

public interface ImoocUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImoocUser record);

    int insertSelective(ImoocUser record);

    ImoocUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImoocUser record);

    int updateByPrimaryKey(ImoocUser record);

    ImoocUser selectByPhone(Map<String,String> map);
}