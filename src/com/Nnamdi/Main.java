package com.Nnamdi;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        // write your code here
        // Write your code between here...
        AgileOrWaterFall survey = new AgileOrWaterFall();
        //Create a frame - the GUI window
        JFrame AgileOrWaterFallFrame = new JFrame("AgileOrWaterFall");
        //configure the JFrame / GUI window
        AgileOrWaterFallFrame.setSize(700, 200);
        AgileOrWaterFallFrame.setVisible(true);
        AgileOrWaterFallFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AgileOrWaterFallFrame.setBackground(Color.blue);
        //Create an object from this class - it's a JPanel,  which is a GUI component
        AgileOrWaterFall surveyGUI = new AgileOrWaterFall();

        //And add it to the JFrame
        AgileOrWaterFallFrame.add(surveyGUI);


    }
}

