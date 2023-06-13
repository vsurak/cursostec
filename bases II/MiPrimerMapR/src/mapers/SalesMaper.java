package mapers;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.FloatWritable;   
import org.apache.hadoop.io.Text;    
import org.apache.hadoop.mapred.MapReduceBase;    
import org.apache.hadoop.mapred.Mapper;    
import org.apache.hadoop.mapred.OutputCollector;    
import org.apache.hadoop.mapred.Reporter;  

public class SalesMaper extends MapReduceBase implements Mapper<LongWritable,Text,Text,LongWritable> { 
    
    public void map(LongWritable key, Text lineFromFile, OutputCollector<Text,LongWritable> output, Reporter reporter) throws IOException{    
    	String year;
		String oficina;
		String partida;
    	Long amount;
    	
    	String values[] = lineFromFile.toString().split(",");

		year = values[0];
    	oficina = values[2];
		partida = values[4];
		try {
		    amount = Long.parseLong(values[7]);
		    // Hacer algo con el valor long "amount"
		} catch (NumberFormatException e) {
		    // Manejar la excepción si la cadena no es un número válido
		    amount = 0L;
		}
		
    	String keyToEmit = year + "/" + oficina + "/" + partida;
    	        
        output.collect(new Text(keyToEmit), new LongWritable(amount)); 
    }
}
