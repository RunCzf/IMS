package com.briup.crm.service.interfaces;

import com.briup.crm.common.bean.Patientdrug;
import com.briup.crm.common.exception.CrmCommonException;

public interface IPatientDrugService {

	/**
	 * 增加处方单
	 * @param IUserService
	 * @throws CrmCommonException
	 */
	 void insertPatientDrug(Patientdrug patientdrug) throws CrmCommonException;
}
