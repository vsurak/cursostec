package mapers;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class top3Maper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {


    public void map(LongWritable key, Text lineFromFile, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        String S = lineFromFile.toString();
        String[] str = S.split("/");
        
        String llave = str[0]+"/"+str[1]+"/";
        String valor = str[2].replaceAll(" +", " ");
        
        output.collect(new Text(llave), new Text(valor));


        
    }
}
