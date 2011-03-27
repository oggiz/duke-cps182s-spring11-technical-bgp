package traceroute;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * A class that represents one line of output (that is, one hop) from running
 * traceroute.
 */
public class Hop
{

	/*
	 * The IP address of this hop.
	 */
	private InetAddress address;

	/*
	 * The hostname, if resolvable, of this hop. If not resolvable, then it is
	 * the same as the IP address.
	 */
	private String hostname;

	public Hop(String destination, String address)
	{
		hostname = destination;

		try
		{
			/*
			 * Attempt to parse the IP address.
			 */
			this.address = InetAddress.getByName(address);
		}
		catch(UnknownHostException e)
		{
			/*
			 * The IP address is ill-formatted.
			 */
			e.printStackTrace();
		}
	}

	public String toString()
	{
		return hostname + ", " + address.getHostAddress();
	}

}
