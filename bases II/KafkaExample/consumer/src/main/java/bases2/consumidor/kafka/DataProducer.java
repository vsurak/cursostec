package bases2.consumidor.kafka;

import java.net.URISyntaxException;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


public class DataProducer implements IConstants {

    private Producer<String, String> theproducer;
    
    public DataProducer(Properties pProperties) {
    	this.theproducer = new KafkaProducer<String, String>(pProperties);
    }

    private void PublishMessages() throws URISyntaxException{        
        try {
        	// estos serían los datos que recibe este método por parámetro para notificarlos al topico de kafka como eventos
        	String newData[] = {"10/11/2021", "87345.00", "13/10/2021", "100000.25", "18/11/2021", "954000.10"};
            
        	for(int record = 0; record<=newData.length-2; record+=2) {
                final ProducerRecord<String, String> salesRecord = new ProducerRecord<String, String>(
                        TOPIC, newData[record]+","+newData[record+1]);
        		
                this.theproducer.send(salesRecord);
                System.out.println(salesRecord);
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.theproducer.close();
    }
    
    public static void main(String[] args) throws URISyntaxException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER+":"+KAFKA_PORT);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, APP_ID);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        
        DataProducer kafkaProducer = new DataProducer(properties);
        kafkaProducer.PublishMessages();
        System.out.println("Producing job completed");
    }
    
}