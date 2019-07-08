package com.briup.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Patientdrug;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.PatientdrugMapper;
import com.briup.crm.service.interfaces.IPatientDrugService;

@Service
public class PatientDrugImpl implements IPatientDrugService {

	@Autowired
	private PatientdrugMapper patientdrugMapper;
	
	/**
	 * 增加处方单
	 * @param IUserService
	 * @throws CrmCommonException
	 */
	@Override
	public void insertPatientDrug(Patientdrug patientdrug) throws CrmCommonException {
		patientdrugMapper.insertSelective(patientdrug);
	}

}
