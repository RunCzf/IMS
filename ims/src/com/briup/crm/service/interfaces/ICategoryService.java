package com.briup.crm.service.interfaces;

import com.briup.crm.common.bean.Category;
import com.briup.crm.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

public interface ICategoryService {

	/***
	 * 查找所有的Category
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<Category> findCategorys(Integer page,Integer size) throws CrmCommonException;
}
