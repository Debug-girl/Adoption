package org.example.service;

import org.example.dao.IAdopterDao;
import org.example.dao.AdopterDaoImpl;
import org.example.domain.Adopter;

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

}
