package Final_Project_fixed;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Room 
{
    Image candleFlicker = Toolkit.getDefaultToolkit().getImage("images/candle/candle1.png");
    Image roomFiveFloor = Toolkit.getDefaultToolkit().getImage("images/roomFive/roomFiveFloor.png");
    Image roomFiveLocked = Toolkit.getDefaultToolkit().getImage("images/roomFive/roomFiveSub.png");
    Image buttonActivated = Toolkit.getDefaultToolkit().getImage("images/roomFive/activatedInterior.png");
    Image roomThreeFloor = Toolkit.getDefaultToolkit().getImage("images/sand.jpg");

    
    ArrayList<Wall> wallList = new ArrayList();
    ArrayList<Door> doorList = new ArrayList();
    ArrayList<Image> lionList = new ArrayList();
    ArrayList<Rectangle> lionRectums = new ArrayList();
    
    Timer flicker;
    int walls = 0, doors = 0, flickerCount = 0;
    boolean roomTwo = false, roomTwoItem = false, roomFive = false;
    JLabel derp = new JLabel();
    Rectangle r5Button1, r5Button2, r5Button3;
    
    Room()
    {
        for(int i = 0; i < 30; i++)
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
   public void inRoomTwo() //Kristens room
   {
       
       walls = 4;
       roomTwo = false;
       roomFive = false;
              
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
       roomFive = false;
       roomTwo = true;
       derp.setText(null);
       //walls
       walls = 29;
       //horizontal
       wallList.get(20).createWall(260, 100, 460, 40);
       wallList.get(21).createWall(260, 190, 370, 40);
       wallList.get(22).createWall(350, 280, 190, 40);
       wallList.get(23).createWall(350, 370, 280, 40);
       wallList.get(24).createWall(260, 460, 460, 40);
       //vertical
       wallList.get(25).createWall(260, 190, 40, 310);
       wallList.get(26).createWall(350, 280, 40, 130);
       wallList.get(27).createWall(590, 190, 40, 220);
       wallList.get(28).createWall(680, 100, 40, 400);
       //default walls
       wallList.get(0).createWall(0, 0, 1000, 10);
       wallList.get(1).createWall(990, 0, 10, 700);
       wallList.get(2).createWall(0, 690, 1000, 10);
       wallList.get(3).createWall(0, 0, 10, 700);
       //doors
       doors = 1;
       
       doorList.get(0).createDoor(0, 300 , 10, 100);
   }
   public void inRoomFour()
   {
       walls = 4;
       derp.setText(null);
       roomTwo = false;
       roomFive = false;
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
       walls = 8;
       roomFive = true;
       derp.setText(null);
       roomFive = false;
       roomTwo = false;
       //default walls
       wallList.get(0).createWall(0, 0, 1000, 10);
       wallList.get(1).createWall(990, 0, 10, 700);
       wallList.get(2).createWall(0, 690, 1000, 10);
       wallList.get(3).createWall(0, 0, 10, 700);
       //added walls
       wallList.get(4).createWall(340, 100, 250, 20);
       wallList.get(5).createWall(340, 300, 250, 20);
       wallList.get(6).createWall(340, 100, 20, 200);
       wallList.get(7).createWall(590, 100, 20, 220); 
       
       
       
       //doors
       doors = 1;
       
       doorList.get(0).createDoor(990, 300 , 10, 100);
   }
   public void candleFlicker()
   {
        System.out.println(flickerCount);
        
        switch(flickerCount)
        {
            case 1:
       roomTwo = false;
       
       r5Button1 = new Rectangle (173,375, 68,68);
       r5Button2 = new Rectangle (442,579, 68, 68);
       r5Button3 = new Rectangle (771,376, 68, 68);
       
            case 2:
                candleFlicker = Toolkit.getDefaultToolkit().getImage("images/candle/candle2.png");
                break;
            case 3:
                candleFlicker = Toolkit.getDefaultToolkit().getImage("images/candle/candle3.png");
                break;
            case 4:
                candleFlicker = Toolkit.getDefaultToolkit().getImage("images/candle/candle2.png");
                break;
            case 5:
                candleFlicker = Toolkit.getDefaultToolkit().getImage("images/candle/candle1.png");
                break;
            case 6:
                flickerCount = 1;
                break;
        }
        flickerCount++;
            
   }
}
//                candleFlicker = Toolkit.getDefaultToolkit().getImage("images/candle/candle1.png");
//                break;
