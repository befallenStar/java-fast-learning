package com.junenatte.dao;

import com.junenatte.bean.UserTable;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserTableMapper {
    List<UserTable> selectAll(Map map);

    UserTable selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTable userTable);

    int insertSelective(UserTable userTable);

    int updateByPrimaryKeySelective(UserTable userTable);

    int updateByPrimaryKeyWithBLOBs(UserTable userTable);

    int updateByPrimaryKey(UserTable userTable);
}