package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.Department;
import com.briup.crm.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

public interface IDepartmentService {

	/**
	 * 查找用户所在的部门同id
	 * @param IUserService
	 * @throws CrmCommonException
	 */
	Department findDepartment(Integer id) throws CrmCommonException;

	/**
	 * 查找所有的部门带分页
	 * @param IUserService
	 * @throws CrmCommonException
	 */
	PageInfo<Department> findDepartments(Integer page,Integer size) throws CrmCommonException;

	/**
	 * 查找所有的部门
	 * @param IUserService
	 * @throws CrmCommonException
	 */
	List<Department> selectDepartments() throws CrmCommonException;
}
