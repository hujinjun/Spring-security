package com.dtds.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dtds.common.BaseService;
import com.dtds.common.baseInterface.IDAO;
import com.dtds.entity.AutoInfo;
import com.dtds.entity.ResourceInfo;
import com.dtds.entity.UserInfo;

@Component("userService")
public class UserService extends BaseService
{
	private IDAO userDAO;
	private IDAO autoDAO;
	private IDAO resourceDAO;

	/**
	 * 由用户名查询用户
	 * 
	 * @author：frinder
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public UserInfo findUserByName(String username)
	{
		String hql = "from UserInfo u where u.username = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> users = (List<UserInfo>) this.userDAO.findByParams(hql, new Object[] { username });
		UserInfo user = null;
		if (users.size() > 0)
			user = users.get(0);
		return user;
	}

	/**
	 * 登陆
	 * 
	 * @author：frinder
	 * 
	 * @param user
	 * @return
	 */
	public UserInfo findUser(UserInfo user)
	{
		String hql = "from UserInfo u where u.username = ? and u.password = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> users = (List<UserInfo>) this.userDAO.findByParams(hql, new Object[] { user.getUsername(), user.getPassword() });
		UserInfo u = null;
		if (users.size() > 0)
			u = users.get(0);
		return u;
	}

	/**
	 * 查询用户权限
	 * 
	 * @author：frinder
	 * 
	 * @param rid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AutoInfo> findUserAutos(Long rid)
	{
		String hql = null;
		List<AutoInfo> autos = null;
		if (null != rid) {
			hql = "from AutoInfo a where a.id in (select ra.autoInfo.id from RoleAutoInfo ra where ra.roleInfo.id = ?)";
			autos = this.autoDAO.findByParams(hql, new Object[] { rid });
		}
		else {
			hql = "from AutoInfo";
			autos = this.autoDAO.findByList(hql);
		}
		return autos;
	}

	/**
	 * 查询指定权限对应的资源
	 * 
	 * @author：frinder
	 * 
	 * @param autoId
	 * @return
	 */
	public List<ResourceInfo> findResource(Long autoId)
	{
		String hql = "from ResourceInfo r where r.id in (select ar.resourceInfo.id from AutoResourceInfo ar where ar.autoInfo.id = ?)";
		@SuppressWarnings("unchecked")
		List<ResourceInfo> res = this.resourceDAO.findByParams(hql, new Object[] { autoId });
		return res;
	}

	public IDAO getUserDAO()
	{
		return userDAO;
	}

	@Resource(name = "userDAO")
	public void setUserDAO(IDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public IDAO getAutoDAO()
	{
		return autoDAO;
	}

	@Resource(name = "autoDAO")
	public void setAutoDAO(IDAO autoDAO)
	{
		this.autoDAO = autoDAO;
	}

	public IDAO getResourceDAO()
	{
		return resourceDAO;
	}

	@Resource(name = "resourceDAO")
	public void setResourceDAO(IDAO resourceDAO)
	{
		this.resourceDAO = resourceDAO;
	}

}
