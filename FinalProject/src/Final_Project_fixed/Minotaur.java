package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.awt.Rectangle;

public class Minotaur
        {
    
    Rectangle minotaurShape, trigger;
    boolean mazeTrap = false;
    int minotaurX = 390, minotaurY = 320, minotaurDX = 0, minotaurDY = 0;
    Player player1;
    Image minotaurImage = Toolkit.getDefaultToolkit().getImage("images/minotaur.png");
    GamePanel game;
    int mazeRun, count, D;
    
    public Minotaur(GamePanel game)
    {
        this.game = game;
        minotaurShape = new Rectangle( minotaurX, minotaurY, 50, 50);
        trigger = new Rectangle(510, 340, 10, 10);
        
        count = 0;
        D = 1;
    }


    public void minotaurAtttack()
    {
            count = count+1;
            
            minotaurX += minotaurDX;
            minotaurY += minotaurDY;

            
            if (count <= 150)
            {
                minotaurDX = D;
                minotaurDY = 0;
                D = 1;
            }
            if (count == 150)
            {
                minotaurDX = 0;
                minotaurDY = -D;
            }
            if (count == 240)
            {
                minotaurDX = -D;
                minotaurDY = 0;
            }
            if (count == 480)
            {
                minotaurDX = 0;
                minotaurDY = D;
                D = 2;
            }
            if (count == 660)
            {
                minotaurDX = D;
                minotaurDY = 0;
            }
            if (count == 825)
            {
                minotaurDX = 0;
                minotaurDY = -D;
            }
            if (count == 960)
            {
                minotaurDX = -D;
                minotaurDY = 0;
            }
            if (count == 1145)
            {
                minotaurDX = 0;
                minotaurDY = 0;
            }
    }         
}
