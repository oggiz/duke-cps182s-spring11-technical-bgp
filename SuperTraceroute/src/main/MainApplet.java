package main;

import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.applet.Applet;
import traceroute.*;
import exceptions.*;

/**
 * The main applet that runs in the client's browser.
 */
public class MainApplet extends Applet
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
					    /*
					     * Do a traceroute to www.duke.edu.
					     */
						Traceroute tr = getOSTraceroute();
						ArrayList<Hop> list = 
							tr.traceroute("www.duke.edu", false);
						
						/*
						 * Print hops.
						 */
						for(Hop l : list)
						{
							System.out.println(l.toString());
						}
						
						JLabel l = new JLabel("Hops: " + list.size());
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
			 * TODO: figure out what could have gone wrong to get here
			 */
			e.printStackTrace();
		}

	}

	/**
	 * Finds out what operating system the client is running and return the
	 * correct kind of Traceroute.
	 * @return the right Traceroute
	 * @throws OSException
	 */
	public static Traceroute getOSTraceroute() throws OSException
	{
		/*
		 * Attempt to identify the operating system.
		 */
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
