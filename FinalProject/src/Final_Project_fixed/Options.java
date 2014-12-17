package Final_Project_fixed;

import java.awt.*;

public class Options 
{
private String name;
private Color color;
private int startingHealth;
private boolean hasSpirit;
private boolean hasCourage;
private boolean hasWisdom;

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

    /**
     * @return the hasSpirit
     */
    public boolean isHasSpirit() {
        return hasSpirit;
    }

    /**
     * @param hasSpirit the hasSpirit to set
     */
    public void setHasSpirit(boolean hasSpirit) {
        this.hasSpirit = hasSpirit;
    }

    /**
     * @return the hasCourage
     */
    public boolean isHasCourage() {
        return hasCourage;
    }

    /**
     * @param hasCourage the hasCourage to set
     */
    public void setHasCourage(boolean hasCourage) {
        this.hasCourage = hasCourage;
    }

    /**
     * @return the hasWisdom
     */
    public boolean isHasWisdom() {
        return hasWisdom;
    }

    /**
     * @param hasWisdom the hasWisdom to set
     */
    public void setHasWisdom(boolean hasWisdom) {
        this.hasWisdom = hasWisdom;
    }




}
