package Final_Project_fixed;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class Player
{
    GamePanel gp1;

    Image frontStanding = Toolkit.getDefaultToolkit().getImage("images/front/front standing new.png");
    Image leftStanding = Toolkit.getDefaultToolkit().getImage("images/left/left left new.png");
    Image rightStanding = Toolkit.getDefaultToolkit().getImage("images/right/right standing new.png");
    Image backStanding = Toolkit.getDefaultToolkit().getImage("images/back/New Link Back.png");
    
    String name = "Link";
    int health = 4;
    int heroX = 485,heroY = 355, heroWidth = 32, heroHeight = 30; 
    int dx = 0,dy = 0;
    boolean hasCourage=false, hasWisdom=false, hasSpirit=false;
    Rectangle heroShape;

       
    public Player(String infName, int infHealth)
    {
        name = infName;
        health = infHealth;
    }
    public Player(Options options)
    {
        name = options.getName();
        health = options.getStartingHealth();
    }
    String getInfo()
    {
        return "Player name = " + name + " Player health = " +health;
    }
    int setHealth()
    {
        return health;
    }
}