package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootCacheProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCacheProjectApplication.class, args);
	}

}
