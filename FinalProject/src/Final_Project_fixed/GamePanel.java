package Final_Project_fixed;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener
{
    myJPanel p2;
    Player player1;
    BouncingBetty badGuy;
    private Options gameOptions;
    Room inThisRoom;
    
    Image floorTexture = Toolkit.getDefaultToolkit().getImage("images/floor.jpg");
    Image frontStanding = Toolkit.getDefaultToolkit().getImage("images/front/front standing.png");
    Image sideStanding = Toolkit.getDefaultToolkit().getImage("images/side/standing.png");
    Image rightSideRight = Toolkit.getDefaultToolkit().getImage("images/side/right right.png");
    Image rightSideLeft = Toolkit.getDefaultToolkit().getImage("images/side/right left.png");
    Image backStanding = Toolkit.getDefaultToolkit().getImage("images/back/back standing.png");
    Image backRight = Toolkit.getDefaultToolkit().getImage("images/back/back right.png");
    Image backLeft = Toolkit.getDefaultToolkit().getImage("images/back/back left.png");
            
    Rectangle baddieShape;
    Rectangle sword;
    
    JButton back, content;
    JLabel health, name;
    Graphics g;
    int flashcount = 0;
    int roomNumber = 1;
    
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
        
        content = new JButton("this is where the game is");
        content.setBounds(390, 500, 220, 20);
        add(content);
        back = new JButton("Back");
        back.setBounds(450, 520, 100, 20);
        add(back);

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
        
        badGuy = new BouncingBetty();
       
        
        //timers
        time = new Timer(10, this);
        time.addActionListener(this);
        time.start(); 

        flashing = new Timer(100, this);
        flashing.addActionListener(this);
        flashing.start();
  
        player1.heroShape = new Rectangle(player1.heroX, player1.heroY, player1.heroWidth, player1.heroHeight);
        displaySetup();

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
        g.drawImage(floorTexture, 0, 0, this);
        g.drawImage(floorTexture, 340, 0, this);
        g.drawImage(floorTexture, 0, 340, this);
        g.drawImage(floorTexture, 340, 340, this);
        g.drawImage(floorTexture, 680, 0, this);
        g.drawImage(floorTexture, 680, 340, this);
        
        g.setColor(Color.red);
        for(int i = 0; i < inThisRoom.walls; i++)
        {
            g.fillRect(inThisRoom.wallList.get(i).getWallX(), inThisRoom.wallList.get(i).getWallY(), inThisRoom.wallList.get(i).getWallWidth(), inThisRoom.wallList.get(i).getWallHeight());
        }
        if(gameOptions != null)
        {
            g.setColor(gameOptions.getColor());
        }
        else
        {
            g.setColor(Color.green);
        }
        
        g.fillRect(player1.heroX, player1.heroY, player1.heroWidth, player1.heroHeight);
        g.setColor(badGuy.badGuyColor);
        g.fillRect(badGuy.objectX,badGuy.objectY, badGuy.objectWidth, badGuy.objectHeight);
        player1.heroShape = new Rectangle(player1.heroX, player1.heroY, player1.heroWidth, player1.heroHeight);
        badGuy.badGuyShape = new Rectangle(badGuy.objectX, badGuy.objectY, badGuy.objectHeight, badGuy.objectWidth);
        //inThisRoom.wall1
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object select = e.getSource();
        
        if (select == time)
        {
            player1.heroX += player1.dx;
            player1.heroY += player1.dy;
            badGuy.bouncingBounds();
            badGuy.objectX += badGuy.objectdx;
            badGuy.objectY += badGuy.objectdy;            
            player1.heroBounds();
            
            if (player1 != null)
            {
                player1.heroX += player1.dx;
                player1.heroY += player1.dy;
            }  
            if (player1.heroShape.intersects(badGuy.badGuyShape))
            {
                if(badGuy.objectX > player1.heroX+player1.heroWidth)
                {
                    badGuy.objectdx = 1;
                }
                 if(badGuy.objectX < player1.heroX)
                {
                    badGuy.objectdx = -1;
                }
                  if(badGuy.objectY < player1.heroY)
                {
                    badGuy.objectdy = 1;
                }
                   if(badGuy.objectY > player1.heroY)
                {
                    badGuy.objectdy = -1;
                }
            }
            repaint();            
            revalidate();
        }  
        if (select == flashing)
        {
            badGuy.colorFlash();
        }
    }

    /**
     * @param gameOptions the gameOptions to set
     */
    public void setGameOptions(Options gameOptions) {
        this.gameOptions = gameOptions;
    }

    
}
