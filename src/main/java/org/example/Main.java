package org.example;

import org.example.controller.Menu;
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

        Menu menu = new Menu();
        menu.mainMenu();

    }

}