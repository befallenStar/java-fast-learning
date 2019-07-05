package com.junenatte.jdbc.dao;

import com.junenatte.jdbc.mysql.MysqlBookDao;
import com.junenatte.jdbc.mysql.MysqlCategoryDao;
import com.junenatte.jdbc.oracle.OracleBookDao;
import com.junenatte.jdbc.oracle.OracleCategoryDao;

public class DaoFactory {
    private static ReadProperties readProperties = ReadProperties.getInstance();

    public static IBookDao getBookDao() {
        IBookDao iBookDao = null;
        String type = readProperties.type;
        if ("mysql".equals(type))
            iBookDao = new MysqlBookDao();
        else if ("oracle".equals(type))
            iBookDao = new OracleBookDao();
        return iBookDao;
    }

    public static ICategoryDao getCategoryDao() {
        ICategoryDao iCategoryDao = null;
        String type = readProperties.type;
        if ("mysql".equals(type))
            iCategoryDao = new MysqlCategoryDao();
        else if ("oracle".equals(type))
            iCategoryDao = new OracleCategoryDao();
        return iCategoryDao;
    }
}
