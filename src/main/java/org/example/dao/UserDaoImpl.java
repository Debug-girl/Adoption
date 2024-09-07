package org.example.dao;

import org.example.domain.Adopter;
import org.example.domain.Person;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {

    @Override
    public void register(Person person , int choice) {

        try {
            Connection connection = DBUtil.getConnection();
            String sql = "";   //= "insert into adopter values(?,?,?,?)";

            switch (choice){
                case 1 : sql = "insert into adopter values(?,?,?)";break;

                case 2 : sql = "insert into administrator values(?,?,?)";break;

                default: System.err.println("无效的用户类型选择!");
            }

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1,person.getUsername());
            ps.setString(2,person.getPassword());

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //System.out.println(throwables.getErrorCode());
            if(throwables.getErrorCode() == 1062){
                System.err.println("用户信息重复!");
            }
        }


    }

    @Override
    public Adopter login(String name,String password) {
        Adopter loggedInAdopter = null;
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "SELECT * FROM adopter WHERE name = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            // 设置参数
            ps.setString(1, name);
            ps.setString(2, password);

            // 执行查询
            ResultSet rs = ps.executeQuery();

            // 检查结果
            if (rs.next()) {
                // 如果找到了匹配的记录，将结果封装到 Adopter 对象中
                loggedInAdopter = new Adopter();
                loggedInAdopter.setAdopterID(rs.getInt("adopterID"));
                loggedInAdopter.setName(rs.getString("name"));
                loggedInAdopter.setPassword(rs.getString("password"));
                loggedInAdopter.setAddress(rs.getString("address"));
            } else {
                // 没有匹配记录，打印错误信息
                System.err.println("用户名或密码错误！");
            }

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
                adopter.setPassword(newPassword); // 更新内存中的密码
            } else {
                System.err.println("密码更新失败！");
                adopter = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            adopter = null;
        }

        return adopter;
    }


}
