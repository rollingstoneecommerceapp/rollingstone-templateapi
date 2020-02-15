package com.rollingstone.service.event;

import org.springframework.context.ApplicationEvent;

import com.rollingstone.domain.Template;

/**
 * This is an optional class used in publishing application events. This can be
 * used to inject events into the Spring Boot audit management endpoint.
 */
public class TemplateServiceEvent extends ApplicationEvent {
	
	Template template;
	String eventType;
	
	public TemplateServiceEvent(Object source) {
		super(source);
	}

	public String toString() {
		return "My Template Event";
	}


	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public TemplateServiceEvent(Object source, Template template, String eventType) {
		super(source);
		this.template = template;
		this.eventType = eventType;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
	
	
}