package traceroute;

/**
 * Runs and parses traceroute in Windows. Tested on Windows 7.
 */
public class WindowsTraceroute extends Traceroute
{

	public WindowsTraceroute()
	{
		super();

		// debug
		System.out.println("WindowsTraceroute instantiated");
	}

	@Override
	public String getRegex()
	{
		/*
		 * A typical traceroute hop in Windows looks like:
		 *   4     7 ms    12 ms    14 ms  24.93.64.84
		 */
		return "\\s*\\d+\\s+.*\\s+(\\d+\\.\\d+\\.\\d+\\.\\d+).*";

		// TODO: account for hops with dropped packets
	}

	@Override
	public String getTracerouteCommand(String destination, boolean resolve)
	{
		/*
		 * For now, do not resolve hostnames.
		 */

		if(resolve)
		{
			return "tracert " + destination;
		}
		else
		{
			return System.getenv("windir") +
			"\\system32\\tracert.exe -d " + destination;
		}
	}

}
