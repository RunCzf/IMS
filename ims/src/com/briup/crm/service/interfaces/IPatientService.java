package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.Patient;
import com.briup.crm.common.exception.CrmCommonException;

public interface IPatientService {
	
	/**
	 * 查找所有的Patient通过id
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	Patient findPatient(Integer id) throws CrmCommonException;
	
	/**
	 * 查找所有的病人
	 * @return
	 * @throws CrmCommonException
	 */
	List<Patient> selectPatients() throws CrmCommonException;

	/**
	 * 根据ID查找病人
	 * @return
	 * @throws CrmCommonException
	 */
	Patient selectPatient(Integer id) throws CrmCommonException;

	/**
	 * 更新病人信息
	 * @return
	 * @throws CrmCommonException
	 */
	void updatePatient(Patient patient) throws CrmCommonException;

	/**
	 * 添加病人信息
	 * @return
	 * @throws CrmCommonException
	 */
	void insertPatient(Patient patient) throws CrmCommonException;

	/**
	 * 删除病人信息
	 * @return
	 * @throws CrmCommonException
	 */
	void deletePatient(Integer id) throws CrmCommonException;
}
