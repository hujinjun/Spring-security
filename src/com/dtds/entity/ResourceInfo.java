package com.dtds.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ResourceInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resource_info")
public class ResourceInfo implements java.io.Serializable
{

	// Fields    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String url;
	private Set<AutoResourceInfo> autoResourceInfos = new HashSet<AutoResourceInfo>(0);

	// Constructors

	/** default constructor */
	public ResourceInfo()
	{
	}

	/** full constructor */
	public ResourceInfo(String name, String url, Set<AutoResourceInfo> autoResourceInfos)
	{
		this.name = name;
		this.url = url;
		this.autoResourceInfos = autoResourceInfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "url", length = 100)
	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resourceInfo")
	public Set<AutoResourceInfo> getAutoResourceInfos()
	{
		return this.autoResourceInfos;
	}

	public void setAutoResourceInfos(Set<AutoResourceInfo> autoResourceInfos)
	{
		this.autoResourceInfos = autoResourceInfos;
	}

}