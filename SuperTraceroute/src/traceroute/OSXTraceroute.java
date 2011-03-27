package traceroute;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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

	public TracerouteItem traceroute(InetAddress address)
	{
		Process pr = null;
		String cmd = "traceroute " + address.toString();
		
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
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
