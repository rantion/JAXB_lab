package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 12/7/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactManager extends JFrame {

    private JPanel menuPan, addOnePan, seeOnePan, seeAllPan;
    private ContactList list;

    public ContactManager(ContactList list) {
        super("Contact Management System");
        setLayout(new GridLayout());
        this.setSize(500, 500);
        this.list = list;

        menuPan = new MenuPanel(this);
        addOnePan = new EnterNewPanel(list, this);
        seeOnePan = new SeeSpecificPanel(list, this);
        seeAllPan = new SeeAllPanel(list, this);
        this.getContentPane().add(menuPan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void changeToAddContact() {
        this.setContentPane(addOnePan);
        this.pack();
        this.setSize(500, 500);
        this.setVisible(true);
    }

    public void changeViewAll() {
        this.setContentPane(new SeeAllPanel(list, this));
        this.pack();
        this.setSize(500, 500);
        this.setVisible(true);
    }

    public void changeViewOne() {
        this.setContentPane(seeOnePan);
        this.pack();
        this.setSize(500, 500);
        this.setVisible(true);
    }


    public void returnToMenu() {
        this.setContentPane(menuPan);
        this.pack();
        this.setVisible(true);
    }
}
