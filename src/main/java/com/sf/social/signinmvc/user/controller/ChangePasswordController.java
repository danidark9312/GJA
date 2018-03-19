package com.sf.social.signinmvc.user.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/changePassword" }) //url
public class ChangePasswordController {

	private static final Logger LOG = Logger.getLogger(ChangePasswordController.class);
	
	@RequestMapping()
	public String getCreateForm(Model model, Locale loc) {
		return "seguridad/changePassword"; //carpeta y el jsp
	}
	
}

