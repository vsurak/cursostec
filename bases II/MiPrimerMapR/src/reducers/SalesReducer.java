package reducers;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;


public class SalesReducer extends MapReduceBase implements Reducer<Text,LongWritable,Text,LongWritable> {
	
	public void reduce(Text keyToEmit, Iterator<LongWritable> values, OutputCollector<Text,LongWritable> output, Reporter reporter) throws IOException {    

		long presupuesto = 0L;
		while (values.hasNext()) {    
			presupuesto += values.next().get();
		}
		
		output.collect(keyToEmit, new LongWritable(presupuesto));  
	}    
}
