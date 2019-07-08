package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.Drug;
import com.briup.crm.common.exception.CrmCommonException;

public interface IDrugService {
	
	/**
	 * 查找所有的药品
	 * @param IDrugService
	 * @throws CrmCommonException
	 */
	List<Drug> findAllDrug() throws CrmCommonException;

	/**
	 * 查找药品根据药品Id
	 * @param IDrugService
	 * @throws CrmCommonException
	 */
	Drug findDrugs(Integer drugId) throws CrmCommonException;

	/**
	 * 取药 更新药品数量 
	 * @param IDrugService
	 * @throws CrmCommonException
	 */
	void updateDrugNumber(Drug drug) throws CrmCommonException;
}
