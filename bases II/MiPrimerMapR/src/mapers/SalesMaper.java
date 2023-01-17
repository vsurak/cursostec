package mapers;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;   
import org.apache.hadoop.io.MapWritable;   
import org.apache.hadoop.io.Text;    
import org.apache.hadoop.mapred.MapReduceBase;    
import org.apache.hadoop.mapred.Mapper;    
import org.apache.hadoop.mapred.OutputCollector;    
import org.apache.hadoop.mapred.Reporter;  
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SalesMaper extends MapReduceBase implements Mapper<LongWritable,Text,Text,MapWritable> { 
    
    public void map(LongWritable key, Text value, OutputCollector<Text,MapWritable> output, Reporter reporter) throws IOException{    
        JSONParser parser = new JSONParser();
        JSONObject json =  null;
        MapWritable timecoinsmap = new MapWritable();
        
        try {
            json = (JSONObject)parser.parse(value.toString());        	
        } catch (ParseException exp) {
        	exp.printStackTrace();
        }
        
        String year = ((String)json.get("posttime")).split("-")[0];        
        Text metayear = new Text((String)json.get("metaverso")+","+year);
        
        timecoinsmap.put(new Text("coins"), new IntWritable(Integer.parseInt(json.get("coinsspent").toString())));
        timecoinsmap.put(new Text("minutes"), new IntWritable(Integer.parseInt(json.get("timespent").toString())));
        
        
        output.collect(metayear, timecoinsmap); 
    }
}
