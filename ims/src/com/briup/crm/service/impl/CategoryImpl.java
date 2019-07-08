package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Category;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.CategoryMapper;
import com.briup.crm.service.interfaces.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CategoryImpl implements ICategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	/***
	 * 查找所有的Category
	 * @return
	 * @throws CrmCommonException
	 */
	@Override
	public PageInfo<Category> findCategorys(Integer page,Integer size) throws CrmCommonException {
		PageHelper.startPage(page, size);
		List<Category> categories = categoryMapper.selectCategorys();
		System.out.println(categories);
		return new PageInfo<>(categories);
	}

}
