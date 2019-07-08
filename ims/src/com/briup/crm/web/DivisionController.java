package com.briup.crm.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.common.bean.Department;
import com.briup.crm.common.bean.Role;
import com.briup.crm.common.bean.User;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IDepartmentService;
import com.briup.crm.service.interfaces.IRoleService;
import com.briup.crm.service.interfaces.IUserService;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping(value="/division")
public class DivisionController {
	
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	
	/**
	 * 查找所有的部门
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/{page}/dept")
	public String dept(HttpSession session,@PathVariable Integer page) {
		try {
			PageInfo<Department> departments = departmentService.findDepartments(page,5);
			System.out.println(departments);
			session.setAttribute("departmentess", departments);
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/dept";
	}
	
	/**
	 * 查找所有的员工
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping(value="user")
	public String user(HttpSession session) {
		try {
			List<User> users = userService.findAllUser();
			session.setAttribute("users", users);
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/user";
	}
	
	/**
	 * 查找所有的部门
	 * @param session
	 * @return
	 */
	@RequestMapping(value="selectDept")
	@ResponseBody
	public List<Department> selectDept(HttpSession session) {
		try {
			List<Department> departments = departmentService.selectDepartments();
			return departments;
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 查找所有的部门
	 * @param session
	 * @return
	 */
	@RequestMapping(value="selectRoles")
	@ResponseBody
	public List<Role> selectRoles(HttpSession session) {
		try {
			List<Role> roles = roleService.selectRoles();
			return roles;
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 添加User
	 * @param session
	 * @return
	 */
	@RequestMapping(value="addUser")
	@ResponseBody
	public String addUser(HttpSession session,User user) {
		try {
			userService.insertUser(user);
			return "success";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
}
