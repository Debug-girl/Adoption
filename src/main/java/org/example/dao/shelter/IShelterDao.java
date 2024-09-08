package org.example.dao.shelter;

import org.example.domain.Adopter;
import org.example.domain.Pet;

import java.util.ArrayList;

public interface IShelterDao {

    public ArrayList<Pet> getAllPets();
    public void addPet(Pet pet);
    public void deletePet(int id);
    public void deletePet(String name);
    public void updatePet(Pet pet);


    /**从收留所领养宠物
     * @param adopter 领养人对象
     * @param pet 需要领养的宠物对象
     * @return
     */
    public boolean adoption(Adopter adopter,Pet pet);


    /**归还宠物到收留所  暂时启用
     * @param adopter 归还的人
     * @param pet 归还的宠物
     * @return
     */
    public boolean revert(Adopter adopter,Pet pet);

    public ArrayList<Pet> adoptable();
}
