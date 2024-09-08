package org.example.service.adopter;

import org.example.domain.Adopter;
import org.example.domain.AdoptionRecord;

import java.util.ArrayList;

public interface IAdopterService {

    public boolean register(String name, String password,String address);

    public Adopter login(String name, String password);

    public void updatePassword(String name,String password,String newPassword);

    public ArrayList<AdoptionRecord> getAdoptionRecord(int adopterID);

    public boolean adoption(int adopterId,int petId);

}
