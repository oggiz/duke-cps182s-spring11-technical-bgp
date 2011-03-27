package traceroute;

/**
 * Runs and parses traceroute in Linux. Tested on Ubuntu 10.10.
 */
public class LinuxTraceroute extends Traceroute
{

	public LinuxTraceroute()
	{
		super();
	}
	
	@Override
	public String getRegex()
	{
		/*
		 * A typical traceroute hop in Linux looks like:
		 *  9  64.125.26.133  41.395 ms  41.375 ms  40.928 ms
		 */
		return "\\s*\\d+\\s+(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+.*";
		
		// TODO: account for hops with dropped packets
	}

	@Override
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
