package com.willlee.springbootdemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.willlee.springbootdemo.base.ResultInformation;
import com.willlee.springbootdemo.domain.Result;
import com.willlee.springbootdemo.domain.User;
import com.willlee.springbootdemo.util.RandomUtil;
import com.willlee.springbootdemo.util.RequestUtil;

@RestController
@RequestMapping(value = "/common")
public class CommonController {

	private Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginget(HttpServletRequest request) {
		logger.info("========login======start");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login");
		logger.info("========login======end");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginpost(HttpServletRequest request, String useraccount, String password) {
		logger.info("========login======start");
		logger.info(RequestUtil.getParamsFromRequest(request));
		ModelAndView mav = new ModelAndView();
		String loginTime = sdf.format(new Date());
		String viewName = "";
		if (StringUtils.isEmpty(useraccount) || StringUtils.isEmpty(password)) {
			logger.info("useraccount or password is null");
			viewName = "/login";
		} else {
			Object object = redisTemplate.opsForValue().get(useraccount);
			if (object == null) {
				logger.info("user is null");
				viewName = "/login";
			} else {
				User user = (User) object;
				if (user.getPassword().equals(password)) {
					viewName = "redirect:/common/main";
					request.getSession().setAttribute("chatdemo-user-info", user.getUseraccount());
					redisTemplate.expire(useraccount, 1, TimeUnit.HOURS);
					stringRedisTemplate.opsForHash().put("user_last_login", useraccount, loginTime);
				} else {
					logger.info("password is error");
					viewName = "/login";
				}
			}
		}
		mav.setViewName(viewName);
		logger.info("========login======end");
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, String useraccount, String password) {
		logger.info("========register======start");
		logger.info(RequestUtil.getParamsFromRequest(request));
		ModelAndView mav = new ModelAndView();
		if (StringUtils.isEmpty(useraccount) || StringUtils.isEmpty(password)) {
			logger.info("useraccount or password is null");
		} else {
			User user = new User();
			user.setUseraccount(useraccount);
			user.setPassword(password);
			String uuid = RandomUtil.getUUID();
			user.setNickname(uuid);
			user.setUserId(uuid);
			redisTemplate.opsForValue().set(useraccount, user);
		}
		mav.setViewName("/login");
		logger.info("========register======end");
		return mav;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request) {
		logger.info("========main======start");
		logger.info(RequestUtil.getParamsFromRequest(request));
		String useraccount = (String) request.getSession().getAttribute("chatdemo-user-info");
		User user = (User) redisTemplate.opsForValue().get(useraccount);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main");
		mav.addObject("user", user);
		logger.info("========main======end");
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		logger.info("========logout======start");
		logger.info(RequestUtil.getParamsFromRequest(request));
		request.getSession().getAttribute("chatdemo-user-info");
		request.getSession().removeAttribute("chatdemo-user-info");
		logger.info("========logout======end");
		Result result = new Result();
		result.setCode(ResultInformation.SUCCESS.getCode());
		result.setMsg(ResultInformation.SUCCESS.getMsg());
		return JSONObject.toJSONString(result);
	}

}
