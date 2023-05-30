package reducers;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Top3Reducer extends MapReduceBase implements Reducer<Text, Text, Text, LongWritable> {
    
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, LongWritable> output, Reporter reporter) throws IOException {
        TreeMap<Long, String> top3Budgets= new TreeMap<Long, String>();
        while (values.hasNext()) {
            String value = values.next().toString();
            String part[] = value.split(" ");
            String tmp[] = part[part.length-1].split("\\s+");
            Long presupuesto = Long.parseLong(tmp[tmp.length-1].trim());

            // Agregar el presupuesto total junto con la oficina y la partida al TreeMap
            // Mantener solo los 3 mayores presupuestos
            top3Budgets.put(presupuesto, key.toString() + value.replaceAll(presupuesto.toString(), " "));
            if (top3Budgets.size() > 3) {
                top3Budgets.remove(top3Budgets.firstKey());
            }
        }
        
        for (Map.Entry<Long, String> entry : top3Budgets.descendingMap().entrySet()) {
            output.collect(new Text(entry.getValue()), new LongWritable(entry.getKey()));
        }
    }
}
