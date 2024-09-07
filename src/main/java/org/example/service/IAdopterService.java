package org.example.service;

import org.example.domain.Adopter;

public interface IAdopterService {

    public boolean register(String name, String password,String address);

    public Adopter login(String name, String password);

    public void updatePassword(String name,String password,String newPassword);
}
