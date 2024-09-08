package org.example.dao.adopter;

import org.example.domain.Adopter;
import org.example.domain.AdoptionRecord;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Override
    public boolean adoption(int adopterId,int petId) {

        try {
            // 获取数据库连接
            Connection connection = DBUtil.getConnection();

            // 检查宠物是否待领养状态
            String checkPetStatusSql = "SELECT petStatus FROM Shelter WHERE petID = ?";
            PreparedStatement checkPs = connection.prepareStatement(checkPetStatusSql);
            checkPs.setInt(1, petId);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next() && rs.getString("petStatus").equals("待领养")) {
                // 更新宠物状态为已领养
                String updatePetStatusSql = "UPDATE Shelter SET petStatus = '已领养' WHERE petID = ?";
                PreparedStatement updatePs = connection.prepareStatement(updatePetStatusSql);
                updatePs.setInt(1, petId);
                updatePs.executeUpdate();

                // 写入领养记录
                String insertAdoptionRecordSql = "INSERT INTO AdoptionRecord (adopterID, petID,status, adoptionDate) VALUES (?, ?,'领养',NOW())";
                PreparedStatement insertPs = connection.prepareStatement(insertAdoptionRecordSql);
                insertPs.setInt(1, adopterId);
                insertPs.setInt(2, petId);
                insertPs.executeUpdate();

                System.out.println("宠物领养成功！");
            } else {
                System.err.println("宠物已经被领养了！");
            }

            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    @Override
    public ArrayList<AdoptionRecord> getAdoptionRecord(int adopterID) {
        ArrayList<AdoptionRecord> adoptionRecords = new ArrayList<>();

        try {
            // 获取数据库连接
            Connection connection = DBUtil.getConnection();
            String sql = "SELECT * FROM adoptionrecord WHERE adopterID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, adopterID);
            ResultSet rs = ps.executeQuery();

            // 遍历结果集并将记录添加到列表中
            while (rs.next()) {
                AdoptionRecord adoptionRecord = new AdoptionRecord();
                adoptionRecord.setRecordId(rs.getInt("recordID"));
                adoptionRecord.setAdopterID(rs.getInt("adopterID"));
                adoptionRecord.setPetID(rs.getInt("petID"));
                adoptionRecord.setStatus(rs.getString("status"));
                adoptionRecord.setAdoptionDate(rs.getDate("adoptionDate").toLocalDate());
                adoptionRecords.add(adoptionRecord);
            }

            // 关闭资源
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adoptionRecords;
    }



}
