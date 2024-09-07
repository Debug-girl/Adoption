package org.example;

import org.example.domain.Administrator;
import org.example.domain.Adopter;
import org.example.domain.Pet;
import org.example.service.administrator.AdministratorService;
import org.example.service.administrator.IAdministratorService;
import org.example.service.adopter.IAdopterService;
import org.example.service.adopter.AdopterService;
import org.example.service.shelter.IShelterService;
import org.example.service.shelter.ShelterService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入账号:");
        String name = sc.next();
        System.out.print("请输入密码:");
        String password = sc.next();

        //测试领养者登录
        /*IAdopterService adopterService = new AdopterService();
        Adopter adopter = adopterService.login(name,password);
        if(adopter != null){
            System.out.println("领养者登录成功");
        }else{
            System.out.println("账号或者密码错误");
        }*/

        //测试领养者注册
        IAdopterService adopterService = new AdopterService();
        if(adopterService.register("orange","123","湖北荆州")){
            System.out.println("用户注册成功!");
        }

        //测试管理员登录
        IAdministratorService administratorService = new AdministratorService();
        Administrator administrator = administratorService.login(name,password);
        if(administrator != null){
            System.out.println("管理员登录成功");
        }else{
            System.out.println("账号或者密码错误");
        }

        //测试打印获取所有用户
        for(Adopter adopter : administratorService.getAllAdopters()){
            System.out.println(adopter.toString());
        }

        //测试删除用户 根据ID
        /*System.out.print("输入删除用户的ID:");
        int deleteId = sc.nextInt();
        administratorService.deleteAdopter(deleteId);*/

        //测试删除用户 根据name
        /*System.out.print("输出删除用户的name:");
        String deleteName = sc.next();
        administratorService.deleteAdopter(deleteName);*/

        IShelterService shelterService = new ShelterService();
        for(Pet pet : shelterService.getAllPets()){
            System.out.println(pet.toString());
        }

    }

}