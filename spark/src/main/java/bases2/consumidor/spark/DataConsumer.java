package bases2.consumidor.spark;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import kafka.serializer.StringDecoder;

public class DataConsumer {

	public static void main(String[] args) throws IOException {

		SparkConf conf = new SparkConf().setAppName("consumer-from-kafka").setMaster("local[*]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		// batchDuration - The time interval at which streaming data will be divided into batches
		JavaStreamingContext ssc = new JavaStreamingContext(sc, new Duration(5000));
		
		Map<String, String> kafkaParams = new HashMap<>();
		kafkaParams.put("metadata.broker.list", "10.0.0.2:9092");
		Set<String> topics = Collections.singleton("newsales");
		
		JavaPairInputDStream<String, String> directSparkStream = KafkaUtils.createDirectStream(ssc, String.class,
				String.class, StringDecoder.class, StringDecoder.class, kafkaParams, topics);
		  
		directSparkStream.foreachRDD(rdd -> {			  
			System.out.println("New data arrived  " + rdd.partitions().size() +" Partitions and " + rdd.count() + " Records");
			if(rdd.count() > 0) {
				rdd.collect().forEach(rawRecord -> {
					String record = rawRecord._2();
					System.out.println(record);
				});
			}
		});
		 
		ssc.start();
		ssc.awaitTermination();
	}
}