package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;

public class CreditsPanel extends JPanel
{
    JButton back;
    JButton content;
    JButton s1;
    JButton s2;
    JButton s3;
    
    public CreditsPanel()
    {
        super();

        setBackground(Color.green);
        setLayout(null);
        setOpaque(true);
        setBounds(0, 0, 1000, 700);

        content = new JButton("this is the credits");
        content.setBounds(390, 100, 220, 20);
        s1 = new JButton("Stephen Hite");
        s1.setBounds(390, 200, 220, 20);
        s2 = new JButton("Kristen Raleigh");
        s2.setBounds(390, 300, 220, 20);     s3 = new JButton("Garrett Barch");
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
