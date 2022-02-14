package cop2805;

import javax.swing.*;
import java.awt.*;

public class Homework_5 {

    public static void main(String[] args) {
        //Lambda that creates special thread to handle events with the GUI
        // while calling constructGUI method
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }

    private static void constructGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        // Set the title
        frame.setTitle("Simple Calculator");
        // Shut down program on clicking corner X
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a grid and set the columns and rows
        frame.setLayout(new GridLayout(5, 2));
        // First Row
        frame.add(new JLabel("First Number:"));
        frame.add(new JTextField());

        // Second Row
        frame.add(new JLabel("Second Number:"));
        frame.add(new JTextField());

        // Third Row
        frame.add(new JLabel());            // Empty frame
        String[] operators = { "Add", "Subtract", "Multiply", "Divide" };  // Start of JComboBox
        JComboBox cb = new JComboBox(operators);
        cb.setSelectedIndex(1);
        System.out.println(cb.getSelectedItem());
        frame.add(cb);
        // Fourth Row
        frame.add(new JLabel());            // Empty frame
        frame.add(new JButton("Calculate"));

        // Fifth Row
        frame.add(new JLabel("Result:"));            // Empty frame

        // Set width & height
        frame.setSize(300,150);
        // Set point relative to screen
        frame.setBounds(800, 400, 300, 150);
        frame.setVisible(true);
    }
}
