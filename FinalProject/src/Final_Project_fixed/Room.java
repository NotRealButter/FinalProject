package Final_Project_fixed;

import java.util.ArrayList;

public class Room 
{
    ArrayList<Wall> wallList = new ArrayList();
    int walls = 0;
    
    ArrayList<Door> doorList = new ArrayList();
    int doors = 0;
    
    Room()
    {
        for(int i = 0; i < 10; i++)
        {
            wallList.add(new Wall());
            doorList.add(new Door());
        }
        
    }
    
   public void inRoomOne()
    {
       walls = 9;
       //horizontal
       wallList.get(0).createWall(260, 100, 460, 40);
       wallList.get(1).createWall(260, 190, 370, 40);
       wallList.get(2).createWall(350, 280, 190, 40);
       wallList.get(3).createWall(350, 370, 280, 40);
       wallList.get(4).createWall(260, 460, 460, 40);

       //vertical
       wallList.get(5).createWall(260, 190, 40, 310);
       wallList.get(6).createWall(350, 280, 40, 130);
       wallList.get(7).createWall(590, 190, 40, 220);
       wallList.get(8).createWall(680, 100, 40, 400);
       
       doors = 2;
       
       doorList.get(0).createDoor(0, 250, 10, 200);
       doorList.get(1).createDoor(0, 0, 100, 100);
    }
   public void inRoomTwo()
   {

       
   }
   public void inRoomThree()
   {
              walls = 9;
       //horizontal
       wallList.get(0).createWall(260, 100, 460, 40);
       wallList.get(1).createWall(260, 190, 370, 40);
       wallList.get(2).createWall(350, 280, 190, 40);
       wallList.get(3).createWall(350, 370, 280, 40);
       wallList.get(4).createWall(260, 460, 460, 40);

       //vertical
       wallList.get(5).createWall(260, 190, 40, 310);
       wallList.get(6).createWall(350, 280, 40, 130);
       wallList.get(7).createWall(590, 190, 40, 220);
       wallList.get(8).createWall(680, 100, 40, 400);
   }
   public void inRoomFour()
   {
       walls = 2;
        wallList.get(0).createWall(100, 100, 50, 50);
        wallList.get(1).createWall(400, 400, 100, 25);
   }
   public void inRoomFive()
   {
       
   }
}
