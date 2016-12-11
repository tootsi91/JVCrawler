package main.Tests.GUIexamples;
/*
   In this applet, the user can type in two real numbers.  The
   user can click on buttons labled +, - , *, and / to perform
   basic arithmetic operations on the numbers.  When the user
   clicks on a button the answer is displayed.  The applet
   should be about 200 by 120 pixels.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JApplet implements ActionListener {

    JTextField xInput, yInput;  // Input boxes for the numbers.

    JLabel answer;  // JLabel for displaying the answer, or an
    //    error message if appropriate.


    public void init() {

      /* Since I will be using the content pane several times,
         declare a variable to represent it.  Note that the
         return type of getContentPane() is Container. */

        Container content = getContentPane();

      /* Assign a background color to the applet and its
         content panel.  This color will show through between
         components and around the edges of the applet. */

        setBackground(Color.gray);
        content.setBackground(Color.gray);

      /* Create the input boxes, and make sure that the background
         color is white.  (They are likely to be white by default.) */

        xInput = new JTextField("0");
        xInput.setBackground(Color.white);
        yInput = new JTextField("0");
        yInput.setBackground(Color.white);

      /* Create panels to hold the input boxes and labels "x =" and
         "y = ".  By using a BorderLayout with the TextField in the
         Center position, the TextField will take up all the space
         left after the label is given its preferred size. */

        JPanel xPanel = new JPanel();
        xPanel.setLayout(new BorderLayout());
        xPanel.add( new Label(" x = "), BorderLayout.WEST );
        xPanel.add(xInput, BorderLayout.CENTER);

        JPanel yPanel = new JPanel();
        yPanel.setLayout(new BorderLayout());
        yPanel.add( new Label(" y = "), BorderLayout.WEST );
        yPanel.add(yInput, BorderLayout.CENTER);

      /* Create a panel to hold the four buttons for the four
         operations.  A GridLayout is used so that the buttons
         will all have the same size and will fill the panel.
         The applet servers as ActionListener for the buttons. */

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,4));

        JButton plus = new JButton("+");
        plus.addActionListener(this);
        buttonPanel.add(plus);

        JButton minus = new JButton("-");
        minus.addActionListener(this);
        buttonPanel.add(minus);

        JButton times = new JButton("*");
        times.addActionListener(this);
        buttonPanel.add(times);

        JButton divide = new JButton("/");
        divide.addActionListener(this);
        buttonPanel.add(divide);

      /* Create the label for displaying the answer in red
         on a white background.  The label is set to be
         "opaque" to make sure that the white background
         is painted. */

        answer = new JLabel("x + y = 0", JLabel.CENTER);
        answer.setForeground(Color.red);
        answer.setBackground(Color.white);
        answer.setOpaque(true);

      /* Set up the layout for the applet, using a GridLayout,
          and add all the components that have been created. */

        content.setLayout(new GridLayout(4,1,2,2));
        content.add(xPanel);
        content.add(yPanel);
        content.add(buttonPanel);
        content.add(answer);

      /* Try to give the input focus to xInput, which is the natural
         place for the user to start. */

        xInput.requestFocus();

    }  // end init()


    public Insets getInsets() {
        // Leave some space around the borders of the applet.
        return new Insets(2,2,2,2);
    }


    public void actionPerformed(ActionEvent evt) {
        // When the user clicks a button, get the numbers
        // from the input boxes and perform the operation
        // indicated by the button.  Put the result in
        // the answer label.  If an error occurs, an
        // error message is put in the label.

        double x, y;  // The numbers from the input boxes.

      /* Get a number from the xInput TextField.  Use
         xInput.getText() to get its contents as a String.
         Convert this String to a double.  The try...catch
         statement will check for errors in the String.  If
         the string is not a legal number, the error message
         "Illegal data for x." is put into the answer and
         the actionPerformed() method ends. */

        try {
            String xStr = xInput.getText();
            x = Double.parseDouble(xStr);
        }
        catch (NumberFormatException e) {
            // The string xStr is not a legal number.
            answer.setText("Illegal data for x.");
            return;
        }

      /* Get a number from yInput in the same way. */

        try {
            String yStr = yInput.getText();
            y = Double.parseDouble(yStr);
        }
        catch (NumberFormatException e) {
            answer.setText("Illegal data for y.");
            return;
        }

      /* Perfrom the operation based on the action command
         from the button.  Note that division by zero produces
         an error message. */

        String op = evt.getActionCommand();
        if (op.equals("+"))
            answer.setText( "x + y = " + (x+y) );
        else if (op.equals("-"))
            answer.setText( "x - y = " + (x-y) );
        else if (op.equals("*"))
            answer.setText( "x * y = " + (x*y) );
        else if (op.equals("/")) {
            if (y == 0)
                answer.setText("Can't divide by zero!");
            else
                answer.setText( "x / y = " + (x/y) );
        }

    } // end actionPerformed()


}  // end class SimpleCalculator
