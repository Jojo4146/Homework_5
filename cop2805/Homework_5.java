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
    private static double num1, num2, result;

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
        JLabel fNum = new JLabel("First Number: ");
        frame.add(fNum);
        value1 = new JTextField("0.0", 5);
        value1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    num1 = Double.parseDouble(value1.getText());
                } catch (NumberFormatException nfe){
                    value1.setText("0.0");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                focusGained(event);
            }
        });
        frame.add(value1);

        // Second Row (Second Number)
        JLabel sNum = new JLabel("Second Number: ");
        frame.add(sNum);
        value2 = new JTextField("0.0", 5);
        value2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                try {
                    num2 = Double.parseDouble(value2.getText());
                } catch (NumberFormatException nfe){
                    value2.setText("0.0");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                focusGained(event);
            }
        });
        frame.add(value2);

        // Third Row (Combo Box)
        frame.add(new JLabel());            // Empty frame
        String[] operators = { "Add", "Subtract", "Multiply", "Divide" };  // Start of JComboBox
        cb = new JComboBox<>(operators);
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event.getStateChange() == ItemEvent.SELECTED ) {
                    choice = cb.getSelectedIndex();
                }
            }
        });
        frame.add(cb);

        // Fourth Row (Calculate Button)
        frame.add(new JLabel());            // Empty frame
        JDialog.setDefaultLookAndFeelDecorated(true);
        JButton button = new JButton("Calculate");
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                switch (choice) {
                    case 0:
                        result = num1 + num2;
                        break;
                    case 1:
                        result = num1 - num2;
                        break;
                    case 2:
                        result = num1 * num2;
                        break;
                    case 3:
                        result = num1 / num2;
                        break;
                    default:
                }
                System.out.println(result);
            }
        });
        frame.getContentPane().add(button);

        // Fifth Row (Result)
        frame.add(new JLabel("Result:  "));

        // Set width & height of box
        frame.setSize(300,150);

        // Set point relative to screen
        frame.setBounds(800, 400, 300, 150);
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
