package traceroute;

import java.util.ArrayList;
import java.net.InetAddress;

/**
 * 
 */
public interface ITraceroute
{

	public ArrayList<TracerouteItem> traceroute(String destination);

}
