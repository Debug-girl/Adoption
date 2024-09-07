package org.example.domain;

import java.util.ArrayList;

public class Administrator extends Person{
    private int adminID;
    private String adminName;
    private String password;
    ArrayList<BasicInfo> petInfo = new ArrayList<>();
    ArrayList<Adopter> adopterInfo = new ArrayList<>();



    public Administrator(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    public Administrator() {
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
