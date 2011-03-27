package main;

import traceroute.Traceroute;
import traceroute.WindowsTraceroute;
import traceroute.Hop;
import java.util.ArrayList;

/**
 * The main program used to invoke the application.
 */
public class Main
{

	public static void main(String[] args)
	{
		Traceroute tr = new WindowsTraceroute();
		
		ArrayList<Hop> l = tr.traceroute("www.google.com", false);
		
		for(Hop item : l)
		{
			System.out.println(item.toString());
		}
	}

}
