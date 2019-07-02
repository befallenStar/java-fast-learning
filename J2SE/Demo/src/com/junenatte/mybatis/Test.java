package com.junenatte.mybatis;

import com.junenatte.mybatis.bean.Book;
import com.junenatte.mybatis.bean.Category;
import com.junenatte.mybatis.mapper.BookMapper;
import com.junenatte.mybatis.mapper.CategoryMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            String path = "com/junenatte/mybatis/mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(path);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = sessionFactory.openSession();
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            List<Category> categories = categoryMapper.findAll();
//            List<Category> categories = categoryMapper.findById(1);
            for (Category c : categories)
                System.out.println("--id:" + c.getId() + "\tcategory:" + c.getCategory() + "\tremark:" + c.getRemark() + "--");
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            List<Book> books = bookMapper.findAll();
            for (Book b : books)
                System.out.println("--id:" + b.getId() + "\tname:" + b.getName() + "\tremark:" + b.getAuthor() + "--");
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
