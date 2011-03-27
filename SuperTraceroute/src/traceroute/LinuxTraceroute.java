package traceroute;

/**
 * Runs and parses traceroute in Linux. Tested on Ubuntu 10.10.
 */
public class LinuxTraceroute
{

	public LinuxTraceroute()
	{
		super();
	}

	public TracerouteItem parse(String line, boolean resolve)
	{
		String hostname, address;

		address = line.trim().split("\\s+")[1];
		hostname = address;
		
		return new TracerouteItem(hostname, address);
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
