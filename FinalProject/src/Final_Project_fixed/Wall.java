package Final_Project_fixed;
import java.awt.*;

public class Wall 
{
private int wallX;
    private int wallY;
    private int wallWidth;
    private int wallHeight;
    private Rectangle wallShape;

Wall()
{
    wallShape = new Rectangle(getWallX(), getWallY(), getWallWidth(), getWallHeight());
}
  

    /**
     * @return the wallX
     */
    public int getWallX() 
    {
        return wallX;
    }

    /**
     * @param wallX the wallX to set
     */
    public void setWallX(int wallX) 
    {
        this.wallX = wallX;
    }

    /**
     * @return the wallY
     */
    public int getWallY() 
    {
        return wallY;
    }

    /**
     * @param wallY the wallY to set
     */
    public void setWallY(int wallY) 
    {
        this.wallY = wallY;
    }

    /**
     * @return the wallWidth
     */
    public int getWallWidth() 
    {
        return wallWidth;
    }

    /**
     * @param wallWidth the wallWidth to set
     */
    public void setWallWidth(int wallWidth) 
    {
        this.wallWidth = wallWidth;
    }

    /**
     * @return the wallHeight
     */
    public int getWallHeight() 
    {
        return wallHeight;
    }

    /**
     * @param wallHeight the wallHeight to set
     */
    public void setWallHeight(int wallHeight) 
    {
        this.wallHeight = wallHeight;
    }

    /**
     * @return the wallShape
     */
    public Rectangle getWallShape() 
    {
        return wallShape;
    }

    /**
     * @param wallShape the wallShape to set
     */
    public void setWallShape(Rectangle wallShape) 
    {
        this.wallShape = wallShape;
    }
    void createWall(int x, int y, int width, int height)
    {
        wallX = x;
        wallY = y;
        wallWidth = width;
        wallHeight = height;
        wallShape = new Rectangle(x,y,width,height);
    }
}
