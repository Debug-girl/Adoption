package org.example.dao.shelter;


import org.example.domain.Adopter;
import org.example.domain.Pet;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShelterDaoImpl implements IShelterDao {

    @Override
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();

        try {
            Connection connection = DBUtil.getConnection();
            String sql = "SELECT * FROM shelter";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetID(rs.getInt("petID"));
                pet.setPetName(rs.getString("petName"));
                pet.setPetCategory(rs.getString("petCategory"));
                pet.setPetAge(rs.getInt("petAge"));
                pet.setPetSex(rs.getString("petSex"));
                pet.setPetWeight(rs.getFloat("petWeight"));
                pet.setPetInfo(rs.getString("petInfo"));
                pet.setPetStatus(rs.getString("petStatus"));
                pets.add(pet);
            }

            rs.close();
            ps.close();
            DBUtil.closeConnection(connection);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return pets;
    }

    @Override
    public void addPet(Pet pet) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "INSERT INTO shelter (petName, petCategory, petAge, petSex, petWeight, petInfo, petStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pet.getPetName());
            ps.setString(2, pet.getPetCategory());
            ps.setInt(3, pet.getPetAge());
            ps.setString(4, pet.getPetSex());
            ps.setFloat(5, pet.getPetWeight());
            ps.setString(6, pet.getPetInfo());
            ps.setString(7, pet.getPetStatus());

            ps.executeUpdate();

            ps.close();
            DBUtil.closeConnection(connection);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deletePet(int id) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "DELETE FROM shelter WHERE petID = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            DBUtil.closeConnection(connection);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deletePet(String name) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "DELETE FROM shelter WHERE petName = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);

            ps.executeUpdate();

            ps.close();
            DBUtil.closeConnection(connection);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void updatePet(Pet pet) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "UPDATE shelter SET petName = ?, petCategory = ?, petAge = ?, petSex = ?, petWeight = ?, petInfo = ?, petStatus = ? WHERE petID = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pet.getPetName());
            ps.setString(2, pet.getPetCategory());
            ps.setInt(3, pet.getPetAge());
            ps.setString(4, pet.getPetSex());
            ps.setFloat(5, pet.getPetWeight());
            ps.setString(6, pet.getPetInfo());
            ps.setString(7, pet.getPetStatus());
            ps.setInt(8, pet.getPetID());

            ps.executeUpdate();

            ps.close();
            DBUtil.closeConnection(connection);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Pet getPet(int id) {
        Connection connection = DBUtil.getConnection();
        Pet pet = null;
        try {
            String sql = "SELECT * FROM shelter WHERE petID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);;
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                pet = new Pet();
                pet.setPetID(rs.getInt("petID"));
                pet.setPetName(rs.getString("petName"));
                pet.setPetCategory(rs.getString("petCategory"));
                pet.setPetAge(rs.getInt("petAge"));
                pet.setPetSex(rs.getString("petSex"));
                pet.setPetWeight(rs.getFloat("petWeight"));
                pet.setPetInfo(rs.getString("petInfo"));
                pet.setPetStatus(rs.getString("petStatus"));
                break;
            }
            rs.close();
            preparedStatement.close();
            DBUtil.closeConnection(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pet;
    }

    @Override
    public Pet getPet(String name) {
        Connection connection = DBUtil.getConnection();
        Pet pet = null;
        try {
            String sql = "SELECT * FROM shelter WHERE petName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);;
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                pet = new Pet();
                pet.setPetID(rs.getInt("petID"));
                pet.setPetName(rs.getString("petName"));
                pet.setPetCategory(rs.getString("petCategory"));
                pet.setPetAge(rs.getInt("petAge"));
                pet.setPetSex(rs.getString("petSex"));
                pet.setPetWeight(rs.getFloat("petWeight"));
                pet.setPetInfo(rs.getString("petInfo"));
                pet.setPetStatus(rs.getString("petStatus"));
                break;
            }
            rs.close();
            preparedStatement.close();
            DBUtil.closeConnection(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pet;
    }

    @Override
    public boolean adoption(Adopter adopter,Pet pet) {
        try {
            Connection connection = DBUtil.getConnection();
            String updateSql = "UPDATE shelter SET petStatus = '已领养' WHERE petID = ? AND petStatus = '待领养'";
            PreparedStatement updatePs = connection.prepareStatement(updateSql);
            updatePs.setInt(1, pet.getPetID());

            int rowsAffected = updatePs.executeUpdate();
            if (rowsAffected > 0) {
                String insertSql = "INSERT INTO adoptionrecord (adopterID, petID, status, adoptionDate) VALUES (?, ?, ?, NOW())";
                PreparedStatement insertPs = connection.prepareStatement(insertSql);
                insertPs.setInt(1, adopter.getId());
                insertPs.setInt(2, pet.getPetID());
                insertPs.setString(3,"领养");
                insertPs.executeUpdate();
                insertPs.close();
            }

            updatePs.close();
            DBUtil.closeConnection(connection);
            return rowsAffected > 0;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean revert(Adopter adopter,Pet pet) {
        try {
            Connection connection = DBUtil.getConnection();
            String updateSql = "UPDATE shelter SET petStatus = '待领养' WHERE petID = ? AND petStatus = '已领养'";
            PreparedStatement updatePs = connection.prepareStatement(updateSql);
            updatePs.setInt(1, pet.getPetID());

            int rowsAffected = updatePs.executeUpdate();
            if (rowsAffected > 0) {
                String insertSql = "INSERT INTO adoptionrecord (adopterID, petID, status, adoptionDate) VALUES (?, ?, ?, NOW())";
                PreparedStatement insertPs = connection.prepareStatement(insertSql);
                insertPs.setInt(1, adopter.getId());
                insertPs.setInt(2, pet.getPetID());
                insertPs.setString(3, "归还");
                insertPs.executeUpdate();
                insertPs.close();
            }

            updatePs.close();
            DBUtil.closeConnection(connection);
            return rowsAffected > 0;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Pet> adoptable() {
        ArrayList<Pet> pets = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "SELECT * FROM shelter WHERE petStatus = '待领养'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetID(rs.getInt("petID"));
                pet.setPetName(rs.getString("petName"));
                pet.setPetCategory(rs.getString("petCategory"));
                pet.setPetAge(rs.getInt("petAge"));
                pet.setPetSex(rs.getString("petSex"));
                pet.setPetWeight(rs.getFloat("petWeight"));
                pet.setPetInfo(rs.getString("petInfo"));
                pet.setPetStatus(rs.getString("petStatus"));
                pets.add(pet);
            }

            rs.close();
            ps.close();
            DBUtil.closeConnection(connection);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        for (Pet pet : pets){
            pet.disPlay();
        }

        return pets;
    }

}




