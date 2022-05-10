package reducers;
import java.io.IOException;    
import java.util.Iterator;    
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapred.MapReduceBase;    
import org.apache.hadoop.mapred.OutputCollector;    
import org.apache.hadoop.mapred.Reducer;    
import org.apache.hadoop.mapred.Reporter;    

public class SalesReducer extends MapReduceBase implements Reducer<IntWritable,FloatWritable,IntWritable,FloatWritable> {	        
	public void reduce(IntWritable year, Iterator<FloatWritable> values, OutputCollector<IntWritable,FloatWritable> output, Reporter reporter) throws IOException {    
		float salesSum=0.0f;
		
		while (values.hasNext()) {    
			salesSum+=values.next().get(); 
		}    
		
		output.collect(year, new FloatWritable(salesSum));    
	}    
}
