package com.company;

import javax.swing.*;
import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) throws JAXBException {

        Contact contact = new Contact("Bob", "bob@bobsemail.com", "123-456-7890");
        ContactList contactList = new ContactList();
        contactList.addContact(contact);
        Contact contact1 = new Contact("Joe", "joe@joesemail.com", "098-765-4321");
        contactList.addContact(contact1);
        contactList.unMarshaling();
        try {
            contactList.marshaling();
        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        contactList.unMarshaling();


        ContactManager contactManager = new ContactManager(contactList);
        contactManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contactManager.setSize(500, 500);
        contactManager.setVisible(true);
    }


}