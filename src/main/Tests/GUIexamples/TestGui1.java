package main.Tests.GUIexamples;//Import packages

import javax.swing.*;
import java.awt.*;

//Main class
public class TestGui1{
    //Declare variables
    static JFrame frame1;
    static Container pane;
    static JButton btnConnect, btnDisconnect;
    static JLabel lblServer, lblUsername, lblPassword, lblPort;
    static JTextField txtServer, txtUsername, txtPassword, txtPort;
    static Insets insets;

    public static void main (String args[]){
        //Create the frame
        frame1 = new JFrame ("Sample GUI Application");
        //Set its size to 800x200 pixels
        frame1.setSize (800,200);
        //Prepare panel
        pane = frame1.getContentPane();
        insets = pane.getInsets();
        //Apply the null layout
        pane.setLayout (null);
    }
}
