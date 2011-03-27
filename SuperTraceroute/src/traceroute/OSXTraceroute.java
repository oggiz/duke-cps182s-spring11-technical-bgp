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

	public String getRegex()
	{
		/*
		 * A typical traceroute hop in OS X looks like:
		 *  5  24.93.64.25  14.747 ms  14.311 ms  14.104 ms
		 */
		return "\\s*\\d+\\s+(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+.*";
		
		// TODO: account for hops with dropped packets 
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
