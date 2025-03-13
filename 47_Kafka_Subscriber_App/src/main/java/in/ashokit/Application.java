package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.ashokit.constants.AppConstants;
import in.ashokit.model.Order;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//Reading the messege from topic
	@KafkaListener(topics = AppConstants.TOPIC,groupId = "group_ashokit_order")
	public void subscribeMsg(String order)
	{
		System.out.println("***** Msg Received from kafka*** ");
		System.out.println(order);
	}
}
