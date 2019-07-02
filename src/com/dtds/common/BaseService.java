package com.dtds.common;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.dtds.common.baseInterface.IDAO;
import com.dtds.common.baseInterface.IService;
import com.dtds.entity.AutoInfo;
import com.dtds.entity.ResourceInfo;
import com.dtds.entity.UserInfo;

/**
 * 
 * @author WWC
 * @since SUN JDK1.6.0_13
 * @version
 * @create date 2012-08-08
 * 
 */
@Component("iservice")
public class BaseService implements IService
{
	public IDAO idao;

	public IDAO getIdao()
	{
		return idao;
	}

	@Resource(name = "idao")
	public void setIdao(IDAO idao)
	{
		this.idao = idao;
	}

	public void add(Object object)
	{
		// TODO Auto-generated method stub
	}

	public List findByList(String hql)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo findUserByName(String username)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AutoInfo> findUserAutos(Long rid)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceInfo> findResource(Long autoId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo findUser(UserInfo user)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
