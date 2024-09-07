package org.example.dao;

import org.example.domain.Administrator;
import org.example.domain.Adopter;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDaoImpl implements IAdminDao{
    
    @Override
    public Administrator login(String name, String password) {
        Administrator loginAdmin = null;
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "SELECT * FROM administrator WHERE adminName = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                loginAdmin = new Administrator();
                loginAdmin.setId(rs.getInt("adminID"));
                loginAdmin.setName(rs.getString("adminName"));
                loginAdmin.setPassword(rs.getString("password"));
            } else {
                System.err.println("用户名或密码错误！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loginAdmin;
    }


    @Override
    public ArrayList<Adopter> getAllAdopters () {
        ArrayList<Adopter> adopters = new ArrayList<>();
        
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "SELECT * FROM adopter";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Adopter adopter = new Adopter();
                adopter.setId(rs.getInt("adopterID"));
                adopter.setName(rs.getString("name"));
                adopter.setPassword(rs.getString("password"));
                adopter.setAddress(rs.getString("address"));
                adopters.add(adopter);
            }

            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adopters;
    }

    @Override
    public void deleteAdopter(int id) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "DELETE FROM adopter WHERE adopterID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("根据ID删除成功！");
            } else {
                System.out.println("未找到领养者！");
            }

            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAdopter(String name) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "DELETE FROM adopter WHERE name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("根据name删除成功！");
            } else {
                System.out.println("未找到领养者！");
            }
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
