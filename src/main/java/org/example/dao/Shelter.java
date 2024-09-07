package org.example.dao;

import org.example.domain.AdoptionRecord;
import org.example.domain.BasicInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class Shelter {

    private Connection connection;
    private String name;
    private String address;
    private List<BasicInfo> animals;                     //所有待领养的动物
    private List<AdoptionRecord> adoptionRecords;        //领养记录表

    public Shelter(Connection connection) {
        this.connection = connection;
        this.animals = new ArrayList<>();
        this.adoptionRecords = new ArrayList<>();
    }

    public Shelter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addAnimal(BasicInfo animal) {
        animals.add(animal);
    }

    public void removeAnimal(int animalId) {
        if (animalId >= 0 && animalId < animals.size()){
            animals.remove(animalId);
        }else
            System.out.println("请输入正确的动物编号！");
    }

    public void addAdoptionRecord(AdoptionRecord record) {
        adoptionRecords.add(record);
    }

    public List<BasicInfo> getAvailableAnimals() {
        // 返回可供领养的动物列表
        return animals.stream().filter(a -> a.getPetStatus().equals("待领养")).collect(Collectors.toList()); //filter筛选、collect收集
    }

    public List<AdoptionRecord> getAdoptionRecords() {
        return adoptionRecords;
    }

    public void showAnimals(){
        System.out.println("PawPal Adoption System -- ALL ANIMALS");
        for (BasicInfo animal : animals){
            animal.displayInfo();
        }
    }

    public List<BasicInfo> getAllAnimalsFromDB() {
        try{

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM basicInfo");
            animals.clear();  // 清空现有的 animals 列表

            // 遍历数据库中的所有记录
            while (rs.next()) {
                int petNum = rs.getInt("petNum");
                String petName = rs.getString("petName");
                String petCategory = rs.getString("petCategory");
                int petAge = rs.getInt("petAge");
                String petSex = rs.getString("petSex");
                float petWeight = rs.getFloat("petWeight");
                String petInfo = rs.getString("petInfo");
                String petStatus = rs.getString("petStatus");

                // 创建 basicInfo 对象并添加到 animals 列表中
                BasicInfo animal = new BasicInfo(petNum, petName, petCategory, petAge, petSex, petWeight, petInfo, petStatus);
                animals.add(animal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animals;
    }
}
