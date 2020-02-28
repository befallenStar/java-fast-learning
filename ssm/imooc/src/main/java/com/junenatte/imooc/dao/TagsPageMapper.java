package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.TagsPage;

public interface TagsPageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagsPage record);

    int insertSelective(TagsPage record);

    TagsPage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagsPage record);

    int updateByPrimaryKey(TagsPage record);
}