package com.dtds.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dtds.common.BaseService;
import com.dtds.common.baseInterface.IDAO;

@Component("roleService")
public class RoleService extends BaseService
{

	private IDAO roleDAO;

	public IDAO getRoleDAO()
	{
		return roleDAO;
	}

	@Resource(name = "roleDAO")
	public void setRoleDAO(IDAO roleDAO)
	{
		this.roleDAO = roleDAO;
	}

}
