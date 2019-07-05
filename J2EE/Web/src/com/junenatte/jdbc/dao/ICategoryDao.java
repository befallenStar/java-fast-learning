package com.junenatte.jdbc.dao;

import com.junenatte.jdbc.bean.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();
    List<Category> findById(Integer id);
}
