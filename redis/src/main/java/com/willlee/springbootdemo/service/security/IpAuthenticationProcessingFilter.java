package com.willlee.springbootdemo.service.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class IpAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

	IpAuthenticationProcessingFilter() {
		super(new AntPathRequestMatcher("/ipVerify"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// 获取host信息
		String host = request.getRemoteHost();
		// 交给内部的AuthenticationManager去认证，实现解耦
		return getAuthenticationManager().authenticate(new IpAuthenticationToken(host));
	}

}
