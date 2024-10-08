package org.example.controller;

import org.example.dao.shelter.IShelterDao;
import org.example.dao.shelter.ShelterDaoImpl;
import org.example.domain.Administrator;
import org.example.domain.Adopter;
import org.example.domain.AdoptionRecord;
import org.example.domain.Pet;
import org.example.service.administrator.AdministratorService;
import org.example.service.administrator.IAdministratorService;
import org.example.service.adopter.AdopterService;
import org.example.service.adopter.IAdopterService;
import org.example.service.adoptionrecord.AdoptionRecordService;
import org.example.service.adoptionrecord.IAdoptionRecordService;
import org.example.service.shelter.IShelterService;
import org.example.service.shelter.ShelterService;

import java.util.Scanner;

public class Menu {

    IAdministratorService iAdministratorService = new AdministratorService();
    IAdoptionRecordService iAdoptionRecordService = new AdoptionRecordService();
    IShelterService iShelterService = new ShelterService();

    Scanner sc = new Scanner(System.in);

    public void mainMenu(){

        System.out.println("欢迎光临！感谢您选择我们的爪爪动物领养系统！");
        System.out.println("在这里，您可以浏览所有可供领养的动物，并查看相关领养信息。");
        System.out.println("如果您有任何问题，请随时联系我们。祝您使用愉快！");
        System.out.println("请选择您的身份：");
        System.out.println("1. 普通用户");
        System.out.println("2. 管理员");

        int choice = sc.nextInt();

        switch (choice){
            case 1:userMenu();break;
            case 2:adminMenu();break;
        }
    }

    private void adminMenu() {

        System.out.println("请输入账号密码:");
        System.out.print("账号:");
        String name = sc.next();
        System.out.print("密码:");
        String pwd = sc.next();
        Administrator adminLogin = iAdministratorService.login(name,pwd);

        if (adminLogin != null){
            System.out.println("登录成功!欢迎"+adminLogin.getName());
        }else {
            System.err.println("账号或密码错误!请重新输入");
            System.out.print("\n账号:");
            name = sc.next();
            System.out.print("密码:");
            pwd = sc.next();
            adminLogin = iAdministratorService.login(name,pwd);
        }

        while (true){
            System.out.println(" --- 管理员菜单 --- ");
            System.out.println("1.获取所有用户信息");
            System.out.println("2.删除用户信息");
            System.out.println("3.查看所有动物信息");
            System.out.println("4.更新动物信息");
            System.out.println("5.添加新动物");
            System.out.println("6.删除动物");
            System.out.println("7.查看所有领养记录");
            System.out.println("8.查看指定用户领养记录");
            System.out.println("9.退出");

            int choice = sc.nextInt();
            System.out.flush();
            switch (choice) {
                case 1:{
                    for (Adopter adopter : iAdministratorService.getAllAdopters()) {
                        adopter.disPlay();
                    }
                    break;
                }
                case 2:{
                    System.out.println("请输入用户ID:");
                    int userID = sc.nextInt();
                    iAdministratorService.deleteAdopter(userID);
                    break;
                }
                case 3:{
                    for (Pet pet : iShelterService.getAllPets()) {
                        pet.disPlay();
                    }
                    break;
                }
                case 4:{
                    System.out.println("请输入动物ID:");
                    int petID = sc.nextInt();
                    for (Pet pet : iShelterService.getAllPets()) {
                        if (petID == pet.getPetID()) {
                            pet.disPlay();
                            System.out.println("更改姓名:");
                            String petName = sc.next();
                            pet.setPetName(petName);
                            iShelterService.updatePet(pet);
                        }
                    }
                    break;
                }
                case 5:{
                    Pet pet = new Pet();

                    System.out.println("请输入动物名字:");
                    String petName = sc.next();
                    pet.setPetName(petName);

                    System.out.println("请输入动物种类:");
                    String petCategory = sc.next();
                    pet.setPetCategory(petCategory);

                    System.out.println("请输入动物年龄:");
                    int petAge = sc.nextInt();
                    pet.setPetAge(petAge);

                    System.out.println("请输入动物性别:");
                    String petSex = sc.next();
                    pet.setPetSex(petSex);

                    System.out.println("请输入动物体重:");
                    float petWeight = sc.nextFloat();
                    pet.setPetWeight(petWeight);

                    System.out.println("请输入动物简介:");

                    String petInfo = new Scanner(System.in).nextLine();
                    pet.setPetInfo(petInfo);

                    pet.setPetStatus("待领养");
                    iShelterService.addPet(pet);
                    break;
                }
                case 6:{
                    System.out.println("请输入动物ID:");
                    int petID = sc.nextInt();
                    Pet pet = iShelterService.getPet(petID);
                    if(pet == null){
                        System.err.println("宠物不存在!");
                        break;
                    }
                    iShelterService.deletePet(petID);
                    break;
                }
                case 7:{
                    for(AdoptionRecord record : iAdoptionRecordService.getAllRecords()){
                        System.out.println(record.toString());
                    }
                    break;
                }
                case 8:{
                    System.out.print("请输入用户ID:");
                    int adopterID = sc.nextInt();
                    //从获取到的所有记录中过滤出指定的用户
                    for(AdoptionRecord record : iAdoptionRecordService.getAllRecords()){
                        if(record.getAdopterID() == adopterID){
                            System.out.println(record.toString());
                        }
                    }
                    break;
                }
                case 9:System.exit(0);break;
                default:System.err.println("无效的选择!");break;
            }
        }
    }

    private void userMenu() {
        //测试提交前不更新
        System.out.println("请输入账号密码:");
        System.out.print("账号:");
        String name = sc.next();
        System.out.print("密码:");
        String pwd = sc.next();
        IAdopterService iAdopterService = new AdopterService();
        IShelterService iShelterService = new ShelterService();
        Adopter adopter = iAdopterService.login(name,pwd);

        if (adopter != null){
            System.out.println("登录成功!欢迎"+adopter.getName());
        }else {
            System.err.println("账号或密码错误!请重新输入");
            System.out.print("\n账号:");
            name = sc.next();

            System.out.print("密码:");
            pwd = sc.next();
            adopter = iAdopterService.login(name,pwd);
            if(adopter==null){
                System.out.println("二次登陆失败");
                System.exit(0);
            }
        }

        while (true){
            System.out.println(" --- 用户菜单 --- ");
            System.out.println("1.修改登录密码");
            System.out.println("2.查看所有待领养动物");
            System.out.println("3.领养动物");
            System.out.println("4.查看个人领养记录");
            System.out.println("5.退出");

            int choice = sc.nextInt();
            System.out.flush();
            switch (choice) {
                case 1:{
                    System.out.println("请输入新密码:");
                    String newPwd = sc.next();
                    iAdopterService.updatePassword(adopter.getName(),adopter.getPassword(),newPwd);
                    break;
                }
                case 2:{
                    iShelterService.adoptable();
                    break;
                }
                case 3:{
                    System.out.flush();
                    System.out.print("请输入宠物ID:");
                    int petID = sc.nextInt();
                    iAdopterService.adoption(adopter.getId(),petID);
                    break;
                }
                case 4:{
                    for(AdoptionRecord record : iAdopterService.getAdoptionRecord(adopter.getId())){
                        System.out.println(record.toString());
                    }
                    break;
                }
                case 5:System.exit(0);break;
                default:System.err.println("无效的选择!");break;
            }
        }
    }
}