package com.junenatte.jdbc;

import com.junenatte.jdbc.bean.Book;
import com.junenatte.jdbc.bean.Category;
import com.junenatte.jdbc.dao.DaoFactory;
import com.junenatte.jdbc.dao.IBookDao;
import com.junenatte.jdbc.dao.ICategoryDao;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ICategoryDao cd = DaoFactory.getCategoryDao();
        List<Category> categories = cd.findAll();
//        List<Category> categories = cd.findById(1);
        for (Category c : categories)
            System.out.println("--id:" + c.getId() + "\tcategory:" + c.getCategory() + "\tremark:" + c.getRemark() + "--");
        IBookDao bd = DaoFactory.getBookDao();
        List<Book> books = bd.findAll();
        for (Book b : books)
            System.out.println("--id:" + b.getId() + "\tname:" + b.getName() + "\tremark:" + b.getAuthor() + "--");
    }
}
