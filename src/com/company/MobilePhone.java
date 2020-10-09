package com.company;


import java.util.ArrayList;


//the logic behind the methods called external
//a public class mobile phone
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    //the constructor of variables
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    //a method that add new contacts and phone number to the arraylist of contacts
    public boolean addNewContact(Contacts contacts) {
        // this checks if the contacts already exists in the arraylist
        if (findContact(contacts.getName()) >= 0) {
            System.out.println("Contact is already on File");
            return false;
        }
        //this function adds the name and phone number into the arraylist
        myContacts.add(contacts);
        return true;
    }


     // this method changes the name and phone number to a new name and number
    //it accepts two parameter the existing contact and the one to be set to
    public boolean updateContact(Contacts oldContacts, Contacts newContacts) {
        //assign the existing contact to found position variable
        int foundPosition = findContact(oldContacts);
        //check if the contact exists in the arraylist firstly
        if (foundPosition < 0) {
            System.out.println(oldContacts.getName() + ",was not found.");
            return false;
        }
        // this checks if the name to upadate already exists in the contact list
            else if(findContact(newContacts.getName()) != -1){
            System.out.println("contact with the name"+ newContacts.getName()+"  already eixts in the contact" +
                    "update was not successful");
                     return  false;

            }

        //we set the existing contact to the new contact coolected from the user
        this.myContacts.set(foundPosition, newContacts);
        System.out.println(oldContacts.getName() + ", was replaced with" + newContacts.getName());
        return true;
    }


    //this method removes the contact from the arraylist
    public boolean removeContact(Contacts contacts) {
        //this checks if the contact exists or not in the arraylist
        int foundPosition = findContact(contacts);
        if (foundPosition < 0) {
            System.out.println(contacts.getName() + ",was not found");
            return false;
        }
        //this function is called to remove the contact passed which was
        //assigned to found position
        this.myContacts.remove(foundPosition);
        System.out.println(contacts.getName() + ",was deleted");
        return true;
    }


    //this method checks if the contact exist or not
    // by passing the contact
    private int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }



    //this method checks if the string name passed exists or not
    //
    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contacts contacts = this.myContacts.get(i);
            if (contacts.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;

    }

    // We create a method that takes a string and return the entire contacts ie the name and phone number
    //of that existing name
    public Contacts queryContact(String name) {
        //this loops through the contacts to find the name passed if it exists in
        //the contact list
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    // this method checks if the contact inserted exists
    public String queryContact(Contacts contacts) {
        if (findContact(contacts) >= 0) {
            return contacts.getName();
        }
        return null;
    }

 // this loops through the arraylist to print the contact name and contact phone number

    public void printContacts() {
        System.out.println("Contact list");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + " " +
                    this.myContacts.get(i).getName() + "=>" +
                    this.myContacts.get(i).getPhoneNumber()

            );

        }
    }
}
