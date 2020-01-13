package com.ning.dao.impl;

import com.ning.dao.FlowerDao;
import com.ning.pojo.Flower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
 * 数据库访问层要有异常处理
 * */
public class FlowerDaoImpl implements FlowerDao {
    Connection coon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<Flower> selAll() {
        List<Flower> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm","root","123456");
            ps = coon.prepareStatement("select * from flower");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (coon != null) {
                    coon.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int insFlower(Flower flower) {
        Connection coon = null;
        PreparedStatement ps = null;
        int index = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm","root","123456");
            ps = coon.prepareStatement("insert into flower values(default,?,?,?)");
            ps.setObject(1,flower.getName());
            ps.setObject(2,flower.getPrice());
            ps.setObject(3,flower.getProduction());
            index = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (coon != null) {
                    coon.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }
}
