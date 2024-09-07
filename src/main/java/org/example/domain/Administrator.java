package org.example.domain;

import java.util.ArrayList;

public class Administrator extends Person{

    public Administrator(int id, String username, String password) {
        super(id, username, password);
    }

    Administrator(){
        super();
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
