package cn.edu.njnu.dao;

import java.util.List;

import cn.edu.njnu.bean.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    int updateSelective(Category record);

    List<Category> queryAll();
}