package singleton;

public class Program {

	public static void main(String args[])
	{
		// ya no puedo instanciar por haber hecho el constructor private
		//DataCache cache = new DataCache();
		//DataCache cache2 = new DataCache();

		DataCache cache = DataCache.getInstance();
		DataCache cache2 = DataCache.getInstance();
		
		DataCache.getInstance().add("hola", "buenas tardes");
		
		cache.add("test", "Hola mundo");
		cache.add("test2", "Hola mundo2");
		cache2.add("test3", "Hola mundo3");
		cache2.add("test4", "Hola mundo4");
		
		
		
	}
}
