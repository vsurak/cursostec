package reducers;
import java.io.IOException;    
import java.util.Iterator;    
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;    
import org.apache.hadoop.mapred.OutputCollector;    
import org.apache.hadoop.mapred.Reducer;    
import org.apache.hadoop.mapred.Reporter; 
import java.util.TreeMap;


public class SalesReducer extends MapReduceBase implements Reducer<Text,LongWritable,Text,LongWritable> {	        
	public void reduce(Text keyToEmit, Iterator<LongWritable> values, OutputCollector<Text,LongWritable> output, Reporter reporter) throws IOException {    
        TreeMap<Long, String> top3 = new TreeMap<>();

		long presupuesto = 0L;
		String partes[] = values.next().toString().split("\t");
		String ofiPart = partes[0].split("/")[1]+"/"+partes[0].split("/")[2];
		Long budget =  Long.parseLong(partes[1]);
		
		while (values.hasNext()) {    
			presupuesto += values.next().get();
		}
		
		output.collect(keyToEmit, new LongWritable(presupuesto));  
	}    
}
