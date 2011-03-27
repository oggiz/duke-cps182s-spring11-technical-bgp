package traceroute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import traceroute.TracerouteItem;

/**
 * Runs and parses traceroute in Windows. Tested on Windows 7.
 */
public class WindowsTraceroute extends Traceroute
{

	public WindowsTraceroute()
	{
		super();
	}
	
	public TracerouteItem parse(String line)
	{
		String hostname, address;
	}
	
	public String getTracerouteCommand(String destination)
	{
		return "tracert " + destination;
	}

}
