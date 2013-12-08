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
public class SeeSpecificPanel extends JPanel {
    private JButton returnToMenu, seeContact;
    private JLabel nameLabel, phoneLabel, emailLabel, filler;
    private JTextArea enterContactLabel;
    private JTextField name, phone, email, enterContact;
    private ContactList list;
    private ContactManager manager;

    public SeeSpecificPanel(ContactList list, ContactManager manager) {
        this.list = list;
        this.manager = manager;
        ButtonHandler handler = new ButtonHandler();
        setLayout(new GridLayout(0, 2));

        enterContactLabel = new JTextArea("Enter the number of desired contact");
        enterContactLabel.setLineWrap(true);
        this.add(enterContactLabel);
        enterContactLabel.setVisible(true);

        filler = new JLabel("");
        this.add(filler);
        filler.setVisible(true);

        enterContact = new JTextField(10);
        this.add(enterContact);
        enterContact.setVisible(true);

        seeContact = new JButton("View Contact");
        this.add(seeContact);
        seeContact.setVisible(true);
        seeContact.addActionListener(handler);


        nameLabel = new JLabel("Name: ");
        this.add(nameLabel);
        nameLabel.setVisible(false);

        name = new JTextField(10);
        this.add(name);
        name.setVisible(false);

        phoneLabel = new JLabel("Phone : ");
        this.add(phoneLabel);
        phoneLabel.setVisible(false);

        phone = new JTextField(10);
        this.add(phone);
        phone.setVisible(false);

        emailLabel = new JLabel("Email: ");
        this.add(emailLabel);
        emailLabel.setVisible(false);

        email = new JTextField(10);
        this.add(email);
        email.setVisible(false);

        returnToMenu = new JButton("Return to Menu");
        this.add(returnToMenu);
        returnToMenu.setVisible(true);
        returnToMenu.addActionListener(handler);

    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == seeContact) {
                try {
                    String ref = enterContact.getText();
                    int refNum = Integer.parseInt(ref);
                    Contact contact = list.viewContact(refNum);

                    name.setText(contact.getName());
                    email.setText(contact.getEmail());
                    phone.setText(contact.getPhone());

                    nameLabel.setVisible(true);
                    name.setVisible(true);
                    email.setVisible(true);
                    emailLabel.setVisible(true);
                    phone.setVisible(true);
                    phoneLabel.setVisible(true);
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(null, "Please Enter A Valid Number");
                }
            }

            if (e.getSource() == returnToMenu) {
                manager.returnToMenu();
            }
        }
    }
}
