package com.junenatte.mybatis.mapper;

import com.junenatte.mybatis.bean.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> findAll();
    List<Category> findById(Integer id);
    int deleteById(Integer id);
    int insert(Category category);
    int update(Category category);
}
