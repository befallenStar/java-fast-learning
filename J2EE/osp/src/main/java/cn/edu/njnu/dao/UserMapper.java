package cn.edu.njnu.dao;

import cn.edu.njnu.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    //    int updateByPrimaryKeySelective(User record);
    //    int updateByPrimaryKey(User record);

    User queryUserByUsername(String username);
}