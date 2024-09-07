package org.example.dao.admin;

import org.example.domain.Administrator;
import org.example.domain.Adopter;

import java.util.ArrayList;

public interface IAdminDao {

    public Administrator login(String name, String password);

    public ArrayList<Adopter> getAllAdopters();

    public void deleteAdopter(int id);

    public void deleteAdopter(String name);

}
