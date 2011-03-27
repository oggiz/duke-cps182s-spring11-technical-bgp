package main;

import traceroute.ITraceroute;
import traceroute.OSXTraceroute;
import traceroute.TracerouteItem;
import java.util.ArrayList;

/**
 * The main program used to invoke the application.
 */
public class Main
{

	public static void main(String[] args)
	{
		ITraceroute tr = new OSXTraceroute();
		
		ArrayList<TracerouteItem> l = tr.traceroute("www.google.com");
		
		for(TracerouteItem item : l)
		{
			System.out.println(item.toString());
		}
	}

}
