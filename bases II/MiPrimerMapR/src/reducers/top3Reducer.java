package reducers;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class top3Reducer extends MapReduceBase implements Reducer<Text, Text, Text, LongWritable> {
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, LongWritable> output, Reporter reporter) throws IOException {
        TreeMap<Long, String> top3 = new TreeMap<>();
        while (values.hasNext()) {
            String[] parts = values.next().toString().split("/");
            String officePartida = parts[0] + "/" + parts[1];
            long budget = Long.parseLong(parts[2]);
            top3.put(budget, officePartida);
            if (top3.size() > 3) {
                top3.remove(top3.firstKey());
            }
        }
        for (Map.Entry<Long, String> entry : top3.descendingMap().entrySet()) {
            output.collect(new Text(key.toString() + "/" + entry.getValue()), new LongWritable(entry.getKey()));
        }
    }
}