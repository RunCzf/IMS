package com.briup.crm.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.common.bean.Patientphysicalexam;
import com.briup.crm.common.bean.Physicalexam;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IPatientphysicalexamService;
import com.briup.crm.service.interfaces.IPhysicalexamService;

@Controller
@RequestMapping(value="/technician")
public class Technician {

	@Autowired
	private IPhysicalexamService physicalexamService;
	@Autowired
	private IPatientphysicalexamService patientphysicalexamService;
	/**
	 * 查找所有的physicalexam
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/pe")
	public String pe(HttpSession session) {
		try {
			List<Physicalexam> physicalexams = physicalexamService.findphysicalexams();
			session.setAttribute("physicalexams", physicalexams);
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/pe";
	}
	
	/**
	 * 添加的physicalexam ,produces= {"text/html;charset=utf-8"}
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addPhysicalexam")
	@ResponseBody
	public String addPhysicalexam(HttpSession session,Physicalexam physicalexam) {
		//@RequestParam(value="phyId",required=false)Integer id
		try {
			System.out.println(physicalexam.getName()+physicalexam.getPrice());
			physicalexamService.insertPhysicalexam(physicalexam);
			return "success";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 删除辅助检查项目
	 * @param session
	 * @param physicalexam
	 * @return
	 */
	@RequestMapping(value="/deletepe",method=RequestMethod.POST)
	@ResponseBody
	public String deletepe(HttpSession session,Integer id) {
		try {
			physicalexamService.deleteById(id);
			return "succes";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 录入检查项目
	 * @param session
	 * @param physicalexam
	 * @return
	 */
	@RequestMapping(value="/entryCheckResult")
	public String entryCheckResult(HttpSession session,Physicalexam physicalexam) {
			
		return "html/entryCheckResult";
		}
	
	/**
	 * 查找Physicalexam
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findPeById")
	@ResponseBody
	public Physicalexam findPeById(HttpSession session,Integer id) {
		try {
			Physicalexam physicalexam = physicalexamService.findPhysicalexam(id);
			return physicalexam;
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 新增Patientphysicalexam
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/insertPhysicalexam")
	public void insertPhysicalexam(HttpSession session,Patientphysicalexam patientphysicalexam) {
		try {
			patientphysicalexamService.insertPhysicalexam(patientphysicalexam);
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
	}
}
