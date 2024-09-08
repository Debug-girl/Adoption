package org.example;

import org.example.controller.Menu;
import org.example.dao.adoptionrecord.AdoptionRecordDaoImpl;
import org.example.dao.adoptionrecord.IAdoptionRecordDao;
import org.example.domain.AdoptionRecord;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void try_test(){
        IAdoptionRecordDao adoptionRecordDao = new AdoptionRecordDaoImpl();

        adoptionRecordDao.addAdoptionRecord(1,1,"领养", LocalDate.now());

        for(AdoptionRecord adoptionRecord : adoptionRecordDao.getAllRecords()){
            System.out.println(adoptionRecord.toString());
        }
    }

    public static void main(String[] args) throws SQLException {
        try_test();

        Menu menu = new Menu();
        menu.mainMenu();

    }

}