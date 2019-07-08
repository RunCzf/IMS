package com.briup.crm.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/outpatient")
public class OutpatientController {

	/**
	 * 门诊挂号
	 * @param session
	 * @return
	 */
	@RequestMapping(value="register")
	public String register(HttpSession session) {
		return "html/register";
	}
}
