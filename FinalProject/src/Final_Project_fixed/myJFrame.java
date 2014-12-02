package Final_Project_fixed;
import javax.swing.*;

public class myJFrame extends JFrame
{
    int frameWidth = 1000, frameHeight = 700;
            
	public myJFrame ()
	{
		super ("Intro page");
		
  	 	myJPanel mjp = new myJPanel();
       		add(mjp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                setResizable(false);
		setSize (frameWidth, frameHeight);
		setVisible(true);
	}
}
