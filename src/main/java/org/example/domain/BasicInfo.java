package org.example.domain;

public class BasicInfo{
    @SuppressWarnings("unused")
    private int petNum;//编号
    private String petName;//昵称
    private String petCategory;  //宠物类别
    @SuppressWarnings("unused")
    private int petAge;
    private String petSex;
    private float petWeight;
    private String petInfo;//简介
    private String petStatus;//领养状态

    public BasicInfo(int petNum, String petName, String petCategory, int petAge, String petSex, float petWeight, String petInfo,String petStatus) {
        this.petNum = petNum;
        this.petName = petName;
        this.petCategory = petCategory;
        this.petAge = petAge;
        this.petSex = petSex;
        this.petWeight = petWeight;
        this.petInfo = petInfo;
        this.petStatus = petStatus;
    }

    public BasicInfo() {
    }

    public BasicInfo(int id, String name, String category, int age, String status) {
    }


    public int getPetNum() {
        return petNum;
    }

    public void setPetNum(int petNum) {
        this.petNum = petNum;
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
        System.out.println("Pet Number: " + petNum);
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
                "petNum=" + petNum +
                ", petName='" + petName + '\'' +
                ", petCategory='" + petCategory + '\'' +
                ", petAge=" + petAge +
                ", petSex='" + petSex + '\'' +
                ", petWeight=" + petWeight +
                ", petInfo='" + petInfo + '\'' +
                ", petStatus='" + petStatus + '\'' +
                '}';
    }



}