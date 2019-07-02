package com.dtds.common.baseInterface;

import java.util.List;

import com.dtds.entity.AutoInfo;
import com.dtds.entity.ResourceInfo;
import com.dtds.entity.UserInfo;

public interface IService {
	/***
	 * @author frinder
	 * @功能：添加
	 * @date 2012-09-25
	 * @param object
	 */
	public void add(Object object);

	/***
	 * @author frinder
	 * @功能：由hql查询
	 * @date 2012-09-25
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findByList(String hql);
	
	
	public UserInfo findUserByName(String username);
	
	public List<AutoInfo> findUserAutos(Long rid);
	
	public List<ResourceInfo> findResource(Long autoId);
	
	public UserInfo findUser(UserInfo user);
	
}
