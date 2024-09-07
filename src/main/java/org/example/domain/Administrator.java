package org.example.domain;

public class Administrator extends Person{

    public Administrator(int id, String username, String password) {
        super(id, username, password);
    }

    public Administrator(){
        super();
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
