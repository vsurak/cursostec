package mapers;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class top3Mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
    public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        String[] values = value.toString().split("/");
        String year = values[0];
        String office = values[1];
        String item = values[2];
        Long budget = Long.parseLong(values[3]);
        output.collect(new Text(year), new Text(office + "/" + item + "/" + budget));
    }
}