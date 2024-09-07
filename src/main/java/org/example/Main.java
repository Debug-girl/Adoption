package org.example;

import org.example.dao.IUserDao;
import org.example.dao.UserDaoImpl;
import org.example.domain.Adopter;
import org.example.service.IUesrService;
import org.example.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        IUesrService us =new UserService();

        System.out.println("请输入账号：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();

//        Adopter adopter = new Adopter();
//
//        adopter.setName(name);
//        adopter.setPassword(password);

       Adopter login = us.login(name,password);

        if(login!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("账号或者密码错误");
        }


//      注册测试
//      Adopter adopter = new Adopter(2,"banana","456","湖北黄石");
//      userDao.addAdopter(adopter);

//      登录测试
//     Adopter loginUser = userDao.login("apple","123456");
//
//      if(loginUser != null){
//          System.out.println(loginUser.toString());
//      }

        //更新用户密码 测试
       // userDao.updatePassword("banana","456","456789");


    }


}