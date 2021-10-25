package mapers;
import java.io.IOException;    
import org.apache.hadoop.io.IntWritable;    
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;    
import org.apache.hadoop.io.Text;    
import org.apache.hadoop.mapred.MapReduceBase;    
import org.apache.hadoop.mapred.Mapper;    
import org.apache.hadoop.mapred.OutputCollector;    
import org.apache.hadoop.mapred.Reporter;  

public class SalesMaper extends MapReduceBase implements Mapper<LongWritable,Text,IntWritable,FloatWritable> {
    
    public void map(LongWritable key, Text value, OutputCollector<IntWritable,FloatWritable> output, Reporter reporter) throws IOException{    
        String line = value.toString();
        
        String values[] = line.split(",");  // [12/09/2016, 5493105.35]
        String year = values[0].split("/")[2];  // [12, 09, 2016]
        IntWritable intYear = new IntWritable(Integer.valueOf(year));
        FloatWritable amount = new FloatWritable( Float.valueOf(values[1]));
        
        output.collect(intYear, amount); 
    }
}
