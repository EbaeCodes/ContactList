package com.company;

public class Contacts {

    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public Contacts(){}


    public String getName() {
        return name;
    }


    public static  Contacts createContacts(String name, String phoneNumber){
        return new Contacts(name,phoneNumber);
    }

    public String  getPhoneNumber(){
        return phoneNumber;
    }
}
