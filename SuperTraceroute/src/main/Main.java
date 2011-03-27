package main;

import traceroute.ITraceroute;
import traceroute.OSXTraceroute;
import traceroute.TracerouteItem;

/**
 * The main program used to invoke the application.
 */
public class Main
{

	public static void main(String[] args)
	{
		ITraceroute tr = new OSXTraceroute();
		
		TracerouteItem item = tr.traceroute();
	}

}
