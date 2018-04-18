package com.richway.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasePageController {

	@RequestMapping("/")
	public String index(ModelMap map) {
		map.addAttribute("host","https://www.rtongcloud.com");
		return "index";
	}
}
