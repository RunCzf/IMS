package com.briup.crm.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.common.bean.Patient;
import com.briup.crm.common.bean.Userpatient;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IPatientService;

@Controller
@RequestMapping(value="/guideDoctor")
public class GuideDoctor {
	
	@Autowired
	private IPatientService patientService;
	
	/**
	 * 查找所有的病人
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/patient")
	public String patient(HttpSession session) {
		try {
			List<Patient> patients = patientService.selectPatients();
			session.setAttribute("patients", patients);
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/patient";
	}
	
	/**
	 * 更据Id查找病人
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/findPatientByid")
	@ResponseBody
	public Patient findPatientByid(HttpSession session,Integer id) {
		try {
			Patient patient = patientService.selectPatient(id);
			return patient;
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 修改patient信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updatePatient")
	@ResponseBody
	public String updatePatient(HttpSession session,Patient patient) {
		try {
			patientService.updatePatient(patient);
			return "success";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 添加patient
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addPatient")
	@ResponseBody
	public String addPatient(HttpSession session,Patient patient) {
		try {
			patientService.insertPatient(patient);
			return "success";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 删除patient
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/deletePatient")
	@ResponseBody
	public String deletePatient(HttpSession session,Integer id) {
		try {
			patientService.deletePatient(id);
			return "success";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(value="/deletePatients")
	@ResponseBody
	public String deletePatients(HttpSession session,Userpatient userpatient,@RequestParam(value="ids[]",required=false)String[] ids) {
		try {
			session.setAttribute("ids", ids);
			for (String id : ids) {
				int Id = Integer.valueOf(id);
				patientService.deletePatient(Id);
			}
			return "success";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
}
