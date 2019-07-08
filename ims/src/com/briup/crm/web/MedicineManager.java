package com.briup.crm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.common.bean.Category;
import com.briup.crm.common.bean.Drug;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICategoryService;
import com.briup.crm.service.interfaces.IDrugService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/medicineManagerMan")
public class MedicineManager {
	
	@Autowired
	private IDrugService drugService;
	@Autowired
	private ICategoryService categoryService;
	
	/**
	 * 药品类别管理
	 * @param session
	 * @return
	 */
	@RequestMapping(value="{page}/category")
	public String category(@PathVariable Integer page,HttpSession session,HttpServletRequest request) {
		String sizes = request.getParameter("size");
		int size=0;
		if (sizes==null) {
			size=5;
		}else {
			size=Integer.parseInt(sizes);
		}
		try {
			PageInfo<Category> categoryes = categoryService.findCategorys(page,size);
			session.setAttribute("categoryes", categoryes);
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/category";
	}
	/**
	 * 查找所有的药品
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/drug")
	public String drug(HttpSession session) {
		try {
			List<Drug> drugs = drugService.findAllDrug();
			session.setAttribute("drugs", drugs);
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/drug";
	}
	
	/**
	 * 查找药品根据Id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/selectDrugById")
	@ResponseBody
	public Drug selectDrugById(HttpSession session,Integer id) {
		try {
			 Drug drug = drugService.findDrugs(id);
			 session.setAttribute("drug", drug);
			 return drug;
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 取药 更新药品数量
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/medicineGetting")
	@ResponseBody
	public String medicineGetting(HttpSession session,Drug drug) {
		try {
			Drug drugs = (Drug) session.getAttribute("drug");
			//Drug drugs = drugService.findDrugs(drug.getId());方法二
			Integer inventory=drugs.getInventory()-drug.getInventory();
			if (inventory<drugs.getMinimum()) {
				return "failed";
			}else {
				drug.setInventory(inventory);
				drugService.updateDrugNumber(drug);
				return "success";
			}
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
}
