package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 12/7/13
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuPanel extends JPanel {

    private JButton seeAll, seeSpecific, enterNew;
    private ContactManager manager;

    public MenuPanel(ContactManager manager) {
        this.setLayout(new GridLayout(3, 0));
        this.setSize(500, 500);
        this.manager = manager;
        ButtonHandler handler = new ButtonHandler();

        seeAll = new JButton("See All Contacts");
        this.add(seeAll);
        seeAll.setVisible(true);
        seeAll.addActionListener(handler);

        seeSpecific = new JButton("See Specific Contact");
        this.add(seeSpecific);
        seeSpecific.setVisible(true);
        seeSpecific.addActionListener(handler);

        enterNew = new JButton("Enter New Contact");
        this.add(enterNew);
        enterNew.setVisible(true);
        enterNew.addActionListener(handler);


    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == seeAll) {
                manager.changeViewAll();
            }
            if (e.getSource() == seeSpecific) {
                manager.changeViewOne();
            }
            if (e.getSource() == enterNew) {
                manager.changeToAddContact();
            }
        }
    }
}
