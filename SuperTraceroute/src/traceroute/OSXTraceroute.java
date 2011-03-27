package traceroute;

import traceroute.Hop;

/**
 * Runs and parses traceroute in Mac OS X. Tested on OS X 10.6.7.
 */
public class OSXTraceroute extends Traceroute
{

	public OSXTraceroute()
	{
		super();
	}

	public Hop parse(String line, boolean resolve)
	{
		String hostname, address;

		hostname = line.split("\\s+")[1];
		address = line.split("\\s+")[2].replaceAll("\\(|\\)", "");

		return new Hop(hostname, address);
	}

	public String getTracerouteCommand(String destination, boolean resolve)
	{
		/*
		 * For now, do not resolve hostnames.
		 */
		resolve = false;
		
		if(resolve) return "traceroute " + destination;
		else return "traceroute -n " + destination;
	}

}
