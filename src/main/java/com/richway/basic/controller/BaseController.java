package com.richway.basic.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("basic")
public class BaseController {

	
	@RequestMapping("hello")
	public String getBasicInfo() {
		return "hello world!";
	}
	
	
}
