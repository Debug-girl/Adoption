package org.example.service.adoptionrecord;

import org.example.dao.adoptionrecord.AdoptionRecordDaoImpl;
import org.example.dao.adoptionrecord.IAdoptionRecordDao;
import org.example.domain.AdoptionRecord;

import java.time.LocalDate;
import java.util.List;

public class AdoptionRecordService implements IAdoptionRecordService{

    private IAdoptionRecordDao adoptionRecordDao = new AdoptionRecordDaoImpl();

    @Override
    public List<AdoptionRecord> getAllRecords() {
        return adoptionRecordDao.getAllRecords();
    }

    @Override
    public boolean addAdoptionRecord(int adopterId, int petId, String status, LocalDate date) {
        return adoptionRecordDao.addAdoptionRecord(adopterId, petId, status, date);
    }

    @Override
    public boolean deleteAdoptionRecord(int recordId) {
        return adoptionRecordDao.deleteAdoptionRecord(recordId);
    }

}
