package org.example;

import org.example.controller.Menu;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {

        Menu menu = new Menu();
        menu.mainMenu();

    }

}