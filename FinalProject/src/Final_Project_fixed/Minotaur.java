package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;

public class Minotaur {
    
    Rectangle minotaurShape, trigger;
    boolean mazeTrap = false;
    int minotaurx = 390, minotaury = 320, minotaurdx = 0, minotaurdy = 0;
    Player player1;
    //Timer mazeTime;
    Color minotaurColor, mazeColor;
    Image minotaurImage = Toolkit.getDefaultToolkit().getImage("images/minotaur.png");
    
    Minotaur()
    {
        minotaurShape = new Rectangle( minotaurx, minotaury, 50, 50);
        trigger = new Rectangle( 0, 0, 10, 10);

    }
    
    public void mazeColors()
    {
        minotaurColor = Color.GRAY;
        
    }
    
    /*public void attack()
    {
       if(trigger.intersects(player1.heroShape))
       {
           minotaurx += minotaurdx;
           minotaury += minotaurdy;
           
           
       }
       
    }*/

    
            
}
