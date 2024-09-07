package org.example.domain;

import java.time.LocalDate;

public class AdoptionRecord {

    private int recordId;
    private Adopter adopter;
    private Pet animal;
    private String status;          //状态: '领养' ‘归还’
    private LocalDate adoptionDate;

    public AdoptionRecord(int recordId, Adopter adopter, Pet animal,LocalDate date) {
        this.recordId = recordId;
        this.adopter = adopter;
        this.animal = animal;
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

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    public Pet getAnimal() {
        return animal;
    }

    public void setAnimal(Pet animal) {
        this.animal = animal;
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

}
