package main;

import traceroute.Traceroute;
import traceroute.WindowsTraceroute;
import traceroute.TracerouteItem;
import java.util.ArrayList;

/**
 * The main program used to invoke the application.
 */
public class Main
{

	public static void main(String[] args)
	{
		Traceroute tr = new WindowsTraceroute();
		
		ArrayList<TracerouteItem> l = tr.traceroute("www.google.com", false);
		
		for(TracerouteItem item : l)
		{
			System.out.println(item.toString());
		}
	}

}
