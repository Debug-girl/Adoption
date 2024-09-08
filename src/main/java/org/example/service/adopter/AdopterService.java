package org.example.service.adopter;

import org.example.dao.adopter.IAdopterDao;
import org.example.dao.adopter.AdopterDaoImpl;
import org.example.domain.Adopter;

public class AdopterService implements IAdopterService {

    IAdopterDao adopterDao = new AdopterDaoImpl();

    @Override
    public boolean register(String username, String password, String address) {
        return adopterDao.register(username, password, address);
    }

    @Override
    public Adopter login(String name, String password) {
        return adopterDao.login(name,password);
    }

    @Override
    public void updatePassword(String name,String password,String newPassword) {
        adopterDao.updatePassword(name, password, newPassword);
    }

    @Override
    public boolean adoption(int adopterId,int petId) {
        return adopterDao.adoption(adopterId,petId);
    }

}
