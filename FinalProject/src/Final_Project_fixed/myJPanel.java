package Final_Project_fixed;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class myJPanel extends JPanel implements ActionListener
{
    SplashPanel splash;
    GamePanel gp1;
    OptionsPanel optionsPanel;
    CreditsPanel credits;
    HowToPanel howTo;
    WhichKey listener;
    Player player1;
    myJFrame mjf;   
        
    int frameWidth,frameHeight;
    int panelStatus = 1;
    
    public myJPanel()
    {
        super();
        setBackground(Color.BLACK);
        setLayout(null);
        this.setFocusable(true);
        listener = new WhichKey();
        addKeyListener(listener);
              
        splash = new SplashPanel();
        gp1 = new GamePanel();
        optionsPanel = new OptionsPanel(gp1);
        credits = new CreditsPanel();
        howTo = new HowToPanel();
                
        splash.setBounds(0, 0, 1000, 7000);
        splash.toGame.addActionListener(this);
        splash.toOptions.addActionListener(this);
        splash.toCredits.addActionListener(this);
        splash.toHowTo.addActionListener(this);
        howTo.back.addActionListener(this);
        add(splash);
        
        gp1.frameWidth = frameWidth;
        gp1.frameHeight = frameHeight;
                
        gp1.back.addActionListener(this);
        gp1.addKeyListener(listener);
                
        optionsPanel.back.addActionListener(this);
        optionsPanel.ok.addActionListener(this);
        
        credits.back.addActionListener(this);
    }
    public void removePanels()
    {
        optionsPanel.loadOptions();
        remove(splash);
        remove(credits);
        remove(optionsPanel);
        remove(gp1);
        remove(howTo);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object select = e.getSource();
        
        if (select == splash.toGame)
        {
            panelStatus=1;
        }
        if (select == splash.toOptions)
        {
            panelStatus=2;
        }
        if (select == splash.toCredits)
        {
            panelStatus=3;
        }
        if(select == gp1.back)
        {
            panelStatus = 4;
        }
        if(select == howTo.back)
        {
            panelStatus = 4;
        }
        if (select == optionsPanel.back)
        {
            optionsPanel.saveOptions();
            panelStatus = 4;
        }
        if (select == credits.back)
        {
            panelStatus = 4;
        }
        if(select == splash.toHowTo)
        {
            panelStatus = 5;
        }
        switch(panelStatus)
        {
            case 1: 
                removePanels();
                gp1.defaultChar();
                add(gp1);
                revalidate();
                repaint();
                break;
                    
            case 2:
                removePanels();
                add(optionsPanel);
                revalidate();
                repaint();
                break;
                
            case 3: 
                removePanels();
                add(credits);
                revalidate();
                repaint();
                break;
                
            case 4: 
                removePanels();
                add(splash);
                revalidate();
                repaint();
                break;
            case 5:
                removePanels();
                add(howTo);
                revalidate();
                repaint();
                break;
        }
        
        if (select == optionsPanel.ok) 
        {
            optionsPanel.saveOptions();
            gp1.createPlayer(optionsPanel.getGameOptions());

            removePanels();
            add(gp1);
            revalidate();
            repaint();

            // this needs to display the player1 info
            gp1.displaySetup();
                
        }
     
}

 public class WhichKey implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent keyInput)
    {
//nope
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int keyCode = e.getKeyCode();
        switch(keyCode)
        {
            case KeyEvent.VK_UP:
                gp1.player1.dy = -2;
                break;
            case KeyEvent.VK_DOWN:
                gp1.player1.dy = 2;
                break;
            case KeyEvent.VK_LEFT:
                gp1.player1.dx = -2;
                break;
            case KeyEvent.VK_RIGHT:
                gp1.player1.dx = 2;
                break;
            case KeyEvent.VK_SPACE:
                break;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent keyreleased) {
          int keyCode = keyreleased.getKeyCode();
        switch(keyCode)
        {
            case KeyEvent.VK_UP:
                gp1.player1.dy = 0;
                break;
            case KeyEvent.VK_DOWN:
                gp1.player1.dy = 0;
                break;
            case KeyEvent.VK_LEFT:
                gp1.player1.dx = 0;
                break;
            case KeyEvent.VK_RIGHT:
                gp1.player1.dx = 0;
                break;
        }
    }
}
}