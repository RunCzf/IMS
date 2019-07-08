package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.Userpatient;
import com.briup.crm.common.exception.CrmCommonException;

public interface IUserPatientService {
	/**
	 * 查找所有的UserPatient已处理
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	List<Userpatient> findAllUserPatient(Integer userId) throws CrmCommonException;
	
	/**
	 * 查找所有的UserPatient未处理
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	List<Userpatient> findAllUserPatients(Integer userId) throws CrmCommonException;

	/**
	 * 更新所有的UserPatient未处理
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	void updateStatus(Userpatient record,Integer id) throws CrmCommonException;
	
	/**
	 * 查找UserPatient通过ID
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	Userpatient findUserPatient(Integer id) throws CrmCommonException;

	/**
	 * 更新UserPatient
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	void updateUserpatient(Userpatient record) throws CrmCommonException;
}
