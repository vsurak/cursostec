package reducers;
import java.io.IOException;    
import java.util.Iterator;    
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.MapReduceBase;    
import org.apache.hadoop.mapred.OutputCollector;    
import org.apache.hadoop.mapred.Reducer;    
import org.apache.hadoop.mapred.Reporter;  

public class SalesReducer extends MapReduceBase implements Reducer<Text,MapWritable,Text,Text> {	        
	public void reduce(Text metayear, Iterator<MapWritable> values, OutputCollector<Text,Text> output, Reporter reporter) throws IOException {    

		MapWritable timecoins;
		int time = 0;
		int coins = 0;
		
		while (values.hasNext()) {    
			timecoins = values.next();
			
			time+= ((IntWritable)timecoins.get(new Text("minutes"))).get();
			coins+= ((IntWritable)timecoins.get(new Text("coins"))).get();
		}
		
		time/=60; // pasar a horas
		
		String metakey[] = metayear.toString().split(",");
		Text yeartimecointext = new Text(","+metakey[1]+","+Integer.toString(time)+","+Integer.toString(coins));
		output.collect(new Text(metakey[0]), yeartimecointext);  
	}    
}
