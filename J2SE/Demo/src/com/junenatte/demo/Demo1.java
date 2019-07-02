package com.junenatte.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo1 {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet rs;
        PreparedStatement stmt = null;
        String url = "jdbc:mysql://localhost:3306/book_category";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement("select * from category");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String category = rs.getString("category");
                String remark = rs.getString("remark");
                System.out.println("--id:" + id + "\tcategory:" + category + "\tremark:" + remark + "--");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
