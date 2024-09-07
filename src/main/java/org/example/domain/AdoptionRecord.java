package org.example.domain;

import org.example.domain.Adopter;
import org.example.domain.BasicInfo;

import java.time.LocalDate;

public class AdoptionRecord {
    LocalDate localDate = LocalDate.now();

    private int recordId;
    private Adopter adopter;
    private BasicInfo animal;
    private LocalDate adoptionDate;

    public AdoptionRecord(int recordId, Adopter adopter, BasicInfo animal) {
        this.recordId = recordId;
        this.adopter = adopter;
        this.animal = animal;
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

    public BasicInfo getAnimal() {
        return animal;
    }

    public void setAnimal(BasicInfo animal) {
        this.animal = animal;
    }
}
