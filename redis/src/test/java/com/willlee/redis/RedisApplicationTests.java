package com.willlee.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.willlee.redisdemo.WillleeApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WillleeApplication.class)
public class RedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void testRedis() throws Exception {
		System.out.println("\n******************************************************\n");
		stringRedisTemplate.opsForValue().set("pangweili", "281");
		stringRedisTemplate.opsForList().rightPush("list1", "111");
		stringRedisTemplate.opsForList().rightPush("list1", "212");
		stringRedisTemplate.opsForList().rightPush("list2", "111");
		System.out.println("\n******************************************************\n");
	}

}
