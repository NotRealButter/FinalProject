package Final_Project_fixed;

import java.awt.*;

public class Options 
{
private String name;
private int difficulty;
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

    /**
     * @return the difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }




}
