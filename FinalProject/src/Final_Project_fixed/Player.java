package Final_Project_fixed;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class Player
{
    GamePanel gp1;

    Image frontStanding = Toolkit.getDefaultToolkit().getImage("images/front/front standing new.png");
    Image leftStanding = Toolkit.getDefaultToolkit().getImage("images/left/left left new.png");
//    Image leftSideRight = Toolkit.getDefaultToolkit().getImage("images/left/left right.png");
//    Image leftSideLeft = Toolkit.getDefaultToolkit().getImage("images/left/left left.png");
    Image rightStanding = Toolkit.getDefaultToolkit().getImage("images/right/right standing new.png");
//    Image rightSideRight = Toolkit.getDefaultToolkit().getImage("images/right/right right.png");
//    Image rightSideLeft = Toolkit.getDefaultToolkit().getImage("images/right/right left.png");
    Image backStanding = Toolkit.getDefaultToolkit().getImage("images/back/New Link Back.png");
//    Image backRight = Toolkit.getDefaultToolkit().getImage("images/back/back right.png");
//    Image backLeft = Toolkit.getDefaultToolkit().getImage("images/back/back left.png");
    
    String name = "Link";
    Color color = Color.white;
    int health = 4;
    int heroX = 300,heroY = 300, heroWidth = 50, heroHeight = 75; 
    int dx = 0,dy = 0;
    // rectangle 
    Rectangle heroShape;
       
    public Player(String infName, Color infColor, int infHealth)
    {
        name = infName;
        color = infColor;
        health = infHealth;
    }
    public Player(Options options)
    {
        name = options.getName();
        color = options.getColor();
        health = options.getStartingHealth();
    }
    String getInfo()
    {
        return "Player name = " + name + " Player color = " + color + " Player health = " +health;
    }
    int setHealth()
    {
        return health;
    }
    void heroBounds()
    {
           
            if (heroX <= 0)
            {
                dx = 0;
                heroShape.setBounds(heroX++, heroY, heroWidth, heroHeight);
            }
            if (heroX >= 964)
            {
                dx = 0;
                heroShape.setBounds(heroX--, heroY, heroWidth, heroHeight);
            }
            if (heroY <= 0)
            {
                dy = 0;
                heroShape.setBounds(heroX, heroY++, heroWidth, heroHeight);
            }
            if (heroY >= 642)
            {
                dy = 0;
                heroShape.setBounds(heroX, heroY--, heroWidth, heroHeight);
            }
    }
    public void setImage()
    {
       
    }
}