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
 * RoleAutoInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_auto_info")
public class RoleAutoInfo implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    

	private RoleAutoInfoId id;
	private RoleInfo roleInfo;
	private AutoInfo autoInfo;

	// Constructors

	/** default constructor */
	public RoleAutoInfo()
	{
	}

	/** full constructor */
	public RoleAutoInfo(RoleAutoInfoId id, RoleInfo roleInfo, AutoInfo autoInfo)
	{
		this.id = id;
		this.roleInfo = roleInfo;
		this.autoInfo = autoInfo;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "roleId", column = @Column(name = "role_id", nullable = false)), @AttributeOverride(name = "autoId", column = @Column(name = "auto_id", nullable = false)) })
	public RoleAutoInfoId getId()
	{
		return this.id;
	}

	public void setId(RoleAutoInfoId id)
	{
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
	public RoleInfo getRoleInfo()
	{
		return this.roleInfo;
	}

	public void setRoleInfo(RoleInfo roleInfo)
	{
		this.roleInfo = roleInfo;
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