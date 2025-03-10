package in.ashokit.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import in.ashokit.model.User;

@Service
public class UserService {
	// HashOperations<String, String, User> //hashkey //normal-key //value
	HashOperations<String, Integer, User> opsForHash = null;

	//implementing  redis template in user service ("RedisTemplate<String, User> redisTemplate")
	public UserService(RedisTemplate<String, User> redisTemplate) {
		this.opsForHash = redisTemplate.opsForHash();
	}

	public String addUser(User user) {
		opsForHash.put("USERS",user.getId(), user);
		return "User Added";
	}
	
	public User geUser(Integer userId)
	{
		return opsForHash.get("USERS", userId);
	}
	
	public Collection<User> getAllUsers(){
		Map<Integer, User> entries = opsForHash.entries("USERS");
		return entries.values();
	}
	
}
