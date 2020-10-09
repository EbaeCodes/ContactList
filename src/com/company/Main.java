package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private  static  MobilePhone mobilePhone = new MobilePhone("17688154534");

    public static void main(String[] args) {


        boolean quit = false;
        int choice = 0;
        startPhone();
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addNewContact();
                    break;
                case 2:
                    updateContact();
                case 3:
                    removeContact();
                    break;

                case 4:
                    queryContact();
                    break;

                case 5:
                    printContact();
                    break;

                case 6:
                    quit = true;
                    break;
            }

        }
   }



   private static void queryContact() {
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name:"+existingContactRecord.getName()+"phone number is "+ existingContactRecord.getPhoneNumber());

    }



    private static  void removeContact() {
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted");
        }
        else{
            System.out.println("Error deleting contact");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number");
        String newNumber = scanner.nextLine();
        Contacts newContacts = Contacts.createContacts(newName,newNumber);
        if(mobilePhone.updateContact(existingContactRecord,newContacts)){
            System.out.println("successfully updated record");
        }
     else {
            System.out.println("Error updating record");
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContacts(name, phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added "+ name + ",Phone"+ phone);
        }else{
            System.out.println("Cannot add" + name + "already phone...");
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone.......");
    }
    private static void printContact() {
        mobilePhone.printContacts();
    }



    private static void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - To print the choice options");
        System.out.println("\t 1 - To add contact to the  List");
        System.out.println("\t 2 - To update existing contact");
        System.out.println("\t 3 - To remove contact from the contact List");
        System.out.println("\t 4 - To find a contact in the contact List");
        System.out.println("\t 5 - To print the contact List");
        System.out.println("\t 6 - To Quit");
        System.out.println("Choose Your Actions");


    }
}
