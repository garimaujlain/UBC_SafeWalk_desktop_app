/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package ui;

import model.Scheduler;
import model.User;
import model.Volunteer;
import org.json.JSONException;
import persistence.SchedulerJsonReader;
import persistence.SchedulerJsonWriter;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


//code for GUI for safewalk Application
public class MainFrame extends javax.swing.JFrame {



    String type;
    Volunteer volunteer;
    Scheduler scheduler;
    User user;

    // Creates new form MainFrame
    public MainFrame() {
        volunteer = new Volunteer();
        scheduler = new Scheduler();
        user = new User();
        initComponents();
        startpanel.setVisible(false);
        pickvolpanel.setVisible(false);

    }



    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings", "checkstyle:LineLength"})
    private void initComponents() {

        diag = new javax.swing.JDialog();
        modifnamebtn = new javax.swing.JButton();
        modifagebtn = new javax.swing.JButton();
        modifgenderbtn = new javax.swing.JButton();
        adddaybtn = new javax.swing.JButton();
        remdaybtn = new javax.swing.JButton();
        returnbtn = new javax.swing.JButton();
        jlabel1 = new javax.swing.JLabel();
        volbtn = new javax.swing.JButton();
        clibtn = new javax.swing.JButton();
        loadbtn = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        startpanel = new javax.swing.JPanel();
        jlabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jlabel3 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jlabel4 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        availabvar = new javax.swing.JLabel();
        savevolbtn = new javax.swing.JButton();
        daysgrp = new javax.swing.JPanel();
        sundaycheck = new javax.swing.JCheckBox();
        thursdaycheck = new javax.swing.JCheckBox();
        fridaycheck = new javax.swing.JCheckBox();
        mondaycheck = new javax.swing.JCheckBox();
        tuesdaycheck = new javax.swing.JCheckBox();
        wednesdaycheck = new javax.swing.JCheckBox();
        saturdaycheck = new javax.swing.JCheckBox();
        days = new javax.swing.JComboBox<>();
        pickvolpanel = new javax.swing.JPanel();
        jlabel5 = new javax.swing.JLabel();
        jscrollpane1 = new javax.swing.JScrollPane();
        volunteerlist = new javax.swing.JList<>();
        pickvol = new javax.swing.JButton();
        jbutton1 = new javax.swing.JButton();

        diag.setMinimumSize(new java.awt.Dimension(595, 363));
        diag.setResizable(false);

        //modify name
        modifnamebtn.setText("Modify Name");
        modifnamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifnamebtnActionPerformed(evt);
            }
        });

        //modify gender
        modifagebtn.setText("Modify Age");
        modifagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifagebtnActionPerformed(evt);
            }
        });

        //to modufy age
        modifgenderbtn.setText("Modify Gender");
        modifgenderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifgenderbtnActionPerformed(evt);
            }
        });

        //to add day to schedule
        adddaybtn.setText("Add  available day");
        adddaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adddaybtnActionPerformed(evt);
            }
        });

        //to remove day from schedule
        remdaybtn.setText("Remove available day");
        remdaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remdaybtnActionPerformed(evt);
            }
        });

        //to return to main menu
        returnbtn.setText("Return to main menu");
        returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diagLayout = new javax.swing.GroupLayout(diag.getContentPane());
        diag.getContentPane().setLayout(diagLayout);
        diagLayout.setHorizontalGroup(
                diagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diagLayout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addGroup(diagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(returnbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(remdaybtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(adddaybtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(modifgenderbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(modifagebtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(modifnamebtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(239, 239, 239))
        );
        diagLayout.setVerticalGroup(
                diagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(diagLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(modifnamebtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modifagebtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modifgenderbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adddaybtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(remdaybtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(returnbtn)
                                .addContainerGap(104, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jlabel1.setText("Welcome To SafeWalk!");

        //to start as new volunteer
        volbtn.setText("Start As a new Volunteer");
        volbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volbtnActionPerformed(evt);
            }
        });

        //to start as a client
        clibtn.setText("Start As a Client");
        clibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clibtnActionPerformed(evt);
            }
        });

        //to load the app
        loadbtn.setText("Load App");
        loadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadbtnActionPerformed(evt);
            }
        });


        //to save the app
        savebtn.setText("Save App");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });


        //to exit the app
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        jlabel2.setText("Your Name:");

        jlabel3.setText("Your Age :");

        jlabel4.setText("Your Gender:");

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Male", "Female", "NA"}));

        availabvar.setText("Your Availability:");

        //saves list of volunteers to temp.json
        savevolbtn.setText("Save");
        savevolbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savevolbtnActionPerformed(evt);
            }
        });

        sundaycheck.setText("Sunday");

        thursdaycheck.setText("Thursday");

        fridaycheck.setText("Friday");

        //check for days of availability
        mondaycheck.setText("Monday");
        mondaycheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mondaycheckActionPerformed(evt);
            }
        });

        tuesdaycheck.setText("Tuesday");

        wednesdaycheck.setText("Wednesday");

        saturdaycheck.setText("Saturday");

        //check all days of availability
        javax.swing.GroupLayout daysgrpLayout = new javax.swing.GroupLayout(daysgrp);
        daysgrp.setLayout(daysgrpLayout);
        daysgrpLayout.setHorizontalGroup(
                daysgrpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(daysgrpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(daysgrpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(wednesdaycheck)
                                        .addComponent(fridaycheck)
                                        .addComponent(thursdaycheck)
                                        .addGroup(daysgrpLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(daysgrpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sundaycheck)
                                                        .addComponent(saturdaycheck)))
                                        .addGroup(daysgrpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(mondaycheck)
                                                .addComponent(tuesdaycheck)))
                                .addContainerGap(121, Short.MAX_VALUE))
        );
        daysgrpLayout.setVerticalGroup(
                daysgrpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(daysgrpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mondaycheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tuesdaycheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wednesdaycheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thursdaycheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fridaycheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saturdaycheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sundaycheck)
                                .addContainerGap())
        );

        days.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));

        javax.swing.GroupLayout startpanelLayout = new javax.swing.GroupLayout(startpanel);
        startpanel.setLayout(startpanelLayout);
        startpanelLayout.setHorizontalGroup(
                startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(startpanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlabel2)
                                        .addComponent(jlabel3)
                                        .addComponent(jlabel4)
                                        .addComponent(availabvar))
                                .addGap(45, 45, 45)
                                .addGroup(startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(name)
                                                .addComponent(age)
                                                .addComponent(gender, 0, 165, Short.MAX_VALUE))
                                        .addGroup(startpanelLayout.createSequentialGroup()
                                                .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(daysgrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(startpanelLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(savevolbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        startpanelLayout.setVerticalGroup(
                startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(startpanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel2)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel3)
                                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel4)
                                        .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(startpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(availabvar)
                                                .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(daysgrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(savevolbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        jlabel5.setText("Pick a Volunteer :");

        //shows available list of volunteers
        jscrollpane1.setViewportView(volunteerlist);

        //picks one volunteer from list
        pickvol.setText("Pick Selected Volunteer");
        pickvol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickvolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pickvolpanelLayout = new javax.swing.GroupLayout(pickvolpanel);
        pickvolpanel.setLayout(pickvolpanelLayout);
        pickvolpanelLayout.setHorizontalGroup(
                pickvolpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pickvolpanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(pickvolpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlabel5)
                                        .addGroup(pickvolpanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(pickvolpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(pickvolpanelLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(pickvol))
                                                        .addComponent(jscrollpane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(147, Short.MAX_VALUE))
        );
        pickvolpanelLayout.setVerticalGroup(
                pickvolpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pickvolpanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jlabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jscrollpane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pickvol)
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        //to start as current volunteer
        jbutton1.setText("Start as an existing Volunteer");
        jbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton1Actionperformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(282, 282, 282)
                                                .addComponent(jlabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(savebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(loadbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(clibtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(volbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jbutton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(163, 163, 163)
                                                .addComponent(startpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pickvolpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jlabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(volbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(clibtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(loadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(startpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(pickvolpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }




    //new volunteer
    private void volbtnActionPerformed(java.awt.event.ActionEvent evt) {

        type = "V";
        startpanel.setVisible(true);
        daysgrp.setVisible(true);
        days.setVisible(false);
        availabvar.setText("Your Availability:");

    }



    //to exit app
    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {
        //GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }


    private void mondaycheckActionPerformed(java.awt.event.ActionEvent evt) {



    }




    //new client

    private void clibtnActionPerformed(java.awt.event.ActionEvent evt) {

        type = "C";
        startpanel.setVisible(true);
        daysgrp.setVisible(false);
        days.setVisible(true);
        availabvar.setText("The day you need a Volunteer:");
    }


    public void clear() {
        name.setText("");
        age.setText("");

    }



    //availabilty of new volunteer, with information
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void savevolbtnActionPerformed(java.awt.event.ActionEvent evt) {

        startpanel.setVisible(false);
        DefaultListModel demoList = new DefaultListModel();

        if (type.equals("V")) {
            List<Boolean> temp = new ArrayList<>();
            if (mondaycheck.isSelected()) {

                temp.add(true);
            } else {
                temp.add(false);

            }
            if (tuesdaycheck.isSelected()) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            if (wednesdaycheck.isSelected()) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            if (thursdaycheck.isSelected()) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            if (fridaycheck.isSelected()) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            if (saturdaycheck.isSelected()) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            if (sundaycheck.isSelected()) {
                temp.add(true);
            } else {
                temp.add(false);
            }

            Volunteer x = new Volunteer(name.getText(),
                    Integer.parseInt(age.getText()), gender.getSelectedItem().toString(), temp);

            //the new volunteer is added to Volunteers (listOf volunteer)
            scheduler.addVolunteer(x);
            JOptionPane.showMessageDialog(this, "Congratulation! you have been added to our system"
                    + ". We are happy to have you on our team. Stay safe!");
            startpanel.setVisible(false);
        } else {

            JOptionPane.showMessageDialog(this, "Pick a volunteer from the list! ");
            List<String> temp = Scheduler.onDuty(days.getSelectedItem().toString());
            System.out.println(temp);
            startpanel.setVisible(false);
            for (int i = 0; i < temp.size(); i++) {
                demoList.add(i, temp.get(i));
            }
            volunteerlist.setModel(demoList);
            pickvolpanel.setVisible(true);

        }
        clear();
    }




    // save list of volunteers to json file when save is clicked
    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            SchedulerJsonWriter.write(scheduler, "./data/temp.json");
            System.out.println("Session saved!");
            JOptionPane.showMessageDialog(this, "Session saved!");

            System.exit(0);

        } catch (IOException e) {
            System.out.println("Error saving session");
            JOptionPane.showMessageDialog(this, "Error saving session");

        } catch (JSONException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    //load all volunteers from json file when clicked on load
    private void loadbtnActionPerformed(java.awt.event.ActionEvent evt) {
        //GEN-FIRST:event_loadbtnActionPerformed
        try {
            scheduler = SchedulerJsonReader.read("./data/temp.json");
            System.out.println("Session loaded");
            JOptionPane.showMessageDialog(this, "Session Loaded..");

        } catch (IOException e) {
            System.out.println("Error loading cookbook session");
            JOptionPane.showMessageDialog(this, "Error loading session");

        } catch (JSONException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    //display text of which volunteer you picked
    private void pickvolActionPerformed(java.awt.event.ActionEvent evt) {


        JOptionPane.showMessageDialog(this, "You have successfully been assigned to " + volunteerlist.getSelectedValue()
                + " please contact them on their cellphone number to further plan your travel!");

        pickvolpanel.setVisible(false);
    }



    private void jbutton1Actionperformed(java.awt.event.ActionEvent evt) {


        diag.setVisible(true);

    }



    //modifies name
    private void modifnamebtnActionPerformed(java.awt.event.ActionEvent evt) {


        String oldname = JOptionPane.showInputDialog("Please enter your old name:", "value1");
        Volunteer volunteer = Scheduler.findVolunteer(oldname);
        if (volunteer != null) {

            String newname = JOptionPane.showInputDialog("Please enter the corrected name:", "value1");
            Volunteer.newName(volunteer, newname);
            JOptionPane.showMessageDialog(this, "Name edited successfully");
            diag.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Name doesn't exist..");
            diag.dispose();

        }
    }



    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {


        diag.dispose();
    }



    //modifies age
    private void modifagebtnActionPerformed(java.awt.event.ActionEvent evt) {


        String oldname = JOptionPane.showInputDialog("Please enter your name:", "value1");
        Volunteer volunteer = Scheduler.findVolunteer(oldname);
        if (volunteer != null) {

            String newage = JOptionPane.showInputDialog("Please enter the corrected age:", "value1");
            Integer temp = Integer.valueOf(newage);
            Volunteer.newAge(volunteer, temp);
            JOptionPane.showMessageDialog(this, "Age edited successfully");
            diag.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Name doesn't exist..");
            diag.dispose();

        }
    }



    //modifies gender
    private void modifgenderbtnActionPerformed(java.awt.event.ActionEvent evt) {


        String oldname = JOptionPane.showInputDialog("Please enter your name:", "value1");
        Volunteer volunteer = Scheduler.findVolunteer(oldname);

        if (volunteer != null) {

            String newgender = JOptionPane.showInputDialog("Please enter the corrected gender:", "value1");
            String temp = newgender;

            Volunteer.newGender(volunteer, temp);
            JOptionPane.showMessageDialog(this, "Gender edited successfully");
            diag.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Name doesn't exist..");
            diag.dispose();

        }
    }


    //adds day of availabilty of volunteer
    private void adddaybtnActionPerformed(java.awt.event.ActionEvent evt) {

        //GEN-FIRST:event_adddaybtnActionPerformed
        String vname = JOptionPane.showInputDialog("Please enter your name:", "value1");
        Volunteer volunteer = Scheduler.findVolunteer(vname);
        if (volunteer != null) {
            String dayn = JOptionPane.showInputDialog("Please add the day of week you are available:", "value1");
            volunteer.addDay(volunteer, dayn);
            JOptionPane.showMessageDialog(this, "Shift added successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Name doesn't exist..");
            diag.dispose();

        }
    }


    //removes day of availabilty of volunteer
    private void remdaybtnActionPerformed(java.awt.event.ActionEvent evt) {



        String vname = JOptionPane.showInputDialog("Please enter your name:", "value1");
        Volunteer volunteer = Scheduler.findVolunteer(vname);
        if (volunteer != null) {
            String dayn = JOptionPane.showInputDialog("Please add the day of week you are not available:", "value1");
            Volunteer.deleteDay(volunteer, dayn);
            JOptionPane.showMessageDialog(this, "Shift deleted successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Name doesn't exist..");
            diag.dispose();

        }

    }



    // Variables declaration
    private javax.swing.JTextField age;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JTextField name;
    private javax.swing.JButton adddaybtn;
    private javax.swing.JLabel availabvar;
    private javax.swing.JButton clibtn;
    private javax.swing.JComboBox<String> days;
    private javax.swing.JPanel daysgrp;
    private javax.swing.JDialog diag;
    private javax.swing.JButton exitbtn;
    private javax.swing.JCheckBox fridaycheck;
    private javax.swing.JButton jbutton1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JScrollPane jscrollpane1;
    private javax.swing.JButton loadbtn;
    private javax.swing.JButton modifagebtn;
    private javax.swing.JButton modifgenderbtn;
    private javax.swing.JButton modifnamebtn;
    private javax.swing.JCheckBox mondaycheck;
    private javax.swing.JButton pickvol;
    private javax.swing.JPanel pickvolpanel;
    private javax.swing.JButton remdaybtn;
    private javax.swing.JButton returnbtn;
    private javax.swing.JCheckBox saturdaycheck;
    private javax.swing.JButton savebtn;
    private javax.swing.JButton savevolbtn;
    private javax.swing.JPanel startpanel;
    private javax.swing.JCheckBox sundaycheck;
    private javax.swing.JCheckBox thursdaycheck;
    private javax.swing.JCheckBox tuesdaycheck;
    private javax.swing.JButton volbtn;
    private javax.swing.JList<String> volunteerlist;
    private javax.swing.JCheckBox wednesdaycheck;

}