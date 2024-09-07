package org.example.service;

import org.example.dao.IUserDao;
import org.example.dao.UserDaoImpl;
import org.example.domain.Adopter;

public class UserService implements IUesrService {

    IUserDao ud = new UserDaoImpl();

    public void addAdopter(Adopter adopter){
        //ud.addAdopter(adopter);
    }

    public Adopter login(String name, String password){
        return ud.login(name,password);
        //return null;  你这里直接返回的null啊
    }

    public void updatePassword(String name,String password,String newPassword){
        ud.updatePassword(name, password, newPassword);
    }

}
