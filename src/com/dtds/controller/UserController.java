package com.dtds.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dtds.common.baseInterface.IService;
import com.dtds.entity.UserInfo;
import com.dtds.security.User;
import com.dtds.security.UserDetailServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController
{
	private IService userService;
	private UserDetailServiceImpl userDetailServiceImpl;

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpSession session, @Valid UserInfo user)
	{
		ModelAndView mv = new ModelAndView("error");
		try
		{
			// 登陆用户
			//UserInfo info = this.userService.findUser(user);
			User usr = (User) this.userDetailServiceImpl.loadUserByUsername(user.getUsername());
			if (null != usr)
			{
				// 将用户放到session中
				session.setAttribute("loginUser", usr);
				mv.setViewName("select");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping(value = "/show/{key}")
	public String reItem(@PathVariable("key") String key)
	{
		if (key.equals("add"))
			return "add";
		if (key.equals("delete"))
			return "delete";
		if (key.equals("update"))
			return "update";
		if (key.equals("select"))
			return "select";
		return "redirect:../index.jsp";
	}

	public IService getUserService()
	{
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(IService userService)
	{
		this.userService = userService;
	}

	public UserDetailServiceImpl getUserDetailServiceImpl()
	{
		return userDetailServiceImpl;
	}

	@Resource(name = "userDetailServiceImpl")
	public void setUserDetailServiceImpl(UserDetailServiceImpl userDetailServiceImpl)
	{
		this.userDetailServiceImpl = userDetailServiceImpl;
	}

}
