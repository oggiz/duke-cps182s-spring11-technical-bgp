package traceroute;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * A class that represents one line of output (that is, one hop) from running
 * traceroute.
 */
public class TracerouteItem
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

	public TracerouteItem(String hostname, String address)
	{
		this.hostname = hostname;
		try
		{
			this.address = InetAddress.getByName(address);
		}
		catch(UnknownHostException e)
		{
			/*
			 * The IP address must be ill-formatted.
			 */
			e.printStackTrace();
		}
	}

	public String toString()
	{
		return hostname + ", " + address.getHostAddress();
	}

}
