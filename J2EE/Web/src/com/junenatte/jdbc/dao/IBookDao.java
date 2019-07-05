package com.junenatte.jdbc.dao;

import com.junenatte.jdbc.bean.Book;

import java.util.List;

public interface IBookDao {
    List<Book> findAll();
}
