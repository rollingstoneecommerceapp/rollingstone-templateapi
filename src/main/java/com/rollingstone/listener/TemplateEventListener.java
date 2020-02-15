package com.rollingstone.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.service.event.TemplateServiceEvent;

@Component
public class TemplateEventListener implements ApplicationListener<TemplateServiceEvent> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@EventListener
	public void onApplicationEvent(TemplateServiceEvent event) {
		TemplateServiceEvent addressEvent = (TemplateServiceEvent) event;
		logger.info("Template Event Listener " + event.getEventType() + " with details : " 
		+ event.getTemplate().toString());
	}
}