/**
 * Copyright: Copyright (c) 2012
 * Company:深圳市海乐淘电子商务有限公司
 * @author frinder(liujunhui)
 * @date 2013-5-24 下午3:21:40
 * @version V1.0
 *
 * @Description: TODO
 */
package com.dtds.security;

import org.springframework.security.authentication.encoding.PasswordEncoder;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class MyPasswordEncoder implements PasswordEncoder
{

	@Override
	public String encodePassword(String pwd, Object arg1)
	{
		return pwd;
	}

	@Override
	public boolean isPasswordValid(String npwd, String opwd, Object arg2)
	{
		System.out.println("MyPasswordEncoder.isPasswordValid()...................");
		return npwd.equals(opwd);
	}

}
