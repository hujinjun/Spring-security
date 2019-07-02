/**
 * Copyright: Copyright (c) 2012
 * Company:深圳市海乐淘电子商务有限公司
 * @author frinder(liujunhui)
 * @date 2013-5-24 下午6:08:13
 * @version V1.0
 *
 * @Description: TODO
 */
package com.dtds.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.dtds.entity.UserInfo;

/**
 * 权限管理使用user对象：必须实现userDetails接口
 */
public class User extends org.springframework.security.core.userdetails.User
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;

	public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
	{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	


	public UserInfo getUserInfo()
	{
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}

}
