package reducers;
import java.io.IOException;    
import java.util.Iterator;    
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapred.MapReduceBase;    
import org.apache.hadoop.mapred.OutputCollector;    
import org.apache.hadoop.mapred.Reducer;    
import org.apache.hadoop.mapred.Reporter;  

public class SalesReducer extends MapReduceBase implements Reducer<Text,FloatWritable,Text,FloatWritable> {	        
	public void reduce(Text year, Iterator<FloatWritable> values, OutputCollector<Text,FloatWritable> output, Reporter reporter) throws IOException {    

		float totalPerYear = 0.0f;
		
		while (values.hasNext()) {    
			totalPerYear += values.next().get();
		}
		
		output.collect(year, new FloatWritable(totalPerYear));  
	}    
}
