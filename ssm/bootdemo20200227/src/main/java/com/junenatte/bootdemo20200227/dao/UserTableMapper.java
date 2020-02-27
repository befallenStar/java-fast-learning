package com.junenatte.bootdemo20200227.dao;

import com.junenatte.bootdemo20200227.bean.UserTable;

import java.util.List;
import java.util.Map;

public interface UserTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    UserTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKeyWithBLOBs(UserTable record);

    int updateByPrimaryKey(UserTable record);

    List<UserTable> selectAll(Map map);
}