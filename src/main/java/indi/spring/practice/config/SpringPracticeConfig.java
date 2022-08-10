package indi.spring.practice.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import indi.spring.practice.service.PostProcessorService;

public final class SpringPracticeConfig {

	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-practice.xml");
		PostProcessorService postProcessorService = context.getBean("messenger", PostProcessorService.class);
		System.out.println(postProcessorService);
	}

}
