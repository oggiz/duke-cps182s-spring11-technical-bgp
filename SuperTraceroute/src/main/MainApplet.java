package main;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * The applet that runs in the client's browser.
 */
public class MainApplet extends JApplet
{

	public void init()
	{
		try
		{
			SwingUtilities.invokeAndWait(new Runnable()
			{
				public void run()
				{
					String os = System.getProperty("os.name");
					JLabel l = new JLabel(os);
					add(l);
				}
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
