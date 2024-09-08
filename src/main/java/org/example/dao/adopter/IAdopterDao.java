package org.example.dao.adopter;

import org.example.domain.Adopter;
import org.example.domain.AdoptionRecord;

import java.util.ArrayList;

public interface IAdopterDao {

    public boolean register(String name,String password,String address);

    public Adopter login(String name,String password);

    public Adopter updatePassword(String name,String password,String newPassword);

    public ArrayList<AdoptionRecord> getAdoptionRecord(int adopterID);
}
