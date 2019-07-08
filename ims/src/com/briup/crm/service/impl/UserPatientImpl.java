package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Userpatient;
import com.briup.crm.common.bean.UserpatientExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.UserpatientMapper;
import com.briup.crm.service.interfaces.IUserPatientService;

@Service
public class UserPatientImpl implements IUserPatientService {

	@Autowired
	private UserpatientMapper userpatientMapper;
	
	/**
	 * 查找科室未处理的病人
	 * @param session
	 * @return
	 */
	@Override
	public List<Userpatient> findAllUserPatient(Integer userId) throws CrmCommonException {
		if (userId==null) {
			throw CrmCommonException.getException(401);
		}
		/*UserpatientExample example = new UserpatientExample();
		//example.createCriteria().andUserIdEqualTo(userId);
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStatusEqualTo("未处理");
		List<Userpatient> list = UserpatientMapper.selectByExample(example);
		if (list.isEmpty()) {
			throw CrmCommonException.getException(402); 
		}*/
		return userpatientMapper.findAllUserpatient(userId);
		//return list;
	}
	
	/**
	 * 查找科室已处理的病人
	 * @param session
	 * @return
	 */
	@Override
	public List<Userpatient> findAllUserPatients(Integer userId) throws CrmCommonException {
		// TODO Auto-generated method stub
		if (userId==null) {
			throw CrmCommonException.getException(401);
		}
		/*UserpatientExample example = new UserpatientExample();
		//example.createCriteria().andUserIdEqualTo(userId);
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStatusEqualTo("已处理");
		List<Userpatient> list = UserpatientMapper.selectByExample(example);
		if (list.isEmpty()) {
			throw CrmCommonException.getException(402); 
		}*/
		//return list;
		return userpatientMapper.findUserpatient(userId);
	}
	
	/**
	 * 更新所有的UserPatient未处理
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	@Override
	public void updateStatus(Userpatient record,Integer id) throws CrmCommonException {
		record.setStatus("已处理");
		UserpatientExample example = new UserpatientExample();
		example.createCriteria().andIdEqualTo(id);
		userpatientMapper.updateByExampleSelective(record, example);
	}

	/**
	 * 查找UserPatient通过ID
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	@Override
	public Userpatient findUserPatient(Integer id) throws CrmCommonException{
		if (id==null) {
			throw CrmCommonException.getException(401);
		}
		return userpatientMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUserpatient(Userpatient record) throws CrmCommonException {
		userpatientMapper.updateByPrimaryKeySelective(record);
	}

}
