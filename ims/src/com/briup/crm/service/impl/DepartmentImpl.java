package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Department;
import com.briup.crm.common.bean.DepartmentExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.DepartmentMapper;
import com.briup.crm.service.interfaces.IDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DepartmentImpl implements IDepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * 查找用户所在的部门同id
	 * @param IUserService
	 * @throws CrmCommonException
	 */
	@Override
	public Department findDepartment(Integer id) throws CrmCommonException {
		if (id==null) {
			throw CrmCommonException.getException(401);
		}
		return departmentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查找所有的部门带分页
	 */
	@Override
	public PageInfo<Department> findDepartments(Integer page, Integer size) throws CrmCommonException {
		PageHelper.startPage(page, size);
		DepartmentExample example = new DepartmentExample();
		return new PageInfo<>(departmentMapper.selectByExample(example));
	}

	/**
	 * 查找所有的部门
	 */
	@Override
	public List<Department> selectDepartments() throws CrmCommonException {
		DepartmentExample example = new DepartmentExample();
		return departmentMapper.selectByExample(example);
	}

}
