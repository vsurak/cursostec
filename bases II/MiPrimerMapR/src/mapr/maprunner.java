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

import reducers.budgetReducer;
import mapers.budgetMaper;


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
	    

	}    
}
