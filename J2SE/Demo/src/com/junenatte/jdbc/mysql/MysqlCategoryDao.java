package com.junenatte.jdbc.mysql;

import com.junenatte.jdbc.bean.Category;
import com.junenatte.jdbc.dao.BaseDao;
import com.junenatte.jdbc.dao.ICategoryDao;

import java.util.List;

public class MysqlCategoryDao extends BaseDao implements ICategoryDao {
    @Override
    public List<Category> findAll() {
        String sql = "select * from category";
        return this.getListBySql(Category.class, sql);
    }

    @Override
    public List<Category> findById(Integer id) {
        String sql = "select * from category where id=?";
        return this.getListBySql(Category.class, sql, id);
    }
}
