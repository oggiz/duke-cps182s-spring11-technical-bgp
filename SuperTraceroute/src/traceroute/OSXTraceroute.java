package traceroute;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.net.InetAddress;
import traceroute.TracerouteItem;

/**
 * Runs and parses traceroute in Mac OS X.
 */
public class OSXTraceroute implements ITraceroute
{

	private Runtime run;

	public OSXTraceroute()
	{
		run = Runtime.getRuntime();
	}

	public ArrayList<TracerouteItem> traceroute(String destination)
	{
		ArrayList<TracerouteItem> result = new ArrayList<TracerouteItem>();
		Process pr = null;
		String cmd = "traceroute " + destination;

		try
		{
			pr = run.exec(cmd);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		BufferedReader buf = new BufferedReader(new InputStreamReader(
				pr.getInputStream()));

		String line = "";
		try
		{
			while((line = buf.readLine()) != null)
			{
				String hostname, address;

				/*
				 * Extract some useful information from the traceroute output.
				 */
				hostname = line.split("\\s+")[1];
				address = line.split("\\s+")[2].replaceAll("\\(|\\)", "");

				TracerouteItem item = new TracerouteItem(hostname, address);

				result.add(item);
			}
		}
		catch(IOException e)
		{
			// should throw an exception
			return null;
		}

		return result;
	}

}
