package org.example.domain;

import java.util.ArrayList;

public class Adopter extends Person{

    private String address;
    ArrayList<Pet> adopInfo = new ArrayList<>();

    public Adopter() {
        super();
    }

    public Adopter(int adopterID,String name,String password,String address) {
        super(adopterID,name,password);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addAdoptPet(Pet pet){
        this.adopInfo.add(pet);
    }

    public void displayAdoptionInfo(){

    }

    @Override
    public String toString() {
        return "Adopter{" +
                "address='" + address + '\'' +
                ", adopInfo=" + adopInfo +
                ", id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
