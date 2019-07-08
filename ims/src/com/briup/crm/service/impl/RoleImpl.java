package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Role;
import com.briup.crm.common.bean.RoleExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.RoleMapper;
import com.briup.crm.service.interfaces.IRoleService;

@Service
public class RoleImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 查询所有的角色
	 */
	@Override
	public List<Role> selectRoles() throws CrmCommonException {
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}

}
