package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import com.briup.crm.common.bean.User;
import com.briup.crm.common.bean.UserExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.UserMapper;
import com.briup.crm.service.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> login(String username, String password) throws CrmCommonException {
		// TODO Auto-generated method stub
		// 1.判空
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
					throw CrmCommonException.getException(401);
				}
				UserExample example = new UserExample();
				example.createCriteria().andUsernameEqualTo(username);
				List<User> list = userMapper.selectByExample(example);
				if (list.isEmpty()) {
					throw CrmCommonException.getException(401);
				} 
				for (User user : list) {
					if (!user.getPassword().equals(password)) {
						throw CrmCommonException.getException(402);
					}
				}
				return list;
	}
	
	/**
	 * 查找所有的员工
	 * @param session
	 * @return
	 */
	@Override
	public List<User> findAllUser() throws CrmCommonException {
		return userMapper.selectAllUser();
	}

	/**
	 * 查找User selectByPrimaryKey
	 */
	@Override
	public User findUser(Integer id) throws CrmCommonException{
		if (id==null) {
			throw CrmCommonException.getException(401);
		}
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加user
	 * @param user
	 */
	@Override
	public void insertUser(User user) throws CrmCommonException {
		userMapper.insertSelective(user);
	}


}
