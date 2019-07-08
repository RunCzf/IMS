package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Drug;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.DrugMapper;
import com.briup.crm.service.interfaces.IDrugService;

@Service
public class DrugImpl implements IDrugService {

	@Autowired
	private DrugMapper drugMapper;
	
	/**
	 * 查找所有的药品
	 * @param IDrugService
	 * @throws CrmCommonException
	 */
	@Override
	public List<Drug> findAllDrug() throws CrmCommonException {
		return drugMapper.findAllDrug();
	}

	/**
	 * 查找药品根据药品Id 
	 * @param IDrugService
	 * @throws CrmCommonException
	 */
	@Override
	public Drug findDrugs(Integer drugId) throws CrmCommonException {
		if (drugId==null) {
			throw CrmCommonException.getException(401);
		}
		return drugMapper.selectByPrimaryKey(drugId);
	}

	/**
	 * 取药 更新药品数量 
	 * @param IDrugService
	 * @throws CrmCommonException
	 */
	@Override
	public void updateDrugNumber(Drug drug) throws CrmCommonException {
		drugMapper.updateByPrimaryKeySelective(drug);
	}

}
