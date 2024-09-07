package org.example.dao;

import org.example.domain.Adopter;
import org.example.domain.Person;

public interface IAdopterDao {

    public boolean register(String name,String password,String address);

    public Adopter login(String name,String password);

    public Adopter updatePassword(String name,String password,String newPassword);

}
