package singleton;

import java.util.Hashtable;

public class DataCache
{
	private static DataCache Instance;
	private Hashtable<String, String> Cache;
	
	private DataCache()
	{
		
	}
	
	public synchronized static DataCache getInstance()
	{
		if (Instance==null)
		{
			Instance = new DataCache();
		}
		return Instance;
	}
	
	
	public String get(String pKey)
	{
		return Cache.get(pKey);
	}
	
	public void add(String pKey, String pValue)
	{
		if (!Cache.containsKey(pKey)) {
			Cache.put(pKey, pValue);
		}
	}
}
