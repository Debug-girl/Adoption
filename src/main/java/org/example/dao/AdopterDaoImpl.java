package org.example.dao;

import org.example.domain.Adopter;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdopterDaoImpl implements IAdopterDao {

    @Override
    public boolean register(String name,String password,String address) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "insert into adopter (name, password, address) values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ps.setString(3,address);
            ps.execute();
            DBUtil.closeConnection(connection);
        } catch (SQLException throwables) {
            //System.out.println(throwables.getErrorCode());
            if(throwables.getErrorCode() == 1062){
                System.err.println("用户名已经存在!");
            }else{
                throwables.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override
    public Adopter login(String name,String password) {
        Adopter loggedInAdopter = null;
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "SELECT * FROM adopter WHERE name = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                loggedInAdopter = new Adopter();
                loggedInAdopter.setId(rs.getInt("adopterID"));
                loggedInAdopter.setName(rs.getString("name"));
                loggedInAdopter.setPassword(rs.getString("password"));
                loggedInAdopter.setAddress(rs.getString("address"));
            } else {
                System.err.println("用户名或密码错误！");
            }

            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loggedInAdopter;
    }

    @Override
    public Adopter updatePassword(String name, String password, String newPassword) {
        // 验证旧密码
        Adopter adopter = login(name, password);

        if (adopter == null) {
            System.err.println("账号或密码错误!");
            return null;
        }

        try {
            // 连接数据库
            Connection connection = DBUtil.getConnection();
            String sql = "UPDATE adopter SET password = ? WHERE name = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            // 设置新密码、用户名和旧密码
            ps.setString(1, newPassword);
            ps.setString(2, name);
            ps.setString(3, password);

            // 执行更新
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("密码更新成功！");
                adopter.setPassword(newPassword);
            } else {
                System.err.println("密码更新失败！");
                adopter = null;
            }
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            adopter = null;
        }

        return adopter;
    }


}
