package com.junenatte.jdbc.mysql;

import com.junenatte.jdbc.bean.Book;
import com.junenatte.jdbc.dao.BaseDao;
import com.junenatte.jdbc.dao.IBookDao;

import java.util.List;

public class MysqlBookDao extends BaseDao implements IBookDao {
    @Override
    public List<Book> findAll() {
        String sql="select * from book";
        return this.getListBySql(Book.class,sql);
    }
}
