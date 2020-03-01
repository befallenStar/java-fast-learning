package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.TagsPage;

import java.util.List;

public interface TagsPageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagsPage record);

    int insertSelective(TagsPage record);

    TagsPage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagsPage record);

    int updateByPrimaryKey(TagsPage record);

    List<TagsPage> selectAll();
}