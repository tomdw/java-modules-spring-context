package be.tomdw.java.modules.spring.samples.basicapplication.internal;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.InitializingBean;

import be.tomdw.java.modules.context.boot.api.ModuleServiceReference;
import be.tomdw.java.modules.spring.samples.basicapplication.speaker.api.SpeakerService;

@Named
public class MessageGenerator implements InitializingBean {

	@ModuleServiceReference
	@Inject
	private SpeakerService speakerService;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.speakerService.speak("Hello World!");
		this.speakerService.speak("JPMS stands for 'Java Platform Module System'");
		this.speakerService.speak("Let's explore it together.");
	}
}