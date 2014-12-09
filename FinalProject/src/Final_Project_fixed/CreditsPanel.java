package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;

public class CreditsPanel extends JPanel
{
    JButton back;
    JLabel content;
    JLabel s1;
    JLabel s2;
    JLabel s3;
    
    public CreditsPanel()
    {
        super();

        setBackground(Color.green);
        setLayout(null);
        setOpaque(true);
        setBounds(0, 0, 1000, 700);

        content = new JLabel("This game was made by:");
        content.setBounds(390, 100, 220, 20);
        s1 = new JLabel("Stephen Hite");
        s1.setBounds(390, 200, 220, 20);
        s2 = new JLabel("Kristen Raleigh");
        s2.setBounds(390, 300, 220, 20);     
        s3 = new JLabel("Garrett Barch");
        s3.setBounds(390, 400, 220, 20);
        back = new JButton("Back");
        back.setBounds(390, 500, 220, 20);

        add(content);
        add(s1);
        add(s2);
        add(s3);
        add(back);
    }
    
}
