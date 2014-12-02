package Final_Project_fixed;

import java.awt.*;

public class Options 
{
private String name;
private Color color;
private int startingHealth;

public Options()
{
    
}

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * @return the color
     */
    public Color getColor() 
    {
        return color;
    }
    public int getColorValue()
    {
        int color = 0;
        if(this.color.equals(Color.blue))
        {
            color = 1;
        }
        if(this.color.equals(Color.green))
        {
            color = 2;
        }
        if(this.color.equals(Color.red))
        {
            color = 3;
        }
        return color;
    }
    /**
     * @param color the color to set
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * @return the startingHealth
     */
    public int getStartingHealth()
    {
        return startingHealth;
    }

    /**
     * @param startingHealth the startingHealth to set
     */
    public void setStartingHealth(int startingHealth) 
    {
        this.startingHealth = startingHealth;
    }




}
