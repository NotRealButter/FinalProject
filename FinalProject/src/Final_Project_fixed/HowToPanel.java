/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project_fixed;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jackson Hofmann
 */
public class HowToPanel extends JPanel
{
    JButton back;
    public HowToPanel()
    {
        super();
        setLayout(null);
        setOpaque(true);
        setBounds(0, 0, 1000, 700);
        back = new JButton("Back");
        add(back);
        back.setBounds(new Rectangle(10,10,100,50));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        Image floorTexture = Toolkit.getDefaultToolkit().getImage("images/instructions.png");
        g.drawImage(floorTexture, 0, 0, this);
    }
    
}
