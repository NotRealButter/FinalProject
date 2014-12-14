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
    int heroX = 483,heroY = 325, heroWidth = 30, heroHeight = 30; 
    int dx = 0,dy = 0;
    // rectangle 
    Rectangle heroShape;
    Rectangle topHero;
    Rectangle leftHero;
    Rectangle rightHero;
    Rectangle bottomHero;
       
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
           
            /*if (heroX <= 0)
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
            if (heroY >= 650)
            {
                dy = 0;
                heroShape.setBounds(heroX, heroY--, heroWidth, heroHeight);
            }*/
    }
    public void heroFourRectangles()
    {
         topHero = new Rectangle(heroX, heroY, heroWidth, 5);
         leftHero = new Rectangle(heroX, heroY, 5, heroHeight);
         rightHero = new Rectangle(heroX+heroWidth-5, heroY, 5, heroHeight);
         bottomHero = new Rectangle(heroX, heroY+heroHeight-5, heroWidth, 5);
    }
            
    public void setImage()
    {
       
    }
}