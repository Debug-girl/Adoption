package org.example.service.shelter;
import org.example.domain.Pet;
import java.util.ArrayList;

public interface IShelterService {

    public ArrayList<Pet> getAllPets();
    public void addPet(Pet pet);
    public void deletePet(int id);
    public void deletePet(String name);

    /**
     * @param pet 需要更新的宠物对象,默认是以pet.petID来锁定对象并且更新
     */
    public void updatePet(Pet pet);

}
