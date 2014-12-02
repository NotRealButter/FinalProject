package Final_Project_fixed;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.*;

public class Player
{
    GamePanel p1;
    String name = "Link";
    Color color = Color.white;
    int health = 4;
    int heroX = 300,heroY = 300, heroWidth = 20, heroHeight = 20; 
    int dx = 0,dy = 0;
    // rectangle or rectangle2d
    Rectangle heroShape;
   //write bounds method
    
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
                heroShape.setBounds(heroX++, heroY, 20, 20);
            }
            if (heroX >= 964)
            {
                dx = 0;
                heroShape.setBounds(heroX--, heroY, 20, 20);
            }
            if (heroY <= 0)
            {
                dy = 0;
                heroShape.setBounds(heroX, heroY++, 20, 20);
            }
            if (heroY >= 642)
            {
                dy = 0;
                heroShape.setBounds(heroX, heroY--, 20, 20);
            }
    }
}