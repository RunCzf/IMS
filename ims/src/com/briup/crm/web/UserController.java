package com.briup.crm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.common.bean.Department;
import com.briup.crm.common.bean.Drug;
import com.briup.crm.common.bean.Patientdrug;
import com.briup.crm.common.bean.User;
import com.briup.crm.common.bean.Userpatient;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IDepartmentService;
import com.briup.crm.service.interfaces.IDrugService;
import com.briup.crm.service.interfaces.IPatientDrugService;
import com.briup.crm.service.interfaces.IUserPatientService;
import com.briup.crm.service.interfaces.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserPatientService userPatientService;
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private IDrugService drugService;
	@Autowired
	private IPatientDrugService patientDrugService;
	
	/**
	 * 登陆
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session) {
		try {
				List<User> users = userService.login(username, password);
				for (User user : users) {
					session.setAttribute("user", user);
				}
				session.setAttribute("msg", "登陆成功:");
				return "index";
			} catch (CrmCommonException e) {
				e.printStackTrace();
				session.setAttribute("msg", "登录失败:"+ e.getMessage());
				return "login";
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	/**
	 * 查找科室未处理的病人
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/nodealPatient",method=RequestMethod.GET)
	public String nodealPatient(Integer userId,HttpSession session) {
		try {
			List<Userpatient> userPatients = userPatientService.findAllUserPatient(userId);
			User user = userService.findUser(userId);
			Department department = departmentService.findDepartment(user.getDepartmentId());
			session.setAttribute("department", department);
			session.setAttribute("userPatients", userPatients);
			/*for (Userpatient userpatient : userPatients) {
				Patient patient = patientService.findPatient(userpatient.getPatientId());
				session.setAttribute("patient", patient);
				if (session.getAttribute("patient")!=null) {
					session.removeAttribute("patient");
				}
			}*/
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/nodealPatient";
	}
	
	/**
	 * 查找科室已处理的病人
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/dealedPatient",method=RequestMethod.GET)
	public String dealedPatient(Integer userId,HttpSession session) {
		try {
			List<Userpatient> userPatients = userPatientService.findAllUserPatients(userId);
			session.setAttribute("userPatients", userPatients);
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/dealedPatient";
	}
	
	/**
	 * 开处方查询所有药物
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/prescription")
	public String prescription(HttpSession session) {
		try {
			List<Drug> drugs = drugService.findAllDrug();
			session.setAttribute("drugs", drugs);
			/*return "success";*/
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
		}
		return "html/prescription";
	}
	
	/**
	 * 诊断病人
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	@RequestMapping(value="/diagnosis")
	public String diagnosis(HttpSession session) {
		return "html/diagnosis";
	}
	
	/**
	 * 诊断病人并保存记录
	 * @param IUserPatientService
	 * @throws CrmCommonException
	 */
	@RequestMapping(value="/updateUserpatient")
	@ResponseBody
	public String updateUserpatient(HttpSession session,Userpatient userpatient) {
		try {
			userPatientService.updateUserpatient(userpatient);
			System.out.println(userpatient.getId());
			return "success";
		} catch (CrmCommonException e) {
			e.printStackTrace();
			return "html/diagnosis";
		}
	}
	
	/**
	 * 修改所有的UserPatient未处理
	 * @param userPatientService
	 * @throws CrmCommonException
	 */
	@RequestMapping(value="/dispose")
	@ResponseBody
	public String dispose(HttpSession session,Userpatient userpatient,@RequestParam(value="ids[]",required=false)String[] ids) {
		try {
			session.setAttribute("ids", ids);
			for (String id : ids) {
				int Id = Integer.valueOf(id);
				userPatientService.updateStatus(userpatient,Id);
			}
			return "success";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 增加处方
	 * @param patientDrugService
	 * @throws CrmCommonException
	 */
	@RequestMapping(value="/nodealAddPatient")
	@ResponseBody
	public String nodealAddPatient(Patientdrug patientdrug,HttpSession session,
			HttpServletRequest request) {
		try {
			Drug drug = drugService.findDrugs(patientdrug.getDrugId());
			Double price = drug.getPrice();
			Integer num = patientdrug.getNum();
			patientdrug.setCost(price*num);
			patientDrugService.insertPatientDrug(patientdrug);
			return "success";
		} catch (CrmCommonException e) {
			session.setAttribute("msg", "登录失败:"+ e.getMessage());
			return null;
		}
	}
	
	/**
	 * 处方查询
	 * @param patientDrugService
	 * @throws CrmCommonException
	 */
	@RequestMapping(value="selectPrescription")
	public String selectPrescription() {
		return "html/selectPrescription";
	}
	
	/**
	 * 开检查
	 * @param patientDrugService
	 * @throws CrmCommonException
	 */
	@RequestMapping(value="check")
	public String check() {
		return "html/check";
	}
}
