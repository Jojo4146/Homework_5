package cop2805;

import javax.swing.*;
import java.awt.*;

public class Homework_5 {

    private static String str1;
    private static String str2;

    public static void main(String[] args) {
        // Creates special thread to handle events with the GUI
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
        // Create a grid, sets the columns and rows
        frame.setLayout(new GridLayout(5, 2));
        
        // First Row (First Number)
        JLabel fNum = new JLabel("First Number: ");
        frame.add(fNum);
        JTextField text1 = new JTextField();
        frame.add(text1);
        str1 = text1.getText();


        // Second Row (Second Number)
        JLabel sNum = new JLabel("First Number: ");
        frame.add(sNum);
        JTextField text2 = new JTextField();
        frame.add(text2);
        str2 = text2.getText();

        // Third Row (Combo Box)
        frame.add(new JLabel());            // Empty frame
        String[] operators = { "Add", "Subtract", "Multiply", "Divide" };  // Start of JComboBox
        JComboBox cb = new JComboBox(operators);
        cb.setSelectedIndex(0);
        System.out.println(cb.getSelectedItem());
        frame.add(cb);

        // Fourth Row (Calculate Button)
        frame.add(new JLabel());            // Empty frame
        JDialog.setDefaultLookAndFeelDecorated(true);
        JButton button = new JButton("Calculate");
        frame.add(button);
        button.addActionListener(new ActionEvents());
        frame.getContentPane().add(button);


        // Fifth Row (Result)
        int result = 0;
        frame.add(new JLabel("Result:  " + result));    // Empty frame

        // Set width & height of box
        frame.setSize(300,150);

        // Set point relative to screen
        frame.setBounds(800, 400, 300, 150);
        frame.setVisible(true);
    }


}
