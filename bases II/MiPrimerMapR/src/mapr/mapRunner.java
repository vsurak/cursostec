package mapr;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import mapers.SalesMaper;
import mapers.top3Maper;
import reducers.SalesReducer;
import reducers.Top3Reducer;


public class mapRunner {
    public static void main(String[] args) throws IOException {
        // Primera fase de MapReduce
        JobConf conf1 = new JobConf(mapr.mapRunner.class);
        conf1.setJobName("Total ventas por año");

        conf1.setInputFormat(TextInputFormat.class);
        conf1.setOutputFormat(TextOutputFormat.class);

        conf1.setMapOutputKeyClass(Text.class);
        conf1.setMapOutputValueClass(LongWritable.class);
        conf1.setMapperClass(SalesMaper.class);

        conf1.setOutputKeyClass(Text.class);
        conf1.setOutputValueClass(LongWritable.class);
        conf1.setReducerClass(SalesReducer.class);

        conf1.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        FileInputFormat.setInputPaths(conf1, new Path("/data/presupuesto.csv"));
        FileOutputFormat.setOutputPath(conf1, new Path("/ventas/anyos"));
        JobClient.runJob(conf1);

        // Segunda fase de MapReduce
        JobConf conf2 = new JobConf(mapr.mapRunner.class);
        conf2.setJobName("Top 3 ventas por año");

        conf2.setInputFormat(TextInputFormat.class);
        conf2.setOutputFormat(TextOutputFormat.class);

        conf2.setMapOutputKeyClass(Text.class);
        conf2.setMapOutputValueClass(LongWritable.class);
        conf2.setMapperClass(top3Maper.class);

        conf2.setOutputKeyClass(Text.class);
        conf2.setOutputValueClass(LongWritable.class);
        conf2.setReducerClass(Top3Reducer.class);

        conf2.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        FileInputFormat.setInputPaths(conf2, new Path("/ventas/anyos/part-00000"));
        FileOutputFormat.setOutputPath(conf2, new Path("/ventas/top3"));
        JobClient.runJob(conf2);
    }
}
