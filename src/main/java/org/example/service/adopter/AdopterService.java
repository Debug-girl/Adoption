package org.example.service.adopter;

import org.example.dao.adopter.IAdopterDao;
import org.example.dao.adopter.AdopterDaoImpl;
import org.example.domain.Adopter;
import org.example.domain.AdoptionRecord;

import java.util.ArrayList;

public class AdopterService implements IAdopterService {

    IAdopterDao adopterDao = new AdopterDaoImpl();

    public boolean register(String username, String password, String address) {
        return adopterDao.register(username, password, address);
    }

    public Adopter login(String name, String password){
        return adopterDao.login(name,password);
    }

    public void updatePassword(String name,String password,String newPassword){
        adopterDao.updatePassword(name, password, newPassword);
    }

    @Override
    public ArrayList<AdoptionRecord> getAdoptionRecord(int adopterID) {
        return adopterDao.getAdoptionRecord(adopterID);
    }

}
