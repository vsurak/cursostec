package mapr;

import java.io.IOException;   
import org.apache.hadoop.fs.Path;    
import org.apache.hadoop.io.IntWritable;    
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapred.FileInputFormat;    
import org.apache.hadoop.mapred.FileOutputFormat;    
import org.apache.hadoop.mapred.JobClient;    
import org.apache.hadoop.mapred.JobConf;    
import org.apache.hadoop.mapred.TextInputFormat;    
import org.apache.hadoop.mapred.TextOutputFormat; 
import mapers.SalesMaper;
import reducers.SalesReducer;


public class maprunner {
	public static void main(String[] args) throws IOException{    
	    JobConf conf = new JobConf(mapr.maprunner.class);    
	    conf.setJobName("Ejemplo de sales");    
	    conf.setOutputKeyClass(IntWritable.class);    
	    conf.setOutputValueClass(FloatWritable.class);            
	    conf.setMapperClass(SalesMaper.class); 
	    conf.setReducerClass(SalesReducer.class);         
	    conf.setInputFormat(TextInputFormat.class);    
	    conf.setOutputFormat(TextOutputFormat.class);    
	    conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
	    FileInputFormat.setInputPaths(conf,new Path("/datainput/datasales.dat"));    
	    FileOutputFormat.setOutputPath(conf,new Path("/dataoutput"));
	    JobClient.runJob(conf);    
	}    
}
