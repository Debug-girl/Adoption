package org.example;

import org.example.controller.Menu;
import org.example.dao.adoptionrecord.AdoptionRecordDaoImpl;
import org.example.dao.adoptionrecord.IAdoptionRecordDao;
import org.example.domain.AdoptionRecord;
import org.example.domain.Pet;
import org.example.service.adopter.AdopterService;
import org.example.service.adopter.IAdopterService;
import org.example.service.shelter.IShelterService;
import org.example.service.shelter.ShelterService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void try_test(){
        IAdoptionRecordDao adoptionRecordDao = new AdoptionRecordDaoImpl();

        adoptionRecordDao.addAdoptionRecord(1,1,"领养", LocalDate.now());

        for(AdoptionRecord adoptionRecord : adoptionRecordDao.getAllRecords()){
            System.out.println(adoptionRecord.toString());
        }

    }
    public static void text(){
        Scanner sc = new Scanner(System.in);
        IAdopterService iAdopterService = new AdopterService();
        int adopid = sc.nextInt();
        for(AdoptionRecord record : iAdopterService.getAdoptionRecord(adopid)){
            System.out.println(record.toString());
        }
    }
    public static void main(String[] args) throws SQLException {
        //try_test();
        text();
        Menu menu = new Menu();
        menu.mainMenu();

    }

}