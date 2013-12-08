package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 12/7/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ContactList")
public class ContactList implements Serializable {
    @XmlElement(type = Contact.class)
    public List<Contact> contacts;


    public ContactList() {
        contacts = new ArrayList<Contact>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact Added");
    }

    public void printContacts() {
        int index = 0;
        for (Contact c : contacts) {
            System.out.println(index + " - " + c.getName());
            index++;
        }
    }

    public Contact viewContact(int index) {
        return contacts.get(index);

    }

    public void printContact(Contact contactToPrint) {
        System.out.println("\nName: " + contactToPrint.getName()
                + "\nEmail: " + contactToPrint.getEmail()
                + "\nPhone: " + contactToPrint.getPhone() + "\n");


    }

    public void marshaling() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(ContactList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(this, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(this, new File("/Users/Rachel/Documents/contacts.xml"));
    }

    public void unMarshaling() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(ContactList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        ContactList _contacts = (ContactList) jaxbUnmarshaller.unmarshal( new File("/Users/Rachel/Documents/contacts.xml") );

        for(Contact con : _contacts.getContacts())
        {
            System.out.println("Name: "+con.getName());
            System.out.println("Phone: "+con.getPhone());
            System.out.println("Email: "+con.getEmail());
        }
    }



}
