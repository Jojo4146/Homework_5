package cop2805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Homework 5
 * Class: COP 2805C Advanced Java Programming <br/>
 * Instructor: Brian Williamson <br/>
 * Description: Building Simple GUI Calculator<br/>
 * Due: 2/20/2022
 * Author: Johanna I. Scharbaai-Emilien
 * I pledge that I have completed the programming assignment independently. <br />
 * I have not copied the code from a student or any source. <br />
 * I have not given my code to any student. <br />
 * Sign here: ___Johanna I. Scharbaai-Emilien_______ <br />
 */
public class Homework_5 {

    private static JTextField value1, value2;
    private static JComboBox<String> cb;
    private static int choice;
    private static double num1, num2, result = 0.0;

    public static void main(String[] args) {
        // Creates special thread to handle events with the GUI
        // while calling constructGUI method
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                constructGUI();
            }
        });
        setLookAndFeel();
    }

    private static void constructGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        // Set the title
        frame.setTitle("Simple Calculator");
        // Shut down program on clicking corner X
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a grid, sets the columns and rows
        frame.setLayout(new GridLayout(5, 2));
        
        // First Row (First Number) components
        // First Label for 'First Number'
        JLabel fNum = new JLabel("First Number: ");
        frame.add(fNum);
        // Value Text field
        value1 = new JTextField();
        // Setting Focus listener
        value1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    num1 = Double.parseDouble(value1.getText());
                } catch (NumberFormatException nfe){
                    value1.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent event) {

                focusGained(event);
            }
        });
        frame.add(value1);

        // Second Row (Second Number)
        // Label for 'Second Number'
        JLabel sNum = new JLabel("Second Number: ");
        frame.add(sNum);
        // Second value text field
        value2 = new JTextField();
        // Setting event listener
        value2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                try {
                    num2 = Double.parseDouble(value2.getText());
                } catch (NumberFormatException nfe){
                    value2.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent event) {

                focusGained(event);
            }
        });
        frame.add(value2);

        // Third Row (Combo Box)
        // Empty frame
        frame.add(new JLabel());
        // Array for combo box values
        String[] operators = { "Add", "Subtract", "Multiply", "Divide" };  // Start of JComboBox
        cb = new JComboBox<>(operators);    // creation of combo box
        // Default is set to adding (index 0)
        cb.setSelectedIndex(0);
        // Setting item listener for combo box
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event.getStateChange() == ItemEvent.SELECTED ) {
                    // In the event, the index of the array will be selected
                    choice = cb.getSelectedIndex();     // choice = index in array
                }
            }
        });
        frame.add(cb);

        // Fourth Row (Calculate Button)
        // Empty frame
        frame.add(new JLabel());
        // Creation of the 'Calculate' button
        JButton button = new JButton("Calculate");
        frame.add(button);
        // Setting Action listener event
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // The switch statement
                switch (choice) {   // choice = index in the array from 0 to 3
                    case 0:
                        // addition
                        result = num1 + num2;
                        break;
                    case 1:
                        // subtraction
                        result = num1 - num2;
                        break;
                    case 2:
                        // multiplication
                        result = num1 * num2;
                        break;
                    case 3:
                        // division
                        result = num1 / num2;
                        break;
                    default:
                }
                // Check calculator results in the console
                System.out.println(result);
            }
        });
        // Set pane background color
        frame.getContentPane().setBackground(Color.cyan);

        // Fifth and last Row (Result)
        frame.add(new JLabel("Result: " + result));

        // Set width & height of box
        frame.setSize(300,150);
        // Set point relative to screen
        frame.setBounds(500, 400, 300, 150);
        frame.setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
           //System.out.println(exc.getMessage());
        }
    }
}
