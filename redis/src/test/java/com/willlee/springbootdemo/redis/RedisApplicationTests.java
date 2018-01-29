package com.willlee.springbootdemo.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.willlee.springbootdemo.Application;
import com.willlee.springbootdemo.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	public void testRedis() throws Exception {
		System.out.println("\n******************************************************\n");
		User user = (User) redisTemplate.opsForValue().get("pangweili");
		System.out.println(user);
		System.out.println("\n******************************************************\n");
	}

}
