# Homework_5
Build a GUI Calculator

Build a GUI that has the following

Two JTextFields to input numbers into
Do not worry about validating if numbers are actually entered.
A JComboBox with the following strings inside:
Add
Subtract
Multiply
Divide
A JButton that reads "Calculate"
A JLabel that outputs a result
Interactions

1. When "Add" is selected and the calculate button is pressed, the two numbers in the text fields are added.
2. When "Subtract" is selected and the calculate button is pressed, the two numbers in the text fields are subtracted.
3. When "Multiply" is selected and the calculate button is pressed, the two numbers in the text fields are multiplied together.
4. When "Divide" is selected and the calculate button is pressed, the two numbers in the text fields are divided.
5. For each calculation the result is output to a JLabel.

Advice

Look at slides 37, 38 and 39 (GUI Access Example) to see how you can access other GUI items from within a listener.

The easiest implementation is to create your own extension of a JFrame that has a set of public components. Then you implement your own extension of an ActionListener that saves a JFrame attached to it. This is shown in the slides referenced above.

The Lecture this week doesn't go through all of the examples. Look at the reading for this week for great examples on setting up a JComboBox.

Build an ActionListener for the JButton

1. When the button is pressed it should do the following
  Get the text from the two JTextFields and convert them to Doubles.
    The getText() method returns the text inside of a JTextField as a String.
    You can use Double.parseDouble(String input) to turn a String into a Double.
2. Get the text from the JComboBox
  You can use the getSelectedItem() method to get the currently selected string.
3. Calculate the result based on the string from the JComboBox
  This determines if you will use the + operator, - operator, * operator or / operator
4. Set the result to the JLabel
 Use the .setText() method to construct a String

5. My Layout

If you want the same layout I used, it was a simple Grid layout with 5 rows and 2 columns.

Row 1 - JLabel and JTextField
Row 2 - JLabel and JTextField
Row 3 - Empty JLabel and JComboBox
Row 4 - Empty JLabel and JButton
Row 5 - JLabel


