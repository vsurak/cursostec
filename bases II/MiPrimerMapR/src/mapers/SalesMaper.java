package mapers;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.FloatWritable;   
import org.apache.hadoop.io.Text;    
import org.apache.hadoop.mapred.MapReduceBase;    
import org.apache.hadoop.mapred.Mapper;    
import org.apache.hadoop.mapred.OutputCollector;    
import org.apache.hadoop.mapred.Reporter;  

public class SalesMaper extends MapReduceBase implements Mapper<LongWritable,Text,Text,FloatWritable> { 
    
    public void map(LongWritable key, Text lineFromFile, OutputCollector<Text,FloatWritable> output, Reporter reporter) throws IOException{    
    	String year;
    	float amount;
    	
    	String values[] = lineFromFile.toString().split(",");
    	amount = Float.parseFloat(values[1]); // paso el monto a float
    	
    	year = values[0].split("/")[2];
    	        
        output.collect(new Text(year), new FloatWritable(amount)); 
    }
}
