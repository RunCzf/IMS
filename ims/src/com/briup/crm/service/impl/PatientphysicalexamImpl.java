package com.briup.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Patientphysicalexam;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.PatientphysicalexamMapper;
import com.briup.crm.service.interfaces.IPatientphysicalexamService;

@Service
public class PatientphysicalexamImpl implements IPatientphysicalexamService {

	@Autowired
	private PatientphysicalexamMapper patientphysicalexamMapper;
	@Override
	public void insertPhysicalexam(Patientphysicalexam record) throws CrmCommonException {
		patientphysicalexamMapper.insertSelective(record);
	}

}
