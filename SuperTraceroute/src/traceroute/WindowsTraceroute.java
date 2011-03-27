package traceroute;

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
	
	public TracerouteItem parse(String line, boolean resolve)
	{
		String hostname, address;
		
		String regex = ".*[\\s+|\\[](\\d+\\.\\d+\\.\\d+\\.\\d+)[$|\\s+|\\]].*";
		
		address = line.replaceAll(regex, "$1");
		hostname = address;
		
		return new TracerouteItem(hostname, address);
	}
	
	public String getTracerouteCommand(String destination, boolean resolve)
	{
		/*
		 * For now, do not resolve hostnames.
		 */
		
		if(resolve) return "tracert " + destination;
		else return "tracert -d " + destination;
	}

}
