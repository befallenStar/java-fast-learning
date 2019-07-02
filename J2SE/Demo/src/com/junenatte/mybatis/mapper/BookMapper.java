package com.junenatte.mybatis.mapper;

import com.junenatte.mybatis.bean.Book;

import java.util.List;

public interface BookMapper {
    List<Book> findAll();
}
