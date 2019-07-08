package com.briup.crm.service.interfaces;

import com.briup.crm.common.bean.Patientphysicalexam;
import com.briup.crm.common.exception.CrmCommonException;

public interface IPatientphysicalexamService {

	void insertPhysicalexam(Patientphysicalexam record) throws CrmCommonException;
	 
}
