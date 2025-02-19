package in.ashokit.config;

import org.hibernate.boot.Metadata;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import in.ashokit.entity.Book;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		//(HttpMethod.PUT, HttpMethod.DELETE) I dont want these methods to work in my project (or) i want to disable this methods  
	HttpMethod[] unSupportedMethods= { HttpMethod.PUT,HttpMethod.DELETE};
	
	config.getExposureConfiguration()
	.forDomainType(Book.class)
	.withItemExposure((metadata,http)-> http.disable(unSupportedMethods))  //(withItemExposure) it means only single object
	.withCollectionExposure((Metadata,http) -> http.disable(unSupportedMethods));  //(withCollectionExposure) it means json array
	}
}
