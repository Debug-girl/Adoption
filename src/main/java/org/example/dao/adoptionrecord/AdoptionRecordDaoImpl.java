package org.example.dao.adoptionrecord;

import org.example.domain.Adopter;
import org.example.domain.AdoptionRecord;
import org.example.domain.Pet;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdoptionRecordDaoImpl implements IAdoptionRecordDao {
    
    @Override
    public List<AdoptionRecord> getAllRecords() {
        List<AdoptionRecord> records = new ArrayList<>();
        String query = "SELECT * FROM adoptionrecord";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int recordId = rs.getInt("recordId");
                int adopterID = rs.getInt("adopterID");
                int petID = rs.getInt("petID");
                String status = rs.getString("status");
                LocalDate adoptionDate = rs.getDate("adoptionDate").toLocalDate();
                AdoptionRecord record = new AdoptionRecord(recordId, adopterID, petID,status, adoptionDate);
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return records;
    }

    @Override
    public boolean addAdoptionRecord(int adopterId, int petId, String status, LocalDate date) {
        String query = "INSERT INTO adoptionrecord (adopterID, petID, status, adoptionDate) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, adopterId);
            pstmt.setInt(2, petId);
            pstmt.setString(3, status);
            pstmt.setDate(4, java.sql.Date.valueOf(date));
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0; // Return true if insertion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean deleteAdoptionRecord(int recordId) {
        String query = "DELETE FROM adoptionrecord WHERE recordId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, recordId);
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0; // Return true if deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
