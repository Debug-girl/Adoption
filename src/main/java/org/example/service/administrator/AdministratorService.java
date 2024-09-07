package org.example.service.administrator;

import org.example.dao.admin.AdminDaoImpl;
import org.example.dao.admin.IAdminDao;
import org.example.domain.Administrator;
import org.example.domain.Adopter;

import java.util.ArrayList;

public class AdministratorService implements IAdministratorService{

    IAdminDao adminDao = new AdminDaoImpl();

    @Override
    public Administrator login(String name, String password) {
        return adminDao.login(name, password);
    }

    @Override
    public ArrayList<Adopter> getAllAdopters() {
        return adminDao.getAllAdopters();
    }

    @Override
    public void deleteAdopter(int id) {
        adminDao.deleteAdopter(id);
    }

    @Override
    public void deleteAdopter(String name) {
        adminDao.deleteAdopter(name);
    }

}
