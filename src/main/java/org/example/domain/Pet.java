package org.example.domain;

public class Pet {
    @SuppressWarnings("unused")
    private int petID;//编号
    private String petName;//昵称
    private String petCategory;  //宠物类别
    @SuppressWarnings("unused")
    private int petAge;
    private String petSex;
    private float petWeight;
    private String petInfo;//简介
    private String petStatus;//领养状态

    public Pet(int petID, String petName, String petCategory, int petAge, String petSex, float petWeight, String petInfo, String petStatus) {
        this.petID = petID;
        this.petName = petName;
        this.petCategory = petCategory;
        this.petAge = petAge;
        this.petSex = petSex;
        this.petWeight = petWeight;
        this.petInfo = petInfo;
        this.petStatus = petStatus;
    }

    public Pet() {

    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getPetCategory() {
        return petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
    }

    public String getPetSex() {
        return petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }

    public float getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(float petWeight) {
        this.petWeight = petWeight;
    }

    public String getPetInfo() {
        return petInfo;
    }

    public void setPetInfo(String petInfo) {
        this.petInfo = petInfo;
    }

    public String getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }

    public void displayInfo(){
        System.out.println("-----------------------------");
        System.out.println("Pet Number: " + petID);
        System.out.println("Pet Name: " + petName);
        System.out.println("Pet Category: " + petCategory);
        System.out.println("Pet Age: " + petAge);
        System.out.println("Pet Sex: " + petSex);
        System.out.println("Pet Weight: " + petWeight + " kg");
        System.out.println("Pet Info: " + petInfo);
        System.out.println("Pet Status: " + petStatus);
        System.out.println("-----------------------------");
    }

    @Override
    public String toString() {
        return "BasicInfo{" +
                "petNum=" + petID +
                ", petName='" + petName + '\'' +
                ", petCategory='" + petCategory + '\'' +
                ", petAge=" + petAge +
                ", petSex='" + petSex + '\'' +
                ", petWeight=" + petWeight +
                ", petInfo='" + petInfo + '\'' +
                ", petStatus='" + petStatus + '\'' +
                '}';
    }

    public void disPlay(){
        System.out.println("动物ID:"+getPetID());
        System.out.println("动物姓名:"+getPetName());
        System.out.println("动物种类:"+getPetCategory());
        System.out.println("动物年龄:"+getPetAge());
        System.out.println("动物性别:"+getPetSex());
        System.out.println("动物体重:"+getPetWeight());
        System.out.println("动物详情:"+getPetInfo());
        System.out.println("动物状态:"+getPetStatus());
        System.out.println();

    }


}