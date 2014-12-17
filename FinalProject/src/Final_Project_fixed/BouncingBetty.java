package Final_Project_fixed;

import java.awt.*;

public class BouncingBetty
{
    int objectX = 10, objectY = 10, objectWidth = 10, objectHeight = 10;
    int flashcount = 1, objectdx = 1, objectdy = 1;
    Rectangle badGuyShape;
    Color badGuyColor;
    GamePanel game;
    
    BouncingBetty(GamePanel game)
    {
        this.game = game;
        badGuyShape = new Rectangle(objectX, objectY, objectHeight, objectWidth);
    }
    public void resetBetty()
    {
        objectX = 10;
        objectY = 10;
        objectWidth = 10;
        objectHeight = 10;
    }
    public void bettyBounds()
    {
        if (objectX <= 10)
        {
            objectdx = 1;
        }
        if (objectX >= 980)
        {
            objectdx = -1;
        }
        if (objectY <= 10)
        {
            objectdy = 1;
        }
        if (objectY >= 680)
        {
            objectdy = -1;
        }
    }
    
    public void playerCollision()
    {
        if(objectX > game.player1.heroX+game.player1.heroWidth-4)
        {
            objectdx = 1;
        }
        if(objectX < game.player1.heroX)
        {
            objectdx = -1;
        }
        if(objectY < game.player1.heroY)
        {
            objectdy = -1;
        }
        if(objectY > game.player1.heroY-4)
        {
            objectdy = 1;
        }
        if(!game.badGuyHit)
        {
            game.player1.health -= game.gameOptions.getDifficulty();
            game.badGuyHitter.start();
            game.health.setText("Current Health:" + game.player1.health);
            game.badGuyHit = true;
        }
    }
    public void colorFlash()
    {
        
            flashcount++;
            
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
