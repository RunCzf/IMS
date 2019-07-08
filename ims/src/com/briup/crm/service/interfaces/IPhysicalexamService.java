package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.Physicalexam;
import com.briup.crm.common.exception.CrmCommonException;

public interface IPhysicalexamService {

	/**
	 * 查找所有的physicalexam
	 * @param session
	 * @return
	 */
	List<Physicalexam> findphysicalexams() throws CrmCommonException;

	/**
	 * 添加physicalexam
	 * @param session
	 * @return
	 */
	void insertPhysicalexam(Physicalexam record) throws CrmCommonException;

	/**
	 * 删除physicalexam
	 * @param session
	 * @return
	 */
	void deleteById(Integer id) throws CrmCommonException;
	
	/**
	 * 查找physicalexam通过id
	 * @param session
	 * @return
	 */
	Physicalexam findPhysicalexam(Integer id) throws CrmCommonException;
}
