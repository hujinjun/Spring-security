package com.dtds.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 重写用户名密码验证部分，加入了验证码的验证
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
	{
		System.out.println("MyUsernamePasswordAuthenticationFilter.attemptAuthentication()............");
		try
		{
			Authentication authentication = super.attemptAuthentication(request, response);
			return authentication;
		} catch (UsernameNotFoundException e)
		{
			throw new AuthenticationServiceException(e.getMessage());
		} catch (Exception e)
		{
			throw new AuthenticationServiceException("用户名或密码不正确！");
		}
	}
}
