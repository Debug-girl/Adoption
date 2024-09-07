package org.example.domain;

public abstract class Person {
    private int personID;
    private String username;
    private String password;

    // 构造函数

    public Person(int personID, String username, String password) {
        this.personID = personID;
        this.username = username;
        this.password = password;
    }

    public Person() {

    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}
