package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Template;


public interface TemplateRepository extends PagingAndSortingRepository <Template, Long>{

}
