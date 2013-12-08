package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 12/7/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnterNewPanel extends JPanel {
    private JButton saveContact, returnToMenu;
    private JLabel nameLabel, phoneLabel, emailLabel;
    private JTextField name, phone, email;
    private ContactList list;
    private ContactManager manager;


    public EnterNewPanel(ContactList list, ContactManager manager) {
        this.list = list;
        this.manager = manager;
        ButtonHandler handler = new ButtonHandler();
        setLayout(new GridLayout(0, 2));

        nameLabel = new JLabel("Name: ");
        this.add(nameLabel);
        nameLabel.setVisible(true);

        name = new JTextField(10);
        this.add(name);
        name.setVisible(true);

        phoneLabel = new JLabel("Phone : ");
        this.add(phoneLabel);
        phoneLabel.setVisible(true);

        phone = new JTextField(10);
        this.add(phone);
        phone.setVisible(true);

        emailLabel = new JLabel("Email: ");
        this.add(emailLabel);
        emailLabel.setVisible(true);

        email = new JTextField(10);
        this.add(email);
        email.setVisible(true);

        saveContact = new JButton("Save Contact");
        this.add(saveContact);
        saveContact.setVisible(true);
        saveContact.addActionListener(handler);

        returnToMenu = new JButton("Return to Menu");
        this.add(returnToMenu);
        returnToMenu.setVisible(true);
        returnToMenu.addActionListener(handler);

    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == saveContact) {
                String _name = name.getText();
                String _email = email.getText();
                String _phone = phone.getText();

                Contact contact = new Contact(_name, _email, _phone);
                list.addContact(contact);
            }

            if (e.getSource() == returnToMenu) {
                manager.returnToMenu();
            }
        }
    }
}
