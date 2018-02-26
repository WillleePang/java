package com.willlee.springbootdemo.service.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	// 重写了configure参数为AuthenticationManagerBuilder的方法
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 并根据传入的AuthenticationManagerBuilder中的userDetailsService方法来接收我们自定义的认证方法。
		// 且该方法必须要实现UserDetailsService这个接口。
		auth.userDetailsService(new MyUserDetailsService())
				// 密码使用BCryptPasswordEncoder()方法验证，因为这里使用了BCryptPasswordEncoder()方法验证。所以在注册用户的时候在接收前台明文密码之后也需要使用BCryptPasswordEncoder().encode(明文密码)方法加密密码。
				.passwordEncoder(new BCryptPasswordEncoder());
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests()方法有多个子节点，每个macher按照他们的声明顺序执行
		http.authorizeRequests()
				// 我们指定任何用户都可以访问多个URL的模式。
				// 任何用户都可以访问以"/resources/","/signup", 或者 "/about"开头的URL。
				.antMatchers("/resources/**", "/signup", "/about").permitAll()
				// 以 "/admin/" 开头的URL只能让拥有 "ROLE_ADMIN"角色的用户访问。
				// 请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀。
				.antMatchers("/admin/**").hasRole("ADMIN")
				// 任何以"/db/" 开头的URL需要同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"权限的用户才可以访问。
				// 和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
				// 任何以"/db/" 开头的URL只需要拥有 "ROLE_ADMIN" 和
				// "ROLE_DBA"其中一个权限的用户才可以访问。
				// 和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
				.antMatchers("/db/**").hasAnyRole("ADMIN", "DBA")
				// 尚未匹配的任何URL都要求用户进行身份验证
				.anyRequest().authenticated().and().formLogin();

		http
				// 通过formlogin方法登录，并设置登录url为/api/user/login
				.formLogin().loginPage("/api/user/login")
				// 指定登录成功后跳转到/index页面
				.defaultSuccessUrl("/index")
				// 指定登录失败后跳转到/login?error页面
				.failureUrl("/login?error").permitAll().and()
				// 开启cookie储存用户信息，并设置有效期为14天，指定cookie中的密钥
				.rememberMe().tokenValiditySeconds(1209600).key("mykey").and().logout()
				// 指定登出的url
				.logoutUrl("/api/user/logout")
				// 指定登场成功之后跳转的url
				.logoutSuccessUrl("/index").permitAll();

		http.formLogin().and().csrf().disable().authorizeRequests().antMatchers("/admin").permitAll()
				// 使用自定义授权策略
				.anyRequest().access("@mySecurity.check(authentication,request)");
		
	}

}
