package Final_Project_fixed;
import java.awt.*;

public class Door 
{
    private int doorX;
    private int doorY;
    private int doorWidth;
    private int doorHeight;
    private Rectangle doorShape;

Door()
{
    doorShape = new Rectangle(getDoorX(), getDoorY(), getDoorWidth(), getDoorHeight());   
}
  

    public int getDoorX()
    {
        return doorX;
    }
    
    public void setDoorX(int doorX)
    {
        this.doorX = doorX;
    }
    
    public int getDoorY()
    {
        return doorY;
    }
    
    public void setDoorY(int doorY)
    {
        this.doorY = doorY;
    }
    
    public int getDoorWidth()
    {
        return doorWidth;
    }        
    
    public void setDoorWidth(int doorWidth)
    {
        this.doorWidth = doorWidth;
    }
    
    public int getDoorHeight()
    {
        return doorHeight;
    }
            
    public void setDoorHeight(int doorHeight)
    {
        this.doorHeight = doorHeight;
    }
    
    public Rectangle getDoorShape()
    {
        return doorShape;
    }
    
    public void setDoorShape(Rectangle doorShape)
    {
        this.doorShape = doorShape;
    }        
    
    void createDoor(int x, int y, int width, int height)
    {
        doorX = x;
        doorY = y;
        doorWidth = width;
        doorHeight = height;
        doorShape = new Rectangle(x, y, width, height);
    }  
    
    
}