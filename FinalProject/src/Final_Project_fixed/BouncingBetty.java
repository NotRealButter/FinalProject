package Final_Project_fixed;

import java.awt.*;

public class BouncingBetty
{
    int objectX = 490, objectY = 340, objectWidth = 10, objectHeight = 10;
    int flashcount = 1, objectdx = 1, objectdy = 1;
    Rectangle badGuyShape;
    Color badGuyColor;
    Player player1;
    GamePanel game;
    
    BouncingBetty(GamePanel game)
    {
        this.game = game;
        badGuyShape = new Rectangle(objectX, objectY, objectHeight, objectWidth);
        
    }
    
    public void bettyBounds()
    {
         if (objectX <= 0)
        {
            objectdx = 1;
        }
        if (objectX >= 942)
        {
            objectdx = -1;
        }
        if (objectY <= 0)
        {
            objectdy = 1;
        }
        if (objectY >= 642)
        {
            objectdy = -1;
        }
        
        
    }
    public void colorFlash()
    {
        
            flashcount++;
            System.out.println(flashcount);
            if (flashcount == 4)
            {
                flashcount = 1;
            }
            if (flashcount == 1)
            {
                badGuyColor = Color.red;
            }
            if (flashcount == 2)
            {
                badGuyColor = Color.BLUE;
            }
            if (flashcount == 3)
            {
                badGuyColor = Color.GREEN;
            } 
    }
}
