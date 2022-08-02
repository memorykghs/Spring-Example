package indi.spring.practice.beanPostProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;



public class RequestJournalizeHandler implements BeanPostProcessor{
	
	Logger LOG = LoggerFactory.getLogger(RequestJournalizeHandler.class);
	
	/**
	 * before bean initialize
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		Long sysTime = System.currentTimeMillis();
		
		// TODO 寫資料庫
		LOG.debug("=====> Request time: ${}", sysTime);
		
		
		return bean;
	}
	
	/**
	 * after bean initialize
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		Long sysTime = System.currentTimeMillis();
		
		// TODO 寫資料庫
		LOG.debug("=====> Request elapse time: ${}", sysTime);
		
		return bean;
	}
}
