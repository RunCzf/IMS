package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.Role;
import com.briup.crm.common.exception.CrmCommonException;

public interface IRoleService {

	/**
	 * 查询所有的角色
	 */
	List<Role> selectRoles() throws CrmCommonException;
}
