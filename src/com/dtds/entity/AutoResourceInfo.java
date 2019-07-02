package com.dtds.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AutoResourceInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auto_resource_info")
public class AutoResourceInfo implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    

	private AutoResourceInfoId id;
	private ResourceInfo resourceInfo;
	private AutoInfo autoInfo;

	// Constructors

	/** default constructor */
	public AutoResourceInfo()
	{
	}

	/** full constructor */
	public AutoResourceInfo(AutoResourceInfoId id, ResourceInfo resourceInfo, AutoInfo autoInfo)
	{
		this.id = id;
		this.resourceInfo = resourceInfo;
		this.autoInfo = autoInfo;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "autoId", column = @Column(name = "auto_id", nullable = false)), @AttributeOverride(name = "resourceId", column = @Column(name = "resource_id", nullable = false)) })
	public AutoResourceInfoId getId()
	{
		return this.id;
	}

	public void setId(AutoResourceInfoId id)
	{
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_id", nullable = false, insertable = false, updatable = false)
	public ResourceInfo getResourceInfo()
	{
		return this.resourceInfo;
	}

	public void setResourceInfo(ResourceInfo resourceInfo)
	{
		this.resourceInfo = resourceInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto_id", nullable = false, insertable = false, updatable = false)
	public AutoInfo getAutoInfo()
	{
		return this.autoInfo;
	}

	public void setAutoInfo(AutoInfo autoInfo)
	{
		this.autoInfo = autoInfo;
	}

}