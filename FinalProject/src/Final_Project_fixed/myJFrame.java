package Final_Project_fixed;
import javax.swing.*;

public class myJFrame extends JFrame
{

    int frameWidth = 1005  , frameHeight = 730;
            
	public myJFrame ()
	{
		super ("Intro page");
		
  	 	myJPanel mjp = new myJPanel();
                mjp.frameWidth = frameWidth;
                mjp.frameHeight = frameHeight;
       		add(mjp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                setResizable(false);
		setSize (frameWidth, frameHeight);
		setVisible(true);
	}
}
