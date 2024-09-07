package org.example.service;

import org.example.domain.Adopter;

public interface IUesrService {

    public void addAdopter(Adopter adopter);
    public Adopter login(String name, String password);
    public void updatePassword(String name,String password,String newPassword);
}
