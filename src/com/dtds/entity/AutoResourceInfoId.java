package com.dtds.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AutoResourceInfoId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class AutoResourceInfoId implements java.io.Serializable
{

	// Fields    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long autoId;
	private Long resourceId;

	// Constructors

	/** default constructor */
	public AutoResourceInfoId()
	{
	}

	/** full constructor */
	public AutoResourceInfoId(Long autoId, Long resourceId)
	{
		this.autoId = autoId;
		this.resourceId = resourceId;
	}

	// Property accessors

	@Column(name = "auto_id", nullable = false)
	public Long getAutoId()
	{
		return this.autoId;
	}

	public void setAutoId(Long autoId)
	{
		this.autoId = autoId;
	}

	@Column(name = "resource_id", nullable = false)
	public Long getResourceId()
	{
		return this.resourceId;
	}

	public void setResourceId(Long resourceId)
	{
		this.resourceId = resourceId;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AutoResourceInfoId))
			return false;
		AutoResourceInfoId castOther = (AutoResourceInfoId) other;

		return ((this.getAutoId() == castOther.getAutoId()) || (this.getAutoId() != null && castOther.getAutoId() != null && this.getAutoId().equals(castOther.getAutoId()))) && ((this.getResourceId() == castOther.getResourceId()) || (this.getResourceId() != null && castOther.getResourceId() != null && this.getResourceId().equals(castOther.getResourceId())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getAutoId() == null ? 0 : this.getAutoId().hashCode());
		result = 37 * result + (getResourceId() == null ? 0 : this.getResourceId().hashCode());
		return result;
	}

}