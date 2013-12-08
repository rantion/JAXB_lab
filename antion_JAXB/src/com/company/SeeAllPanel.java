package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 12/7/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeeAllPanel extends JPanel {
    private JTextArea allContacts;
    private ContactList list;
    private ContactManager manager;
    private int refNum;
    private JButton returnToMenu;
    private List<Contact> contacts = new ArrayList<Contact>();

    public SeeAllPanel(ContactList list, ContactManager manager) {
        refNum = 0;
        this.list = list;
        this.manager = manager;
        this.setSize(500, 5000);
        ButtonHandler handler = new ButtonHandler();
        setLayout(new GridLayout(0, 1));
        contacts = list.getContacts();
        allContacts = new JTextArea();

        allContacts.append("All Contacts \n\n");
        Iterator<Contact> contactList = contacts.iterator();
        while (contactList.hasNext()) {
            allContacts.append(refNum + ") " + contactList.next().toString() + "\n");
            refNum++;
        }
        this.add(allContacts);
        this.setVisible(true);

        returnToMenu = new JButton("Return to Menu");
        this.add(returnToMenu);
        returnToMenu.setVisible(true);
        returnToMenu.addActionListener(handler);

    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == returnToMenu) {
                manager.returnToMenu();
            }
        }
    }
}
