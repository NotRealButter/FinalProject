package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SplashPanel extends JPanel
{    
    JButton toGame,toOptions,toCredits,toHowTo;  
    
    public SplashPanel()
    {
        super();
        
        setLayout(null);
        setBackground(Color.white);
        setOpaque(true);

        toGame = new JButton("Load Game");
        toOptions = new JButton("New Game");
        toCredits = new JButton("Credits");
        toHowTo = new JButton("How to Play");

        add(toGame);
        add(toOptions);
        add(toCredits);
        add(toHowTo);

        toGame.setBounds(350, 400, 100, 20);
        toOptions.setBounds(450, 400, 100, 20);
        toCredits.setBounds(550, 400, 100, 20);
        toHowTo.setBounds(650,400,100,20);


        toGame.setBackground(Color.red);
        toOptions.setBackground(Color.blue);
        toCredits.setBackground(Color.green);
        toHowTo.setBackground(Color.cyan);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        Image floorTexture = Toolkit.getDefaultToolkit().getImage("images/home.png");
        g.drawImage(floorTexture, 0, 0, this);
    }
}