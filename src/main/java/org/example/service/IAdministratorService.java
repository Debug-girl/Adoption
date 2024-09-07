package org.example.service;

import org.example.domain.Administrator;
import org.example.domain.Adopter;

import java.util.ArrayList;

public interface IAdministratorService {

    public Administrator login(String name, String password);

    public ArrayList<Adopter>getAllAdopters();

    public void deleteAdopter(int id);

    public void deleteAdopter(String name);

}
