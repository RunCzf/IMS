package com.briup.crm.service.interfaces;

import java.util.List;
import com.briup.crm.common.bean.User;
import com.briup.crm.common.exception.CrmCommonException;


public interface IUserService {
	/**
	 * 系统用户登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 * @throws CrmCommonException
	 */
	List<User> login(String username, String password) throws CrmCommonException;
	/**
	 * 查找所有的用户
	 * @param IUserService
	 * @throws CrmCommonException
	 */
	List<User> findAllUser() throws CrmCommonException;
	
	/**
	 * 查找用户通过ID
	 * @param IUserService
	 * @throws CrmCommonException
	 */
	User findUser(Integer id) throws CrmCommonException;
	
	/**
	 * 添加user
	 * @param user
	 */
	void insertUser(User user) throws CrmCommonException;
}
