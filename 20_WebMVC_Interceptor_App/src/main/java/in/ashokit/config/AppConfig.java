package in.ashokit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import in.ashokit.interceptor.RequestLogInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer{

	@Autowired
	private RequestLogInterceptor requestLogInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(requestLogInterceptor);
	}
}
