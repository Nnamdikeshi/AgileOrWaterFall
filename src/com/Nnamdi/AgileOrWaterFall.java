package com.Nnamdi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by nc0614dn on 10/25/2016.
 */
public class AgileOrWaterFall extends JPanel {
    private JTextField projectName;
    private JCheckBox experienceCheckBox;
    private JCheckBox earlyIntegrationCheckBox;
    private JCheckBox earlyWorkingModelCheckBox;
    private JCheckBox deadLineCheckBox;
    private JButton recommendButton;
    private JLabel recommendLabel;
    private JButton quitButton;
    private JLabel projectNameLabel;
    private JLabel teamSize;
    private JTextField teamSizeNum;

    private boolean experience, earlyIntegration, earlyWorkingModel, deadLine;
    private int sizeNum;

    AgileOrWaterFall() {
        projectNameLabel = new JLabel("Enter the project's name");
        teamSize = new JLabel("Team Size: ");
        teamSizeNum = new JTextField();
        projectName = new JTextField();
        experienceCheckBox = new JCheckBox("Do the programmers have experience in requirements, design, testing and integration?");
        earlyIntegrationCheckBox = new JCheckBox("Is early integration of components desired?");
        earlyWorkingModelCheckBox = new JCheckBox("Does the customer require a working model or prototype early on?");
        deadLineCheckBox = new JCheckBox("Are there fixed schedules, milestones and deadlines?");

        recommendButton = new JButton("Recommend");
        recommendLabel = new JLabel("Recommendation here");

        quitButton = new JButton("Quit");

        add(projectName);
        add(projectNameLabel);
        add(teamSize);
        add(teamSizeNum);
        add(experienceCheckBox);
        add(earlyIntegrationCheckBox);
        add(earlyWorkingModelCheckBox);
        add(deadLineCheckBox);
        add(recommendLabel);
        add(recommendButton);
        add(quitButton);

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Show 'are you sure' dialog box
                int quit = JOptionPane.showConfirmDialog(AgileOrWaterFall.this,
                        "Are you sure you want to quit?", "Quit?",
                        JOptionPane.OK_CANCEL_OPTION);

                //Check which option user selected, quit if user clicked ok
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        deadLineCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                deadLine = deadLineCheckBox.isSelected();
                agileResults();
            }
        });
        experienceCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                experience = experienceCheckBox.isSelected();
                agileResults();
            }
        });
        earlyIntegrationCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                earlyIntegration = earlyIntegrationCheckBox.isSelected();
                agileResults();
            }
        });
        earlyWorkingModelCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                earlyWorkingModel = earlyWorkingModelCheckBox.isSelected();
                agileResults();
            }
        });
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projName = projectName.getText();
                projectNameLabel.setText("Project Name: " + projName);
                int sizeNum = teamSizeNum.getColumns();
                teamSize.setText("Team Size: " + sizeNum);
                recommendLabel.setText(agileResults());

            }
        });
    }
        private String agileResults() {
            String projName = projectName.getText();
            String agileResult = "For '" + projName + "', Agile may be better";
            String waterfallResult = "For '" + projName + "', Waterfall may be better";
            String indecisiveResult = "Unable to suggest a methodology for '" + projName + "' .";

            int pointsInFavorOfAgile = 0;


            //Examine the factors. Add points for factors that favor Agile, subtract points for factors that favor waterfall


            //Agile is best for smaller teams.
            if (sizeNum < 30) {
                pointsInFavorOfAgile++;
            } else if (sizeNum < 80) {
                // indecisive - do nothing
            } else {
                pointsInFavorOfAgile--;
            }

            //Waterfall is designed for projects with fixed schedules, milestones, and deadlines

            if (deadLine) {
                pointsInFavorOfAgile--;
            } else {
                pointsInFavorOfAgile++;
            }

            //Agile requires programmers who have experience in design, integration, and testing, as well as coding

            if (experience) {
                pointsInFavorOfAgile++;
            } else {
                pointsInFavorOfAgile--;
            }


            //A benefit of Agile is early integration of components
            if (earlyIntegration) {
                pointsInFavorOfAgile++;
            } else {
                pointsInFavorOfAgile--;
            }


            // Another benefit of Agile is having an early working prototype
            if (earlyWorkingModel) {
                pointsInFavorOfAgile++;
            } else {
                pointsInFavorOfAgile--;
            }

        /*
        //Alternatively, you can write these if statements using the ternary operator and save some code, at the expense of clarity
        //This checks the earlyIntegration boolean and sets pointsInFavorOfAgile based on the value
        pointsInFavorOfAgile = (earlyWorkingModels) ? pointsInFavorOfAgile + 1 : pointsInFavorOfAgile - 1;
        */

            //Look at the points for Agile, and use that to return a String with a suggestion.

            if (pointsInFavorOfAgile > 0) {
                return agileResult;
            } else if (pointsInFavorOfAgile == 0) {
                return indecisiveResult;
            } else {
                return waterfallResult;
            }




        }
    }


