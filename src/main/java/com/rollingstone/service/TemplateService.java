package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.TemplateRepository;
import com.rollingstone.domain.Template;

@Service
public class TemplateService {

	TemplateRepository templateRepository;

	public TemplateService(TemplateRepository templateRepository) {
		super();
		this.templateRepository = templateRepository;
	}
	
	
	public Template save(Template template) {
		Template productSaved = templateRepository.save(template);
		
		return productSaved;
	}
	
	public Page<Template> getTemplateByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		
		
		return templateRepository.findAll(pageable);		
		
	}
	
	public Optional<Template> getTemplate(Long templateId) {
		
		return templateRepository.findById(templateId);
	}
	
	public void deleteTemplate(Long templateId) {
		templateRepository.deleteById(templateId);
	}
}
