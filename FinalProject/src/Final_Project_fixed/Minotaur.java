package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Minotaur
        {
    
    Rectangle minotaurShape, trigger;
    boolean mazeTrap = false;
    int minotaurX = 390, minotaurY = 320, minotaurDX = 0, minotaurDY = 0;
    Player player1;
    Image minotaurImage = Toolkit.getDefaultToolkit().getImage("images/minotaur.png");
    GamePanel game;
    int mazeRun, count, direction;
    
    public Minotaur(GamePanel game)
    {
        this.game = game;
        minotaurShape = new Rectangle( minotaurX, minotaurY, 50, 50);
        trigger = new Rectangle(510, 340, 10, 10);
        
        count = 0;

    }


    public void minotaurAtttack()
    {
            count = count+1;
            
            minotaurX += minotaurDX;
            minotaurY += minotaurDY;

            if (count == 0)
            {
                minotaurDX = 1;
                minotaurDY = 0;
            }
            if (count == 150)
            {
                minotaurDX = 0;
                minotaurDY = -1;
            }
            if (count == 240)
            {
                minotaurDX = -1 * direction;
                minotaurDY = 0;
            }
            if (count == 480)
            {
                minotaurDX = 0;
                minotaurDY = 1 * direction;
            }
            if (count == 660)
            {
                minotaurDX = 1 * direction;
                minotaurDY = 0;
            }
            if (count == 990)
            {
                minotaurDX = 0;
                minotaurDY = -1 * direction;
            }
            if (count == 1260)
            {
                minotaurDX = -1 * direction;
                minotaurDY = 0;
            }
            if (count == 1630)
            {
                minotaurDX = 0;
                minotaurDY = 0;
            } 
    }         
}
