package com.rollingstone.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Template;
import com.rollingstone.service.TemplateService;

@RestController
@RequestMapping("/template")
public class TemplateController extends AbstractRestController {

	Logger logger = LoggerFactory.getLogger("TemplateController");

	TemplateService templateService;

	public TemplateController(TemplateService templateService) {
		this.templateService = templateService;
	}

	@PostMapping
	public Template createTemplate(@RequestBody Template template) {
		Template templateSaved = templateService.save(template);

		logger.info("Template Saved :" + templateSaved.toString());
		return template;
	}

	@GetMapping("/{id}")
	public Template get(@PathVariable("id") Long id) {

		Optional<Template> templateRetreived = templateService.getTemplate(id);
		Template template = templateRetreived.get();
		return template;
	}

	@GetMapping("/bypage")
	Page<Template> getByPage(
			@RequestParam(value = "pagenumber", required = true, defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") Integer pageSize) {
		return templateService.getTemplateByPage(pageNumber, pageSize);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public Template update(@RequestBody Template template) {
		Template templateUpdated = templateService.save(template);

		logger.info("template Saved :" + templateUpdated.toString());
		return template;
	}

	/*---Delete a Product by id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
	     templateService.deleteTemplate(id);
		return ResponseEntity.ok().body("template has been deleted successfully.");
	}
}
