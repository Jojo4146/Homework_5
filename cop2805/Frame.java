package cop2805;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame{

    private JLabel item1;

    public Frame(){
        super("Simple Calculator");
        setLayout(new FlowLayout());

        item1 = new JLabel("This is a sentence");
        item1.setToolTipText("This gonna show up on hover");
        add(item1);


    }

}
