package com.junenatte.jdbc.servlet;

import com.junenatte.jdbc.bean.Category;
import com.junenatte.jdbc.dao.DaoFactory;
import com.junenatte.jdbc.dao.ICategoryDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICategoryDao cd = DaoFactory.getCategoryDao();
        List<Category> categories = cd.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
