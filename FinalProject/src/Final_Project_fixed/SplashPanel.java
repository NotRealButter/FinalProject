package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SplashPanel extends JPanel
{    
    JButton toGame,toOptions,toCredits;  
    
    public SplashPanel()
    {
        super();
        
        setLayout(null);
        setBackground(Color.white);
        setOpaque(true);


        toGame = new JButton("Game");
        toOptions = new JButton("Options");
        toCredits = new JButton("Credits");

        add(toGame);
        add(toOptions);
        add(toCredits);

        toGame.setBounds(350, 400, 100, 20);
        toOptions.setBounds(450, 400, 100, 20);
        toCredits.setBounds(550, 400, 100, 20);


        toGame.setBackground(Color.red);
        toOptions.setBackground(Color.blue);
        toCredits.setBackground(Color.green);

        toGame.setText("Game");
        toOptions.setText("Options");
        toCredits.setText("Credits");
    }
}