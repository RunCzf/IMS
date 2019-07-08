package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Patient;
import com.briup.crm.common.bean.PatientExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.PatientMapper;
import com.briup.crm.service.interfaces.IPatientService;

@Service
public class PatientImpl implements IPatientService {

	@Autowired
	private PatientMapper patientMapper;
	
	/**
	 * 查找所有的Patient通过id
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	@Override
	public Patient findPatient(Integer id) throws CrmCommonException {
		if (id==null) {
			throw CrmCommonException.getException(401);
		}
		return patientMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 查找所有的病人
	 * @return
	 * @throws CrmCommonException
	 */
	@Override
	public List<Patient> selectPatients() throws CrmCommonException {
		PatientExample example = new PatientExample();
		return patientMapper.selectByExample(example);
	}

	/**
	 * 根据Id查找病人
	 * @return
	 * @throws CrmCommonException
	 */
	@Override
	public Patient selectPatient(Integer id) throws CrmCommonException {
		if (id==null) {
			throw CrmCommonException.getException(401);
		}
		return patientMapper.selectByPrimaryKey(id);
	}

	/**
	 * 更新病人
	 * @return
	 * @throws CrmCommonException
	 */
	@Override
	public void updatePatient(Patient record) throws CrmCommonException {
		patientMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 添加病人信息
	 * @return
	 * @throws CrmCommonException
	 */
	@Override
	public void insertPatient(Patient patient) throws CrmCommonException {
		patientMapper.insertSelective(patient);
	}

	/**
	 * 删除病人信息
	 * @return
	 * @throws CrmCommonException
	 */
	@Override
	public void deletePatient(Integer id) throws CrmCommonException {
		if (id==null) {
			throw CrmCommonException.getException(401);
		}
		patientMapper.deleteByPrimaryKey(id);
	}

}
