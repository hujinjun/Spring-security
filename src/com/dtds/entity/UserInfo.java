package com.dtds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_info")
public class UserInfo implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    

	private Long id;
	private String username;
	private String password;
	private Long roleId;

	// Constructors

	/** default constructor */
	public UserInfo()
	{
	}

	/** full constructor */
	public UserInfo(String username, String password, Long roleId)
	{
		this.username = username;
		this.password = password;
		this.roleId = roleId;
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

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "role_id", nullable = false)
	public Long getRoleId()
	{
		return this.roleId;
	}

	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}

}