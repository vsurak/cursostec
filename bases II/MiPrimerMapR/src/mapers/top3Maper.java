package mapers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class top3Maper extends MapReduceBase implements Mapper<LongWritable, Text, Text, LongWritable> {

    public void map(LongWritable key, Text lineFromFile, OutputCollector<Text, LongWritable> output, Reporter reporter) throws IOException {
        Long amount;
        String S = lineFromFile.toString();
        String[] amountS = S.split(" ");
        String lastElement = amountS[amountS.length - 1]; // Eliminar espacios en blanco
        amount = Long.parseLong(lastElement);

        
        output.collect(new Text(S.replaceAll(amount+"", "")), new LongWritable(amount));
    }
}
