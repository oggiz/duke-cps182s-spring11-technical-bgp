package traceroute;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.net.InetAddress;
import traceroute.TracerouteItem;

/**
 * Runs and parses traceroute in Mac OS X. Tested on OS X 10.6.7.
 */
public class OSXTraceroute extends Traceroute
{

	public OSXTraceroute()
	{
		super();
	}

	public TracerouteItem parse(String line)
	{
		String hostname, address;

		hostname = line.split("\\s+")[1];
		address = line.split("\\s+")[2].replaceAll("\\(|\\)", "");

		return new TracerouteItem(hostname, address);
	}

	public String getTracerouteCommand(String destination)
	{
		return "traceroute " + destination;
	}

}
