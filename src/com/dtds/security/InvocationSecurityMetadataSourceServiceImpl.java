/**
 * Copyright: Copyright (c) 2012
 * Company:深圳市海乐淘电子商务有限公司
 * @author frinder(liujunhui)
 * @date 2013-5-21 下午7:14:50
 * @version V1.0
 *
 * @Description: TODO
 */
package com.dtds.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import com.dtds.common.baseInterface.IService;
import com.dtds.entity.AutoInfo;
import com.dtds.entity.ResourceInfo;
import com.google.gson.Gson;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义， 即getAttributes方法返回的结果。 此类在初始化时，应该取到所有资源及其对应角色的定义。
 */
public class InvocationSecurityMetadataSourceServiceImpl implements FilterInvocationSecurityMetadataSource
{

	
	private IService userService;
	//保存权限
	private static Map<String, Collection<ConfigAttribute>> authorityMap = new ConcurrentHashMap<String, Collection<ConfigAttribute>>();

	public InvocationSecurityMetadataSourceServiceImpl()
	{
		super();
	}
	

	//获取所有权限
	private void loadResourceDefine()
	{
		//获取所有权限
		List<AutoInfo> autos = this.userService.findUserAutos(null);
		for (AutoInfo auto : autos)
		{
			//权限
			ConfigAttribute ca = new SecurityConfig(auto.getAutocode());
			//获取权限对应资源
			List<ResourceInfo> res = this.userService.findResource(auto.getId());
			for (ResourceInfo r : res)
			{
				String url = r.getUrl();
				//url对应权限列表
				Collection<ConfigAttribute> value = null;
				//判断是否存在此权限
				if (authorityMap.containsKey(url))
				{
					//存在权限，则获取权限列表，并将该操作放入列表中
					value = authorityMap.get(url);
					value.add(ca);
					authorityMap.put(url, value);
				} else
				{
					//不存在，则创建列表，并将权限添加进去
					value = new ArrayList<ConfigAttribute>();
					value.add(ca);
					authorityMap.put(url, value);
				}
			}
		}
		System.out.println("权限有：" + new Gson().toJson(authorityMap));
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes()
	{
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException
	{
		this.loadResourceDefine();
		// object 是一个URL，被用户请求的url。  
		String url = ((FilterInvocation) object).getRequestUrl();
		// ?所在的索引位
		int firstQuestionMarkIndex = url.indexOf("?");
		//存在就截取
		if (firstQuestionMarkIndex != -1)
		{
			url = url.substring(0, firstQuestionMarkIndex);
		}
		//url集合
		Iterator<String> ite = authorityMap.keySet().iterator();

		while (ite.hasNext())
		{
			String resURL = ite.next();

			if (url.indexOf(resURL) != -1)
			{
				System.out.println("所需权限是：" + new Gson().toJson(authorityMap.get(resURL)));
				return authorityMap.get(resURL);
			}
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> arg0)
	{
		return true;
	}

	public IService getUserService()
	{
		return userService;
	}

	public void setUserService(IService userService)
	{
		this.userService = userService;
	}

}
