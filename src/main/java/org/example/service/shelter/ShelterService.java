package org.example.service.shelter;

import org.example.dao.shelter.IShelterDao;
import org.example.dao.shelter.ShelterDaoImpl;
import org.example.domain.Pet;

import java.util.ArrayList;

public class ShelterService implements IShelterService{

    private IShelterDao shelterDao = new ShelterDaoImpl();

    @Override
    public ArrayList<Pet> getAllPets() {
        return shelterDao.getAllPets();
    }

    @Override
    public void addPet(Pet pet) {
        shelterDao.addPet(pet);
    }

    @Override
    public void deletePet(int id) {
        shelterDao.deletePet(id);
    }

    @Override
    public void deletePet(String name) {
        shelterDao.deletePet(name);
    }

    @Override
    public void updatePet(Pet pet) {
        shelterDao.updatePet(pet);
    }

    @Override
    public ArrayList<Pet> adoptable() {
        return shelterDao.adoptable();
    }

}
