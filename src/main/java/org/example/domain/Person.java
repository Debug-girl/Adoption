package org.example.domain;

public abstract class Person {

    protected int id;
    protected String name;
    protected String password;

    public Person(int id,String username, String password) {
        this.id = id;
        this.name = username;
        this.password = password;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
