package traceroute;

import java.net.InetAddress;

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
	 * The hostname, if resolvable, of this hop.
	 */
	private String hostname;

}
