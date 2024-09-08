package org.example.domain;

import java.time.LocalDate;

public class AdoptionRecord {

    private int recordId;
    private int adopterID;
    private int petID;
    private String status;          //状态: '领养' ‘归还’
    private LocalDate adoptionDate;

    public AdoptionRecord(int recordId, int adopterID, int petID,String status, LocalDate date) {
        this.recordId = recordId;
        this.adopterID = adopterID;
        this.petID = petID;
        this.status = status;
        this.adoptionDate = date;
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


    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdoptionRecord{" +
                "recordId=" + recordId +
                ", adopterID=" + adopterID +
                ", petID=" + petID +
                ", status='" + status + '\'' +
                ", adoptionDate=" + adoptionDate +
                '}';
    }
}
