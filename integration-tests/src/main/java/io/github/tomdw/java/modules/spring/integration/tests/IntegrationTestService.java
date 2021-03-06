package io.github.tomdw.java.modules.spring.integration.tests;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import io.github.tomdw.java.modules.context.boot.api.ModuleServiceReference;
import io.github.tomdw.java.modules.spring.samples.basicapplication.speaker.api.MultipleSpeakerService;
import io.github.tomdw.java.modules.spring.samples.basicapplication.speaker.api.MultipleSpeakerWithGenericsService;
import io.github.tomdw.java.modules.spring.samples.basicapplication.speaker.api.NamedSpeakerService;
import io.github.tomdw.java.modules.spring.samples.basicapplication.speaker.api.SpeakerService;

@Named
public class IntegrationTestService implements ApplicationContextAware {

	@ModuleServiceReference
	private SpeakerService speakerService;

	@ModuleServiceReference
	@Named("multipleSpeakerServiceList")
	private List<MultipleSpeakerService> multipleSpeakerServices;

	@ModuleServiceReference
	private NamedSpeakerService namedSpeakerService;

	@ModuleServiceReference
	@Named("multipleSpeakerWithGenericsServiceList")
	private List<MultipleSpeakerWithGenericsService<?>> multipleSpeakerWithGenericsServices;

	private static ApplicationContext applicationContext;

	public List<MultipleSpeakerService> getMultipleSpeakerServices() {
		return multipleSpeakerServices;
	}

	public NamedSpeakerService getNamedSpeakerService() {
		return namedSpeakerService;
	}

	public List<MultipleSpeakerWithGenericsService<?>> getMultipleSpeakerWithGenericsServices() { return multipleSpeakerWithGenericsServices; }

	public SpeakerService getSpeakerService() {
		return speakerService;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
