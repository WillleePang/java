package com.willlee.springbootdemo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.willlee.springbootdemo.domain.Friend;

@RestController
public class CommonController {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(String userId) {
		String loginTime = sdf.format(new Date());
		List<Friend> friendList = new ArrayList<Friend>();
		friendList.add(new Friend("wanghui"));
		friendList.add(new Friend("yuantiezheng"));
		friendList.add(new Friend("zhangguoqing"));
		redisTemplate.opsForValue().set(userId, friendList);
		stringRedisTemplate.opsForHash().put("userLastLogin", userId, loginTime);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main");
		mav.addObject("friendList", friendList);
		return mav;
	}
}
