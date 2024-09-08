package org.example.controller;

import org.example.dao.shelter.IShelterDao;
import org.example.dao.shelter.ShelterDaoImpl;
import org.example.domain.Administrator;
import org.example.domain.Adopter;
import org.example.domain.Pet;
import org.example.service.administrator.AdministratorService;
import org.example.service.administrator.IAdministratorService;

import java.util.Scanner;

public class Menu {

    IAdministratorService iAdministratorService = new AdministratorService();
    IShelterDao iShelterDao = new ShelterDaoImpl();
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
            case 1:userMenu();
            case 2:adminMenu();
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
            System.err.println("账号或密码错误!");
        }

        while (true){
            System.out.println(" --- 管理员菜单 --- ");
            System.out.println("1.获取所有用户信息");
            System.out.println("2.删除用户信息");
            System.out.println("3.查看所有动物信息");
            System.out.println("4.更新动物信息");
            System.out.println("5.添加新动物");
            System.out.println("6.删除动物");
            System.out.println("7.查看领养记录");
            System.out.println("8.退出");

            int choice = sc.nextInt();
            System.out.flush();
            switch (choice) {
                case 1:{
                    for (Adopter adopter : iAdministratorService.getAllAdopters()) {
                        System.out.println(adopter.toString());
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
                    for (Pet pet : iShelterDao.getAllPets()) {
                        System.out.println(pet.toString());
                    }
                    break;
                }
                case 4:{
                    System.out.println("请输入动物ID:");
                    int petID = sc.nextInt();
                    for (Pet pet : iShelterDao.getAllPets()) {
                        if (petID == pet.getPetID()) {
                            System.out.println("请输入修改后的详情:");
                            String petInfo = sc.next();
                            pet.setPetInfo(petInfo);
                            iShelterDao.updatePet(pet);
                        }
                    }
                    break;
                }
                case 5:{
                    Pet pet = new Pet();

                    System.out.println("请输入动物名字:");
                    String petName = sc.next();
                    pet.setPetName(name);

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
                    String petInfo = sc.next();
                    pet.setPetInfo(petInfo);

                    pet.setPetStatus("待领养");
                    iShelterDao.addPet(pet);
                    break;
                }
                case 6:{
                    System.out.println("请输入动物ID:");
                    int petID = sc.nextInt();
                    iShelterDao.deletePet(petID);
                    break;
                }
                case 7:{
                    break;
                }
                case 8:System.exit(0);break;
                default:System.err.println("无效的选择!");break;
            }
        }
    }

    private void userMenu() {
        //测试提交前不更新
    }
}
