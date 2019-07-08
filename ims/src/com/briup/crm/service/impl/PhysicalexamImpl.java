package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Physicalexam;
import com.briup.crm.common.bean.PhysicalexamExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.PhysicalexamMapper;
import com.briup.crm.service.interfaces.IPhysicalexamService;
@Service
public class PhysicalexamImpl implements IPhysicalexamService {

	@Autowired
	private PhysicalexamMapper physicalexamMapper;
	
	/**
	 * 查找所有的physicalexam
	 * @param session
	 * @return
	 */
	@Override
	public List<Physicalexam> findphysicalexams() throws CrmCommonException {
		PhysicalexamExample example = new PhysicalexamExample();
		return physicalexamMapper.selectByExample(example);
	}
	/**
	 * 添加physicalexam
	 * @param session
	 * @return
	 */
	@Override
	public void insertPhysicalexam(Physicalexam record) throws CrmCommonException {
		physicalexamMapper.insert(record);
	}
	
	/**
	 * 删除physicalexam
	 * @param session
	 * @return
	 */
	@Override
	public void deleteById(Integer id) throws CrmCommonException {
		if (id==null) {
			throw CrmCommonException.getException(401);
		}
		physicalexamMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Physicalexam findPhysicalexam(Integer id) throws CrmCommonException {
		if (id==null) {
			throw CrmCommonException.getException(401);
		}
		return physicalexamMapper.selectByPrimaryKey(id);
	}

}
