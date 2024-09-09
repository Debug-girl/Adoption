package org.example.domain;

import java.time.LocalDateTime;

public class AdoptionRecord {

    private int recordId;
    private int adopterID;
    private int petID;
    private String status;          //状态: '领养' ‘归还’
    private LocalDateTime adoptionDateTime;

    public AdoptionRecord(int recordId, int adopterID, int petID,String status, LocalDateTime date) {
        this.recordId = recordId;
        this.adopterID = adopterID;
        this.petID = petID;
        this.status = status;
        this.adoptionDateTime = date;
    }

    public AdoptionRecord() {

    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getAdopterID() {
        return adopterID;
    }

    public void setAdopterID(int adopterID) {
        this.adopterID = adopterID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }


    public LocalDateTime getAdoptionDateTime() {
        return adoptionDateTime;
    }

    public void setAdoptionDateTime(LocalDateTime adoptionDateTime) {
        this.adoptionDateTime = adoptionDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "记录ID:" + recordId +
                ", 领养者ID:" + adopterID +
                ", 宠物ID:" + petID +
                ", 状态:'" + status + '\'' +
                ", 领养时间:" + adoptionDateTime ;
    }
}
