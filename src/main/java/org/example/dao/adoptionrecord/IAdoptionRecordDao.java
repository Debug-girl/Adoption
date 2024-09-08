package org.example.dao.adoptionrecord;

import org.example.domain.Adopter;
import org.example.domain.AdoptionRecord;
import org.example.domain.Pet;

import java.time.LocalDate;
import java.util.List;

public interface IAdoptionRecordDao {

    public List<AdoptionRecord> getAllRecords();

    public boolean addAdoptionRecord(int adopterId, int petId,String status,LocalDate date);

}
