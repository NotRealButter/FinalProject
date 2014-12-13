package Final_Project_fixed;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener
{
    myJPanel gp1;
    Player player1;
    BouncingBetty badGuy;
    private Options gameOptions;
    Room inThisRoom;
    Minotaur maze;
    boolean trap;
    Door thisDoor;
    Rectangle openDoor;
        
    Image floorTexture = Toolkit.getDefaultToolkit().getImage("images/floor1.jpg");
            
    Rectangle baddieShape;
    Rectangle sword;
    
    JButton back, content;
    JLabel health, name;
    Graphics g;
    int flashcount = 0, doorDelay = 0;
    int roomNumber = 1;
    int directionFacing = 3;
    int frameWidth, frameHeight;
    

    Timer time, flashing;
  
    public GamePanel()
    {
        super();
        requestFocusInWindow(true);
        setLayout(null);
        setBackground(Color.gray);
        setOpaque(true);
        setBounds(0, 0, 1000, 700);
        defaultChar();
        loadOptions();
        refreshPlayer();
        
        inThisRoom = new Room();
        thisDoor = new Door();
        
        content = new JButton("this is where the game is");
        content.setBounds(390, 500, 220, 20);
        //add(content);
        back = new JButton("Back");
        back.setBounds(450, 520, 100, 20);
        //add(back);

        health = new JLabel("health");
        health.setBounds(10, 600, 100, 20);
        health.setOpaque(true);
        health.setBackground(Color.white);
        add(health);

        name = new JLabel("name");
        name.setOpaque(true);
        name.setBounds (670, 600, 300, 20);
        name.setBackground(Color.white);
        add(name);
        
        
               
        //timers
        time = new Timer(10, this);
        time.addActionListener(this);
        time.start(); 

        flashing = new Timer(100, this);
        flashing.addActionListener(this);
        flashing.start();
  
        player1.heroShape = new Rectangle(player1.heroX, player1.heroY, player1.heroWidth, player1.heroHeight);
        displaySetup();
        
        roomNumber = 1;
        //inRoom();
        trap = false;
        
        badGuy = new BouncingBetty(this);
    }
    
    public void refreshPlayer()
    {
        if(gameOptions != null)
        {
            player1 = new Player(gameOptions);
        }
    }
    public void loadOptions()
    {
        File optionsFile = new File("Options.xml");
        if(optionsFile.exists())
        {
            XML_240 x2 = new XML_240();
            
            x2.openReaderXML("Options.xml");
            
            gameOptions = (Options)x2.ReadObject();
            
            x2.closeReaderXML();
        }
    }
    public void createPlayer(Options options)
    {
        player1 = new Player(options);
    }
    
   /* public void inRoom()
    {
        switch (roomNumber)
        {
            case 1: 
                inThisRoom.inRoomOne();
                break;
            case 2: 
                inThisRoom.inRoomTwo();
                break;
            case 3:
                inThisRoom.inRoomThree();
                maze = new Minotaur(this);
                break;
            case 4:
                inThisRoom.inRoomFour();
                break;
            case 5:
                inThisRoom.inRoomFive();
                break;
        }        
    }*/


    public void defaultChar()
    {
        if(player1 == null)
        {
            player1 = new Player("Link", Color.GREEN, 4);    
        }
    }
    
    public void displaySetup ()
    {
        health.setText("Current Health:" + player1.health);
        name.setText("Player Name: " + player1.name);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(floorTexture, 0, 0, this);
       
        for(int i = 0; i < inThisRoom.walls; i++)
        {
            g.setColor(Color.BLACK);
            g.fillRect(inThisRoom.wallList.get(i).getWallX(), inThisRoom.wallList.get(i).getWallY(), inThisRoom.wallList.get(i).getWallWidth(), inThisRoom.wallList.get(i).getWallHeight());

        }
        for(int i = 0; i < inThisRoom.doors; i++)
        {
            g.setColor(Color.red);
            g.fillRect(inThisRoom.doorList.get(i).getDoorX(), inThisRoom.doorList.get(i).getDoorY(), inThisRoom.doorList.get(i).getDoorWidth(), inThisRoom.doorList.get(i).getDoorHeight());
        }
        if(gameOptions != null)
        {
            g.setColor(gameOptions.getColor());
        }
        else
        {
            g.setColor(Color.green);
        }
        //g.fillRect(player1.heroX, player1.heroY, player1.heroWidth, player1.heroHeight);
         switch (directionFacing)
        {
            case 1:
                g.drawImage(player1.backStanding, player1.heroX, player1.heroY, this);
                break;
            case 2:
                g.drawImage(player1.leftStanding, player1.heroX, player1.heroY, this);
                break;                
            case 3:
                g.drawImage(player1.frontStanding, player1.heroX, player1.heroY, this);
                break;
            case 4:
                g.drawImage(player1.rightStanding, player1.heroX, player1.heroY, this);
                break;
        }
        
       // g.fillRect(player1.heroX, player1.heroY, player1.heroWidth, player1.heroHeight);
       
        player1.heroShape = new Rectangle(player1.heroX, player1.heroY, player1.heroWidth, player1.heroHeight);
        //badGuy.badGuyShape = new Rectangle(badGuy.objectX, badGuy.objectY, badGuy.objectHeight, badGuy.objectWidth);
        //inThisRoom.wall1

        if (maze != null)
        {
        g.drawImage(maze.minotaurImage, maze.minotaurX, maze.minotaurY, this);
        //g.fillRect(maze.minotaurX, maze.minotaurY, 50, 50);
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(maze.trigger);         
        }
        
        if (badGuy != null)
        {
            g.setColor(badGuy.badGuyColor);
            g.fillRect(badGuy.objectX, badGuy.objectY, badGuy.objectWidth, badGuy.objectHeight);
            //Graphics2D g2d = (Graphics2D) g;
            //g2d.draw(badGuy.badGuyShape);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object select = e.getSource();
        
        if (select == time)
        {
//            for(int i = 0; i < inThisRoom.walls; i++)
//            {
//                if (player1.heroShape.intersects(inThisRoom.wallList.get(i).getWallShape()))
//                {
//                    if(inThisRoom.wallList.get(i).getWallX() > player1.heroX+player1.heroWidth-4)
//                    {
//                        player1.heroX--;
//                    }
//                    else if(inThisRoom.wallList.get(i).getWallX() + inThisRoom.wallList.get(i).getWallWidth() < player1.heroX)
//                    {
//                        player1.heroX++;
//                    }
//                    else if(inThisRoom.wallList.get(i).getWallY() + inThisRoom.wallList.get(i).getWallHeight()  < player1.heroY)
//                    {
//                        player1.dy *= -1;
//                    }
//                    else if(inThisRoom.wallList.get(i).getWallY()  > player1.heroY+ player1.heroHeight-4)
//                    {
//                        player1.dy *= -1;
//                    }  
//                }
//            }
            
            player1.heroX += player1.dx;
            player1.heroY += player1.dy;
            
        if (roomNumber != 5)
        {
            badGuy = null;
        }
        if (badGuy != null)
        {
            badGuy.objectX += badGuy.objectdx;
            badGuy.objectY += badGuy.objectdy;
            
            badGuy.bettyBounds();

                // collision bounds
            if (player1.heroShape.intersects(badGuy.badGuyShape))
                {
                    if(badGuy.objectX > player1.heroX+player1.heroWidth-4)
                    {
                        badGuy.objectdx = 1;
                    }
                    if(badGuy.objectX < player1.heroX)
                    {
                        badGuy.objectdx = -1;
                    }
                    if(badGuy.objectY < player1.heroY)
                    {
                        badGuy.objectdy = -1;
                    }
                    if(badGuy.objectY > player1.heroY-4)
                    {
                    badGuy.objectdy = 1;
                    }
                }
            }
            
            
                        
            player1.heroBounds();
            
            if (player1 != null)
            {
                player1.heroX += player1.dx;
                player1.heroY += player1.dy;
            }  
            
            if (roomNumber != 3)
            {
                maze = null;
                trap = false;
            }
            if (maze != null)
            {
                if (player1.heroShape.intersects(maze.trigger))
                {
                    trap = true;
                }    
                if (trap == true)
                {
                    maze.minotaurAtttack();
                    
                    if(player1.heroShape.intersects(maze.minotaurShape))
                    {
                        player1.health = player1.health-1;  
                        player1.heroX = 12;
                        player1.heroY = 325;
                        
                    }
                    
                }
            }
         

if (thisDoor != null)
{
    doorDelay = doorDelay+1;
    if (doorDelay >= 10)
    {
        for(int i = 0; i < inThisRoom.doors; i++)
        { 
            openDoor = inThisRoom.doorList.get(i).getDoorShape();
                
            if (player1.heroShape.intersects(openDoor))
            {    
                switch (roomNumber)
                {
                    case 1: //for loop idea
                    {   
                        if (inThisRoom.doorList.get(i).getDoorY() <= 10)
                        {
                            roomNumber = 2; 
                            player1.heroX = 483;
                            player1.heroY = 688 - player1.heroHeight;
                            doorDelay = 0;
                        }
                        if (inThisRoom.doorList.get(i).getDoorX() >= 980)
                        {
                            roomNumber = 3;
                            player1.heroX = 12;
                            player1.heroY = 325;
                            doorDelay = 0;
                        }
                        if (inThisRoom.doorList.get(i).getDoorY() >= 680)
                        {
                            roomNumber = 4;
                            player1.heroX = 483;
                            player1.heroY = 12;
                            doorDelay = 0;
                        }
                        if (inThisRoom.doorList.get(i).getDoorX() <= 10)
                        {
                            roomNumber = 5;
                            player1.heroX = 988 - player1.heroWidth;
                            player1.heroY = 325;
                            doorDelay = 0;
                        }
                        break;
                    }
                    case 2:
                    {
                        roomNumber = 1;
                        player1.heroX = 483;
                        player1.heroY = 12;
                        doorDelay = 0;
                        break;
                    }
                    case 3:
                    {
                        roomNumber = 1;
                        player1.heroX = 988 - player1.heroWidth;
                        player1.heroY = 325;  
                        doorDelay = 0;
                        break;
                    }
                    case 4:
                    {
                        roomNumber = 1;
                        player1.heroX = 483;
                        player1.heroY = 688 - player1.heroHeight;
                        doorDelay = 0;
                        break;
                    }
                    case 5:
                    {
                        roomNumber = 1;
                        player1.heroX = 12;
                        player1.heroY = 325;
                        doorDelay = 0;
                        break;
                    }
                }
            }
        }
    }    
}      
        switch (roomNumber)
        {
            case 1: 
                inThisRoom.inRoomOne();
                break;
            case 2: 
                inThisRoom.inRoomTwo();
                break;
            case 3:
                inThisRoom.inRoomThree();
                maze = new Minotaur(this);
                break;
            case 4:
                inThisRoom.inRoomFour();
                //badGuy = new BouncingBetty(this);
                break;
            case 5:
                inThisRoom.inRoomFive();
                
                break;
        }
            repaint();            
            revalidate();
        }
        if (badGuy != null)
        {
            if (select == flashing)
            {
                badGuy.colorFlash();
            }
        }    
    }

    /**
     * @param gameOptions the gameOptions to set
     */
    public void setGameOptions(Options gameOptions) 
    {
        this.gameOptions = gameOptions;
    }
}
