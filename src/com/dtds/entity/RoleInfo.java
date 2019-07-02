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
 * RoleInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_info")
public class RoleInfo implements java.io.Serializable
{

	// Fields    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String rolename;
	private Set<RoleAutoInfo> roleAutoInfos = new HashSet<RoleAutoInfo>(0);

	// Constructors

	/** default constructor */
	public RoleInfo()
	{
	}

	/** minimal constructor */
	public RoleInfo(String rolename)
	{
		this.rolename = rolename;
	}

	/** full constructor */
	public RoleInfo(String rolename, Set<RoleAutoInfo> roleAutoInfos)
	{
		this.rolename = rolename;
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

	@Column(name = "rolename", nullable = false, length = 50)
	public String getRolename()
	{
		return this.rolename;
	}

	public void setRolename(String rolename)
	{
		this.rolename = rolename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleInfo")
	public Set<RoleAutoInfo> getRoleAutoInfos()
	{
		return this.roleAutoInfos;
	}

	public void setRoleAutoInfos(Set<RoleAutoInfo> roleAutoInfos)
	{
		this.roleAutoInfos = roleAutoInfos;
	}

}