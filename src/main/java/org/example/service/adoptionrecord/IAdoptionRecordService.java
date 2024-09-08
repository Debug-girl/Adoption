package org.example.service.adoptionrecord;

import org.example.domain.AdoptionRecord;

import java.time.LocalDate;
import java.util.List;

public interface IAdoptionRecordService {

    public List<AdoptionRecord> getAllRecords();

    public boolean addAdoptionRecord(int adopterId, int petId, String status, LocalDate date);

    public boolean deleteAdoptionRecord(int recordId);

}
