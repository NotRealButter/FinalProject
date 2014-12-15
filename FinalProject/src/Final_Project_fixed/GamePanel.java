package Final_Project_fixed;

import java.awt.*;
//import java.awt.Rectangle;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener
{
    myJPanel gp1;
    Player player1;
    BouncingBetty badGuy;
    Minotaur maze;
    private Options gameOptions;
    Room inThisRoom;
    boolean addMonster;
    Door thisDoor;
    Wall thisWall;
    Rectangle openDoor, touchedWall;
        
    Image floorTexture = Toolkit.getDefaultToolkit().getImage("images/floor1.jpg");

            
    Rectangle baddieShape;
    Rectangle sword;
    
    JButton back, content;
    JLabel health, name;
    Graphics g;
    int flashcount = 0, collisionDelay = 0;
    int roomNumber = 1;
    int directionFacing = 3;
    int frameWidth, frameHeight;
    
     

    Timer time, flashing, flicker;
  
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
        thisWall = new Wall();
        
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
        
        flicker = new Timer(200, this);
        flicker.addActionListener(this);
        flicker.start();
  
    displaySetup();
        
        roomNumber = 1;
        addMonster = false;
        maze = new Minotaur(this);
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
    
   public void inRoom()
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
                break;
            case 4:
                inThisRoom.inRoomFour();
                break;
            case 5:
                inThisRoom.inRoomFive();
                break;
        }        
    }


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
        if (roomNumber == 5)
        {
            g.drawImage(inThisRoom.roomFiveFloor, 0, 0, this);
            g.drawImage(inThisRoom.roomFiveLocked, 340, 100,this);
            g.drawImage(inThisRoom.candleFlicker, 330, 332,this);
            g.drawImage(inThisRoom.candleFlicker, 580, 332,this);
            g.drawImage(inThisRoom.candleFlicker, 380, 332,this);
            g.drawImage(inThisRoom.candleFlicker, 530, 332,this);
            g.drawImage(inThisRoom.candleFlicker, 380, 382,this);
            g.drawImage(inThisRoom.candleFlicker, 530, 382,this);
            
            if (inThisRoom.r5Button1Press == true)
            {
                g.drawImage(inThisRoom.buttonActivated,173,375,this);
            }
            if (inThisRoom.r5Button2Press == true)
            {
                g.drawImage(inThisRoom.buttonActivated,442,579,this);
            }
            if (inThisRoom.r5Button3Press == true)
            {
                g.drawImage(inThisRoom.buttonActivated,711,376,this);
            }
        }
        if (roomNumber == 3)
            {
               g.drawImage(inThisRoom.roomThreeFloor, 0, 0, this);     
            }
        else
        {
            g.drawImage(floorTexture, 0, 0, this);
  
        }
       
        if(roomNumber == 2)
        {
            for(int i = 0; i < 5; i++)
            {
                switch(i)
                {
                    case 0:
                        g.drawImage(inThisRoom.lionList.get(i), 300, 300, this);
                        inThisRoom.lionRectums.set(i, new Rectangle(300,300,inThisRoom.lionList.get(i).getWidth(this),inThisRoom.lionList.get(i).getHeight(this)));
                        break;
                    case 1:
                        g.drawImage(inThisRoom.lionList.get(i), 100, 300, this);
                        inThisRoom.lionRectums.set(i, new Rectangle(100,300,inThisRoom.lionList.get(i).getWidth(this),inThisRoom.lionList.get(i).getHeight(this)));
                        break;
                    case 2:
                        g.drawImage(inThisRoom.lionList.get(i), 600, 300, this);
                        inThisRoom.lionRectums.set(i, new Rectangle(600,300,inThisRoom.lionList.get(i).getWidth(this),inThisRoom.lionList.get(i).getHeight(this)));
                        break;
                    case 3:
                        g.drawImage(inThisRoom.lionList.get(i), 725, 500, this);
                        inThisRoom.lionRectums.set(i, new Rectangle(725,500,inThisRoom.lionList.get(i).getWidth(this),inThisRoom.lionList.get(i).getHeight(this)));
                        break;
                    case 4:
                        g.drawImage(inThisRoom.lionList.get(i), 30, 30, this);
                        inThisRoom.lionRectums.set(i, new Rectangle(30,30,inThisRoom.lionList.get(i).getWidth(this),inThisRoom.lionList.get(i).getHeight(this)));
                        break;
                }
                if(player1.heroShape.intersects(inThisRoom.lionRectums.get(i)))
                {
                    if(i == 3)
                    {
                        inThisRoom.roomTwoItem = true;
                        inThisRoom.derp.setText("<html><center>You found the item!</center><html>");
                        inThisRoom.derp.setFont(inThisRoom.derp.getFont().deriveFont(20.0f));
                        inThisRoom.derp.setForeground(Color.RED);
                        this.add(inThisRoom.derp);
                        inThisRoom.derp.setBounds(new Rectangle((1005/2), (730/2), 100,100));
                        
                    }
                    if(i!=3)// this resets player location if you want to use it
                    {
                        player1.heroX = 486;
                        player1.heroY = 688-player1.heroHeight;
                        directionFacing = 1;
                    }
                }
            }
        }
        
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
        
         switch (directionFacing)
        {
            case 1:
                g.drawImage(player1.backStanding, player1.heroX-3, player1.heroY-20, this);
                break;
            case 2:
                g.drawImage(player1.leftStanding, player1.heroX, player1.heroY-20, this);
                break;                
            case 3:
                g.drawImage(player1.frontStanding, player1.heroX-3, player1.heroY-20, this);
                break;
            case 4:
                g.drawImage(player1.rightStanding, player1.heroX, player1.heroY-20, this);
                break;
        }
        
        Graphics2D g2d = (Graphics2D) g;
        if (roomNumber == 3)
        {
        g.drawImage(maze.minotaurImage, maze.minotaurX, maze.minotaurY, this);
        //g2d.draw(maze.minotaurShape);
            if (addMonster == false)
            {
                g2d.draw(maze.trigger);   
            }
        }
        
        if (roomNumber == 4)
        {
            g.setColor(badGuy.badGuyColor);
            g.fillRect(badGuy.objectX, badGuy.objectY, badGuy.objectWidth, badGuy.objectHeight);
            g2d.draw(badGuy.badGuyShape); // i like the way this makes the betty look like it has a bit of a tail
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object select = e.getSource();
        
        if (select == time)
        {
            switch(player1.dy)
            {
            case -1:
                directionFacing = 1;
                break;
            case 1:
                directionFacing = 3;
                break;
            }
            switch(player1.dx)
            {
                case -1:
                    directionFacing = 2;
                    break;
                case 1:
                    directionFacing = 4;
                    break;
            }        
            
            player1.heroX += player1.dx;
            player1.heroY += player1.dy;
        
    
        if (roomNumber == 4)
        {
            badGuy.badGuyShape = new Rectangle(badGuy.objectX, badGuy.objectY, badGuy.objectHeight, badGuy.objectWidth);
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
            
        player1.heroShape = new Rectangle(player1.heroX, player1.heroY, player1.heroWidth, player1.heroHeight);           
        player1.heroBounds();

        if (player1 != null)
        {
            player1.heroX += player1.dx;
            player1.heroY += player1.dy;
        }  

        if (roomNumber != 3)
        {
            addMonster = false;
            maze.minotaurX = 390;
            maze.minotaurY = 320;
            maze.count = 0;
        }
        if (roomNumber == 3)
        {
            if (player1.heroShape.intersects(maze.trigger))
            {
                addMonster = true;
            }

            if (addMonster == true)
            {
                maze.minotaurAtttack();
                maze.minotaurShape = new Rectangle( maze.minotaurX, maze.minotaurY, 50, 50);
                if(player1.heroShape.intersects(maze.minotaurShape))
                {
                    player1.health = player1.health-1;  
                    player1.heroX = 12;
                    player1.heroY = 325;  
                    addMonster = false;
                    maze.minotaurX = 390;
                    maze.minotaurY = 320;
                    maze.count = 0;
                }
            }   
        }
        if(roomNumber != 5)
        {
            inThisRoom.buttonReset();
        }
        if(roomNumber ==5)
        {
            
            switch(inThisRoom.x)
            {
                case 0:
                    if(player1.heroShape.intersects(inThisRoom.r5Button1) && !inThisRoom.r5Button2Press && !inThisRoom.r5Button3Press )
                    {
                        inThisRoom.r5Button1Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button2) && inThisRoom.r5Button1Press && !inThisRoom.r5Button3Press )
                    {
                        inThisRoom.r5Button2Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button3) && inThisRoom.r5Button1Press && inThisRoom.r5Button2Press )
                    {
                        inThisRoom.r5Button3Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button3) && !inThisRoom.r5Button2Press)
                    {
                        inThisRoom.buttonReset();
                    }
                break;
                case 1:
                    if(player1.heroShape.intersects(inThisRoom.r5Button2) && !inThisRoom.r5Button1Press && !inThisRoom.r5Button3Press )
                    {
                        inThisRoom.r5Button2Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button1) && inThisRoom.r5Button2Press && !inThisRoom.r5Button3Press )
                    {
                        inThisRoom.r5Button1Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button3) && inThisRoom.r5Button1Press && inThisRoom.r5Button2Press )
                    {
                        inThisRoom.r5Button3Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button3) && !inThisRoom.r5Button1Press)
                    {
                        inThisRoom.buttonReset();
                    }
                break;
                case 2:
                    if(player1.heroShape.intersects(inThisRoom.r5Button3) && !inThisRoom.r5Button2Press && !inThisRoom.r5Button1Press )
                    {
                        inThisRoom.r5Button3Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button1) && inThisRoom.r5Button3Press && !inThisRoom.r5Button2Press )
                    {
                        inThisRoom.r5Button1Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button2) && inThisRoom.r5Button1Press && inThisRoom.r5Button3Press )
                    {
                        inThisRoom.r5Button2Press = true;
                    }
                    if(player1.heroShape.intersects(inThisRoom.r5Button2) && !inThisRoom.r5Button1Press)
                    {
                        inThisRoom.buttonReset();
                    }
                break;
                
            }
//            if (player1.heroShape.intersects(inThisRoom.r5Button1))
//            {
//                inThisRoom.r5Button1Press = true;
//            }
//            if (player1.heroShape.intersects(inThisRoom.r5Button2))
//            {
//                inThisRoom.r5Button2Press = true;
//            }
//            if (player1.heroShape.intersects(inThisRoom.r5Button3))
//            {
//                inThisRoom.r5Button3Press = true;
//            }
        }    
            
        if (thisWall != null)
        {   
            collisionDelay = collisionDelay+1;
            if (collisionDelay >= 10)
            {
                for(int i = 0; i < inThisRoom.walls; i++)
                {
                    touchedWall = inThisRoom.wallList.get(i).getWallShape();
                
                    if (player1.heroShape.intersects(touchedWall))
                    {
                        switch(player1.dy)
                        {
                            case -1:
                                player1.dy = 0;
                                player1.heroY = player1.heroY+5;
                            break;
                            case 1:
                                player1.dy = 0;
                                player1.heroY = player1.heroY-5;
                            break;
                        }
                        switch(player1.dx)
                        {
                            case -1:
                                player1.dx = 0;
                                player1.heroX = player1.heroX+5;
                                break;
                            case 1:
                                player1.dx = 0;
                                player1.heroX = player1.heroX-5;
                                break;
                        }      
                    }  
                }
        }    
        }

        if (thisDoor != null)
        {
            collisionDelay = collisionDelay+1;
            if (collisionDelay >= 10)
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
                                    player1.heroX = 485;
                                    player1.heroY = 688 - player1.heroHeight;
                                    collisionDelay = 0;
                                }
                                if (inThisRoom.doorList.get(i).getDoorX() >= 980)
                                {
                                    roomNumber = 3;
                                    player1.heroX = 12;
                                    player1.heroY = 335;
                                    collisionDelay = 0;
                                }
                                if (inThisRoom.doorList.get(i).getDoorY() >= 680)
                                {
                                    roomNumber = 4;
                                    player1.heroX = 485;
                                    player1.heroY = 12;
                                    collisionDelay = 0;
                                }
                                if (inThisRoom.doorList.get(i).getDoorX() <= 10)
                                {
                                    roomNumber = 5;
                                    
                                    inThisRoom.r = Math.random();
                                    inThisRoom.r *= 3.0;
                                    inThisRoom.x = (int) inThisRoom.r;
                                    player1.heroX = 988 - player1.heroWidth;
                                    player1.heroY = 335;
                                    collisionDelay = 0;
                                }
                                break;
                            }
                            case 2:
                            {
                                roomNumber = 1;
                                player1.heroX = 485;
                                player1.heroY = 12;
                                collisionDelay = 0;
                                break;
                            }
                            case 3:
                            {
                                roomNumber = 1;
                                player1.heroX = 988 - player1.heroWidth;
                                player1.heroY = 335;  
                                collisionDelay = 0;
                                break;
                            }
                            case 4:
                            {
                                roomNumber = 1;
                                player1.heroX = 485;
                                player1.heroY = 688 - player1.heroHeight;
                                collisionDelay = 0;
                                break;
                            }
                            case 5:
                            {
                                roomNumber = 1;
                                player1.heroX = 12;
                                player1.heroY = 335;
                                collisionDelay = 0;
                                break;
                            }
                        }
                    }
                }
            }    
        }    
        inRoom();
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
        
        if (select == flicker && inThisRoom.roomFive)
        {
            inThisRoom.candleFlicker();
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
