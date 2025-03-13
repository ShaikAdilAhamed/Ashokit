package in.ashokit.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import in.ashokit.constants.AppConstants;
import in.ashokit.model.Order;

@Configuration
public class KafkaProduceConfig {

	@Bean
	public ProducerFactory<String, Order> producerFactory()
	{
		Map<String, Object> configProps= new HashMap<>();
		
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		                                                            //key is string so we are using StringSerializer
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		                                                            //value is JSON  i want to store the messege in the form of json
		                                                            //so we are using JsonSerializer
		
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	//For to create customized KafkaTemplate with using (producerFactory()) and return 
	@Bean
	public KafkaTemplate<String, Order> kafkaTemplate()
	{
		return new KafkaTemplate<>(producerFactory());
	}
	
}
