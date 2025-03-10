package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.ashokit.model.User;

@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();

		//If we are adding Redis in different system then we need to do this below configuration
		//	jcf.setHostName(hostname);
		//	jcf.setPassword(password);
		//	jcf.setPort(port);

		return jcf;
	}
	
	@Bean
	RedisTemplate<String, User> redisTemplate(){
		RedisTemplate< String, User> redisTEmplate= new RedisTemplate<>();
		redisTEmplate.setConnectionFactory(jedisConnectionFactory());
		return redisTEmplate;
	}
}
