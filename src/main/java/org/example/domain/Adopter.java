package org.example.domain;

public class Adopter extends Person{

    private String address;

    public Adopter() {
        super();
    }

    public Adopter(int adopterID,String name,String password,String address) {
        super(adopterID,name,password);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "address='" + address + '\''+
                ", id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void disPlay(){
        System.out.println("用户ID:"+getId());
        System.out.println("用户姓名:"+getName());
        System.out.println("用户密码:"+getPassword());
        System.out.println("用户地址:"+getAddress());
        System.out.println();

    }
}
