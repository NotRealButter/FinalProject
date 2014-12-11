package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Minotaur implements ActionListener
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
        trigger = new Rectangle( 0, 0, 10, 10);
        game.time.addActionListener(this);
        
        count = 0;
                
    }


    @Override
    public void actionPerformed(ActionEvent maze) 
    {
        Object select = maze.getSource();
        
        
        if (select == game.time)
        {
            if (direction == 1)
            {
                count = count+1;
            }
            if (direction == -1)
            {
                count = count-1;
            }
            
            System.out.println(count);
            
            minotaurX += minotaurDX;
            minotaurY += minotaurDY;
            

            
            if (count == 0)
            {
                direction = 1;
                mazeRun = 1;
            }
            if (count == 150)
            {
                mazeRun = 2;
            }
            if (count == 240)
            {
                mazeRun = 3;
            }
            if (count == 480)
            {
                mazeRun = 4;
            }
            if (count == 660)
            {
                mazeRun = 5;
            }
            if (count == 990)
            {
                mazeRun = 6;
            }
            if (count == 1260)
            {
                mazeRun = 7;
            }
            if (count == 1630)
            {
                mazeRun = 8;
            }
        }
        
        switch (mazeRun)
        {
            case 1:
                direction = 1;
                minotaurDX = 1;
                minotaurDY = 0; 
                break;
            case 2:
                minotaurDX = 0;
                minotaurDY = -1 * direction;
                break;
            case 3:
                minotaurDX = -1 * direction;
                minotaurDY = 0;
                break;
            case 4:
                minotaurDX = 0;
                minotaurDY = 1 * direction;
                break;
            case 5:
                minotaurDX = 1 * direction;
                minotaurDY = 0;
                break;
            case 6:
                minotaurDX = 0;
                minotaurDY = -1 * direction;
                break;
            case 7:
                minotaurDX = -1 * direction;
                minotaurDY = 0;
                break;
            case 8:
                //direction = -1;
                minotaurDX = 0;
                minotaurDY = 0;
                break;
            
            //minotaurShape.setBounds(minotaurX, minotaurY, 50, 50);
                
        }

        
    }

    
            
}
