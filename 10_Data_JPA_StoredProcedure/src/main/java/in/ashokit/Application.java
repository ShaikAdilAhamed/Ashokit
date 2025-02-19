package in.ashokit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.ProductRepository.ProductRepository;
import in.ashokit.entity.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
	   ProductRepository proRepo = context.getBean(ProductRepository.class);
	   
	   List<Product> allproducts=proRepo.getAllProducts();
	   
	   allproducts.forEach(System.out::println);
	}

}
