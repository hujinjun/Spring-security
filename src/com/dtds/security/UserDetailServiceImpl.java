/**
 * Copyright: Copyright (c) 2012
 * Company:深圳市海乐淘电子商务有限公司
 * @author frinder(liujunhui)
 * @date 2013-5-21 下午6:03:48
 * @version V1.0
 *
 * @Description: TODO
 */
package com.dtds.security;

import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.dtds.common.baseInterface.IService;
import com.dtds.entity.AutoInfo;
import com.dtds.entity.UserInfo;
import com.google.common.collect.Sets;

/**
 * 该类的主要作用是为Spring Security提供一个经过用户认证后的UserDetails。
 * 该UserDetails包括用户名、密码、是否可用、是否过期等信息。
 */
@SuppressWarnings("deprecation")
@Component("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService
{
	private IService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		//获取用户
		UserInfo u = this.userService.findUserByName(username);
		if (null == u){
			throw new UsernameNotFoundException("账号名:" + username + " 不存在");
		}
		Collection<GrantedAuthority> auths = Sets.newHashSet();
		//用户权限
		List<AutoInfo> autos = this.userService.findUserAutos(u.getRoleId());
		for (AutoInfo auto : autos)
		{
			auths.add(new GrantedAuthorityImpl(auto.getAutocode())); //添加权限码
		}
		User user = new User(u.getUsername(), u.getPassword(), true, true, true, true, auths);
		return user;
	}

	public IService getUserService()
	{
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(IService userService)
	{
		this.userService = userService;
	}

}
