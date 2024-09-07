package org.example.domain;

import org.example.domain.BasicInfo;

import java.util.ArrayList;

public class Adopter extends Person{
    private int adopterID;
    private String name;
    private String password;
    private String address;
    ArrayList<BasicInfo> adopInfo = new ArrayList<>();

    public Adopter() {

    }

    public Adopter(int adopterID,String name,String password,String address) {
        super();
        this.adopterID = adopterID;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdopterID() {
        return adopterID;
    }

    public void setAdopterID(int adopterID) {
        this.adopterID = adopterID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addAdoptAnimal(BasicInfo basicInfo){

    }

    public void displayAdoptionInfo(){

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "adopterID=" + adopterID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", adopInfo=" + adopInfo +
                '}';
    }

}
