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
 * AutoInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auto_info")
public class AutoInfo implements java.io.Serializable
{

	// Fields    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String autoname;
	private String autocode;
	private String des;
	private Set<AutoResourceInfo> autoResourceInfos = new HashSet<AutoResourceInfo>(0);
	private Set<RoleAutoInfo> roleAutoInfos = new HashSet<RoleAutoInfo>(0);

	// Constructors

	/** default constructor */
	public AutoInfo()
	{
	}

	/** minimal constructor */
	public AutoInfo(String autoname, String autocode)
	{
		this.autoname = autoname;
		this.autocode = autocode;
	}

	/** full constructor */
	public AutoInfo(String autoname, String autocode, String des, Set<AutoResourceInfo> autoResourceInfos, Set<RoleAutoInfo> roleAutoInfos)
	{
		this.autoname = autoname;
		this.autocode = autocode;
		this.des = des;
		this.autoResourceInfos = autoResourceInfos;
		this.roleAutoInfos = roleAutoInfos;
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

	@Column(name = "autoname", nullable = false, length = 50)
	public String getAutoname()
	{
		return this.autoname;
	}

	public void setAutoname(String autoname)
	{
		this.autoname = autoname;
	}

	@Column(name = "autocode", nullable = false, length = 50)
	public String getAutocode()
	{
		return this.autocode;
	}

	public void setAutocode(String autocode)
	{
		this.autocode = autocode;
	}

	@Column(name = "des", length = 65535)
	public String getDes()
	{
		return this.des;
	}

	public void setDes(String des)
	{
		this.des = des;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "autoInfo")
	public Set<AutoResourceInfo> getAutoResourceInfos()
	{
		return this.autoResourceInfos;
	}

	public void setAutoResourceInfos(Set<AutoResourceInfo> autoResourceInfos)
	{
		this.autoResourceInfos = autoResourceInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "autoInfo")
	public Set<RoleAutoInfo> getRoleAutoInfos()
	{
		return this.roleAutoInfos;
	}

	public void setRoleAutoInfos(Set<RoleAutoInfo> roleAutoInfos)
	{
		this.roleAutoInfos = roleAutoInfos;
	}

}