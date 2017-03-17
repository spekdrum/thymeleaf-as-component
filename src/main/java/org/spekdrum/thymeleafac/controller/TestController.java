package org.spekdrum.thymeleafac.controller;

import org.spekdrum.thymeleafac.service.TlTransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

@RestController
public class TestController {

	private final TlTransformService tlTransformService;

	@Autowired
	public TestController(TlTransformService tlTransformService) {
		this.tlTransformService = tlTransformService;
	}


	@RequestMapping("/")
	@ResponseBody
	public String test(@RequestParam("name") String name) {

		Context ctx = new Context();
		ctx.setVariable("name", name);

		String document = tlTransformService.applyTemplate("test-template", ctx);

		return document;
	}
}
