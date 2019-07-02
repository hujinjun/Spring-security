package com.dtds.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RoleAutoInfoId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class RoleAutoInfoId implements java.io.Serializable
{

	// Fields    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long roleId;
	private Long autoId;

	// Constructors

	/** default constructor */
	public RoleAutoInfoId()
	{
	}

	/** full constructor */
	public RoleAutoInfoId(Long roleId, Long autoId)
	{
		this.roleId = roleId;
		this.autoId = autoId;
	}

	// Property accessors

	@Column(name = "role_id", nullable = false)
	public Long getRoleId()
	{
		return this.roleId;
	}

	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}

	@Column(name = "auto_id", nullable = false)
	public Long getAutoId()
	{
		return this.autoId;
	}

	public void setAutoId(Long autoId)
	{
		this.autoId = autoId;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleAutoInfoId))
			return false;
		RoleAutoInfoId castOther = (RoleAutoInfoId) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this.getRoleId() != null && castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId()))) && ((this.getAutoId() == castOther.getAutoId()) || (this.getAutoId() != null && castOther.getAutoId() != null && this.getAutoId().equals(castOther.getAutoId())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result + (getAutoId() == null ? 0 : this.getAutoId().hashCode());
		return result;
	}

}