package org.example.dao;

import org.example.domain.Adopter;
import org.example.domain.Person;

public interface IUserDao {

    public void register(Person person , int choice);

    public Adopter login(String name,String password);

    public Adopter updatePassword(String name,String password,String newPassword);


}
