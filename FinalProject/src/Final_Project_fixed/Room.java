package Final_Project_fixed;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Room 
{
 
    ArrayList<Wall> wallList = new ArrayList();
    int walls = 0;
    
    ArrayList<Door> doorList = new ArrayList();
    
    ArrayList<Image> lionList = new ArrayList();
    ArrayList<Rectangle> lionRectums = new ArrayList();
    int doors = 0;
    boolean roomTwo = false, roomTwoItem = false;
    JLabel derp = new JLabel();
    Room()
    {
        for(int i = 0; i < 20; i++)
        {
            wallList.add(new Wall());
            doorList.add(new Door());
        }
        for(int i = 0; i < 5; i++)
       {
           lionRectums.add(new Rectangle());
       }
        
    }
    
   public void inRoomOne()
    {
       walls = 4;
       derp.setText(null);
       roomTwo = false;
       //default walls
       wallList.get(0).createWall(0, 0, 1000, 10);
       wallList.get(1).createWall(990, 0, 10, 700);
       wallList.get(2).createWall(0, 690, 1000, 10);
       wallList.get(3).createWall(0, 0, 10, 700);
       
       doors = 4;
       
       doorList.get(0).createDoor(0, 300, 10, 100);
       doorList.get(1).createDoor(990, 300, 10, 100);
       doorList.get(2).createDoor(450, 0, 100, 10);
       doorList.get(3).createDoor(450, 690, 100, 10);
       
       
    }
   public void inRoomTwo()
   {
       
       walls = 4;
       
       roomTwo = true;
       
       
       Image lion1 = Toolkit.getDefaultToolkit().getImage("images/lion1.png");
       Image lion2 = Toolkit.getDefaultToolkit().getImage("images/lion2.png");
       Image lion3 = Toolkit.getDefaultToolkit().getImage("images/lion3.png");
       Image lion4 = Toolkit.getDefaultToolkit().getImage("images/lion4.png");
       Image lion5 = Toolkit.getDefaultToolkit().getImage("images/lion5.png");
       
       lionList.add(lion1);
       lionList.add(lion2);
       lionList.add(lion3);
       lionList.add(lion4);
       lionList.add(lion5);
       
       //default walls
       wallList.get(0).createWall(0, 0, 1000, 10);
       wallList.get(1).createWall(990, 0, 10, 700);
       wallList.get(2).createWall(0, 690, 1000, 10);
       wallList.get(3).createWall(0, 0, 10, 700);
       //doors
       doors = 1;
       
       doorList.get(0).createDoor(450, 690, 100, 10);
       
   }
   public void inRoomThree()//garrett's room
   {
       roomTwo = false;
       derp.setText(null);
       //walls
       walls = 13;
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
       //default walls
       wallList.get(9).createWall(0, 0, 1000, 10);
       wallList.get(10).createWall(990, 0, 10, 700);
       wallList.get(11).createWall(0, 690, 1000, 10);
       wallList.get(12).createWall(0, 0, 10, 700);
       //doors
       doors = 1;
       
       doorList.get(0).createDoor(0, 300 , 10, 100);
   }
   public void inRoomFour()
   {
       walls = 4;
       derp.setText(null);
       roomTwo = false;
       //default walls
       wallList.get(0).createWall(0, 0, 1000, 10);
       wallList.get(1).createWall(990, 0, 10, 700);
       wallList.get(2).createWall(0, 690, 1000, 10);
       wallList.get(3).createWall(0, 0, 10, 700);
        
        //doors
       doors = 1;
       
       doorList.get(0).createDoor(450, 0, 100, 10);
   }
   public void inRoomFive()
   {
       walls = 4;
       derp.setText(null);
       roomTwo = false;
       //default walls
       wallList.get(0).createWall(0, 0, 1000, 10);
       wallList.get(1).createWall(990, 0, 10, 700);
       wallList.get(2).createWall(0, 690, 1000, 10);
       wallList.get(3).createWall(0, 0, 10, 700);
       //doors
       doors = 1;
       
       doorList.get(0).createDoor(990, 300 , 10, 100);
   }
}
