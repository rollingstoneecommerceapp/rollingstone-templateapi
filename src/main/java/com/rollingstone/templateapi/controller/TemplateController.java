package com.rollingstone.templateapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

	@GetMapping("/status")
	public String status() {
		return "app is up and running";
	}
}
