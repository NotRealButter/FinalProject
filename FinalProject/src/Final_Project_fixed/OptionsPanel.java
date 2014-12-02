package Final_Project_fixed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.event.*;

public class OptionsPanel extends JPanel implements ChangeListener
{
    JButton back, content, ok;
    Color colorVar;
    JTextField nameSet;    
    JSlider colorSet;
    JSlider healthSet;
    myJPanel p1;
    private Options gameOptions;
    
    public OptionsPanel(GamePanel p1)
    {
        super();

        setLayout(null);
        setBackground(Color.blue);
        setOpaque(true);
        setBounds(0, 0, 1000, 700);
        
        gameOptions = new Options();
        loadOptions();
        content = new JButton("Options");
        content.setBounds(440, 0, 120, 20);
        add(content);
        back = new JButton("Back");
        back.setBounds(450, 580, 100, 20);
        add(back);

        nameSet = new JTextField(gameOptions.getName());
        nameSet.setBounds(390, 100, 220, 20);
        colorSet = new JSlider(1, 3, 1);
        colorVar = gameOptions.getColor();
        setBackground(colorVar);
        colorSet.setValue(gameOptions.getColorValue());
        colorSet.setBorder(BorderFactory.createTitledBorder("Set color with this slider"));
        colorSet.setPaintTicks(true);
        colorSet.setPaintLabels(true);
        colorSet.setSnapToTicks(true);
        colorSet.setMajorTickSpacing(1);
        colorSet.setBounds(390, 130, 220, 60);
        colorSet.addChangeListener(this);

        healthSet = new JSlider(3, 9, 3);
        switch(gameOptions.getStartingHealth())
        {
            case 3:
                healthSet.setValue(3);
                break;
            case 4:
                healthSet.setValue(4);
                break;
            case 5:
                healthSet.setValue(5);
                break;
            case 6:
                healthSet.setValue(6);
                break;
            case 7:
                healthSet.setValue(7);
                break;
            case 8:
                healthSet.setValue(8);
                break;
            case 9: 
                healthSet.setValue(9);
                break;
        }
        healthSet.setBorder(BorderFactory.createTitledBorder("Set starting health with this slider"));
        healthSet.setPaintTicks(true);
        healthSet.setPaintLabels(true);
        healthSet.setSnapToTicks(true);
        healthSet.setMajorTickSpacing(1);
        healthSet.setBounds(380, 200, 240, 60);     

        add(nameSet);
        add(colorSet);
        add(healthSet);

        ok = new JButton("OK");
        ok.setBounds (470, 270, 60, 30);
        add(ok);
    }
    public void saveOptions()
    {
        getGameOptions().setName(nameSet.getText());
        getGameOptions().setColor(colorVar);
        getGameOptions().setStartingHealth(healthSet.getValue());
        XML_240 x2 = new XML_240();
        x2.openWriterXML("Options.xml");
        x2.writeObject(getGameOptions());
        x2.closeWriterXML();
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
    @Override
    public void stateChanged(ChangeEvent c)
    {
        JSlider set = (JSlider)c.getSource();

        switch (colorSet.getValue())
        {
            case 1: colorVar = Color.blue;
                    break;
            case 2: colorVar = Color.green;
                    break;
            case 3: colorVar = Color.red;
        }
        setBackground(colorVar);
    }

    /**
     * @return the gameOptions
     */
    public Options getGameOptions() {
        return gameOptions;
    }
        
                
}