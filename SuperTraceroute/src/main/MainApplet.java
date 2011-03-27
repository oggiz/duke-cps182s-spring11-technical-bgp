package main;

import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import traceroute.*;
import exceptions.*;

/**
 * The applet that runs in the client's browser.
 */
public class MainApplet extends JApplet
{

	public void init()
	{
		/*
		 * This try-catch cruft is something copied from Oracle's tutorials.
		 * Holy indentation, Batman!
		 */
		try
		{
			SwingUtilities.invokeAndWait(new Runnable()
			{
				public void run()
				{
					try
					{
						Traceroute tr = getOSTraceroute();
						ArrayList<Hop> list = 
							tr.traceroute("www.duke.edu", false);
						
						for(Hop l : list)
						{
							System.out.println(l.toString());
						}
						
						JLabel l = new JLabel("Count: " + list.size());
						add(l);
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			});
		}
		catch(Exception e)
		{
			/*
			 * Don't know what can go wrong to get here...
			 */
			e.printStackTrace();
		}

	}

	private Traceroute getOSTraceroute() throws OSException
	{
		String os = System.getProperty("os.name").toLowerCase();
		if(os.matches(".*windows.*")) return new WindowsTraceroute();
		else if(os.matches(".*linux.*")) return new LinuxTraceroute();
		else if(os.matches(".*os x.*")) return new OSXTraceroute();
		else
		{
			/*
			 * Operating system cannot be identified.
			 */
			throw new OSException();
		}
	}

}
