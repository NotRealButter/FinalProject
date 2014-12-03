package Final_Project_fixed;

import java.util.ArrayList;

public class Room 
{
    ArrayList<Wall> wallList = new ArrayList();
    int walls = 0;
    
    Room()
    {
        for(int i = 0; i < 10; i++)
        {
            wallList.add(new Wall());
        }
        
    }
    
   public void inRoomOne()
    {
        walls = 2;
        wallList.get(0).createWall(100, 100, 50, 50);
        wallList.get(1).createWall(400, 400, 100, 25);
    }
   public void inRoomTwo()
   {
       
   }
   public void inRoomThree()
   {
       
   }
   public void inRoomFour()
   {
       
   }
   public void inRoomFive()
   {
       
   }
}
