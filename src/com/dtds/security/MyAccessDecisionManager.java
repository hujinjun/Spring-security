/**
 * Copyright: Copyright (c) 2012
 * Company:深圳市海乐淘电子商务有限公司
 * @author frinder(liujunhui)
 * @date 2013-5-21 下午7:16:15
 * @version V1.0
 *
 * @Description: TODO
 */
package com.dtds.security;

import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 访问决策器<br/>
 * 决定某个用户具有的角色，是否有足够的权限去访问某个资源
 */
public class MyAccessDecisionManager implements AccessDecisionManager
{
	/**
	 * @param authentication 登陆的角色所具有的权限列表
	 * @param object 访问的url
	 * @param configAttributes 访问这个url所需要的权限列表
	 */
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException
	{
		System.out.println("MyAccessDecisionManager.decide()..................");
		//如果权限列表为空
		if (null == configAttributes)
			return;
		//权限列表
		Iterator<ConfigAttribute> it = configAttributes.iterator();
		while (it.hasNext())
		{
			ConfigAttribute ca = it.next(); //权限
			//相应的权限
			String needRole = ((SecurityConfig) ca).getAttribute();

			// ga 为用户所被赋予的权限
			// needRole 为访问相应的资源应该具有的权限。
			for (GrantedAuthority ga : authentication.getAuthorities())
			{
				if (needRole.trim().equals(ga.getAuthority().trim()))
				{
					return;
				}
			}
		}
		throw new AccessDeniedException("no right...");
	}


	public boolean supports(ConfigAttribute attribute)
	{
		return true;
	}

	public boolean supports(Class<?> clazz)
	{
		return true;
	}

}
