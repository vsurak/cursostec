package mapr;

import java.io.IOException;   
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.FileInputFormat;    
import org.apache.hadoop.mapred.FileOutputFormat;    
import org.apache.hadoop.mapred.JobClient;    
import org.apache.hadoop.mapred.JobConf;    
import org.apache.hadoop.mapred.TextInputFormat;    
import org.apache.hadoop.mapred.TextOutputFormat; 
import mapers.budgetMaper;
import reducers.budgetReducer;


public class maprunner {
	public static void main(String[] args) throws IOException{    
	    JobConf confBudget = new JobConf(mapr.maprunner.class);    
	    confBudget.setJobName("Total budget por año");

	    // inputs
	    confBudget.setInputFormat(TextInputFormat.class);  // el formato de la fuente  
	    confBudget.setOutputFormat(TextOutputFormat.class);   // el formato con que lo paso al mapper
	    
	    // maper
	    confBudget.setMapOutputKeyClass(Text.class);
	    confBudget.setMapOutputValueClass(LongWritable.class);	    
	    confBudget.setMapperClass(budgetMaper.class);
	    
	    // reducer
	    confBudget.setOutputKeyClass(Text.class);      
	    confBudget.setOutputValueClass(LongWritable.class);
	    confBudget.setReducerClass(budgetReducer.class);     
	    
	    confBudget.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
	    FileInputFormat.setInputPaths(confBudget,new Path("/data/presupuesto.csv"));    
	    FileOutputFormat.setOutputPath(confBudget,new Path("/ventas/anyos"));
	    JobClient.runJob(confBudget); // indicamos a yarn que ponga en cola este job
	    
	    // a partir de acá se hace el top 3
	    JobConf confTop3 = new JobConf(mapr.maprunner.class);    
	    confTop3.setJobName("Top 3 por año");

	    // inputs
	    confTop3.setInputFormat(TextInputFormat.class);  // el formato de la fuente  
	    confTop3.setOutputFormat(TextOutputFormat.class);   // el formato con que lo paso al mapper
	    
	    // maper
	    confTop3.setMapOutputKeyClass(Text.class);
	    confTop3.setMapOutputValueClass(LongWritable.class);	    
	    confTop3.setMapperClass(budgetMaper.class);
	    
	    // reducer
	    confTop3.setOutputKeyClass(Text.class);      
	    confTop3.setOutputValueClass(LongWritable.class);
	    confTop3.setReducerClass(budgetReducer.class);     
	    
	    confTop3.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
	    FileInputFormat.setInputPaths(confTop3,new Path("/ventas/anyos/part-00000"));    
	    FileOutputFormat.setOutputPath(confTop3,new Path("/ventas/anyos"));
	    JobClient.runJob(confTop3); // indicamos a yarn que ponga en cola este job
	}    
}
