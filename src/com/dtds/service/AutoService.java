package com.dtds.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dtds.common.BaseService;
import com.dtds.common.baseInterface.IDAO;

@Component("autoService")
public class AutoService extends BaseService
{
	private IDAO autoDAO;

	public IDAO getAutoDAO()
	{
		return autoDAO;
	}

	@Resource(name="autoDAO")
	public void setAutoDAO(IDAO autoDAO)
	{
		this.autoDAO = autoDAO;
	}
	
	
}
