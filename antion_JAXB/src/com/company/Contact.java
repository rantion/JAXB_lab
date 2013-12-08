package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 12/7/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name ="contact", propOrder = {"name","email", "phone"})
public class Contact implements Serializable {
    @XmlAttribute(name = "name", required = true)
    private String name;
    @XmlAttribute(name = "email", required = true)
    private String email;
    @XmlAttribute(name = "phone", required = true)
    private String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        ContactList contactList = new ContactList();
    }

    public Contact(){

    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return ("Name: " + name + " Email: " + email + " Phone: " + phone);
    }
}

