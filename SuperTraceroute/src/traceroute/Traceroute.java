package traceroute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import traceroute.Hop;

/**
 * An abstract class for running and parsing traceroute. Subclasses will
 * implement what is required for each operating system.
 */
public abstract class Traceroute
{

	/*
	 * The runtime.
	 */
	private Runtime run;

	/**
	 * Initialize the runtime so that commands may be run.
	 */
	public Traceroute()
	{
		run = Runtime.getRuntime();
	}

	/**
	 * Runs traceroute, parses output and returns a list of hops.
	 * @param destination the destination hostname or IP
	 * @param resolve whether to resolve hostnames or not
	 * @return list of hops
	 */
	public ArrayList<Hop> traceroute(String destination, boolean resolve)
	{
		/*
		 * We will be adding TracerouteItems to the result array.
		 */
		ArrayList<Hop> result = new ArrayList<Hop>();

		/*
		 * This is the process that will execute the command.
		 */
		Process pr = null;

		/*
		 * Obtain the correct command to run for this operating system. 
		 */
		String cmd = getTracerouteCommand(destination, resolve);

		// debug
		System.out.println("before running exec");
		
		/*
		 * Execute the traceroute command.
		 */
		try
		{
			pr = run.exec(cmd);
		}
		catch(IOException e)
		{
			/*
			 * Something went wrong...
			 */
			e.printStackTrace();
		}
		
		/*
		 * Wait for the traceroute process to finish.
		 */
		try
		{
			pr.waitFor();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		/*
		 * Prepare a BufferedReader to read output from traceroute.
		 */
		BufferedReader buf = new BufferedReader(new InputStreamReader(
				pr.getInputStream()));

		/*
		 * Attempt to parse each line and create a corresponding TracerouteItem
		 * object.
		 */
		String line = "";
		try
		{
			String regex = getRegex();
			while((line = buf.readLine()) != null && line.matches(regex))
			{
				System.out.println("in while loop");
				String hostname, address;
				
				address = line.replaceAll(regex, "$1");
				hostname = address;
				
				result.add(new Hop(hostname, address));
			}
		}
		catch(IOException e)
		{
			// TODO: how did we get here?
			return null;
		}

		/*
		 * We are finished.
		 */
		return result;
	}

	public abstract String parseHostname(String line, boolean resolve);

	public abstract String parseAddress(String line, boolean resolve);
	
	/**
	 * Gets the regular expression to be used in parsing the output.
	 * @return the regular expression
	 */
	public abstract String getRegex();

	/**
	 * Gets the proper traceroute command to run for this operating system.
	 * @param destination the destination hostname or IP
	 * @param resolve whether to resolve hostnames or not
	 * @return the proper traceroute command
	 */
	public abstract String getTracerouteCommand(String destination,
			boolean resolve);

}
