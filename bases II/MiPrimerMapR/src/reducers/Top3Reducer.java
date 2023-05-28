package reducers;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Top3Reducer extends MapReduceBase implements Reducer<Text, FloatWritable, Text, FloatWritable> {
    private TreeMap<Float, String> top3Budgets;

    @Override
    public void configure(org.apache.hadoop.mapred.JobConf job) {
        top3Budgets = new TreeMap<Float, String>();
    }

    public void reduce(Text key, Iterator<FloatWritable> values, OutputCollector<Text, FloatWritable> output,
            Reporter reporter) throws IOException {
        float totalBudget = 0.0f;
        while (values.hasNext()) {
            totalBudget += values.next().get();
        }

        // Agregar el presupuesto total junto con la oficina y la partida al TreeMap
        // Mantener solo los 3 mayores presupuestos
        top3Budgets.put(totalBudget, key.toString());
        if (top3Budgets.size() > 3) {
            top3Budgets.remove(top3Budgets.firstKey());
        }
    }


}
