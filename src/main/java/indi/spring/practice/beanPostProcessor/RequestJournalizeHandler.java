package indi.spring.practice.beanPostProcessor;

import java.sql.Timestamp;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import indi.spring.practice.entity.JournalizeHis;
import indi.spring.practice.handler.JournalizeHisHandler;
import indi.spring.practice.repository.JournalizeHisRepo;


public class RequestJournalizeHandler implements BeanPostProcessor {

	Logger LOG = LoggerFactory.getLogger(RequestJournalizeHandler.class);

//	@Autowired
//	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	private JournalizeHisRepo journalizeHisRepo;

	/**
	 * before bean initialize
	 * 
	 * @param bean 帶入有在 xml 註冊的 JournalizeHisHandler
	 * @param beanName
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		Long sysTime = System.currentTimeMillis();
		LOG.debug("=====> Request time: ${}", sysTime);
		
		// 寫入資料庫
		if(bean instanceof JournalizeHisHandler) {
			insertJournal((JournalizeHisHandler) bean, sysTime, "in");
		}

		return bean;
	}

	/**
	 * after bean initialize
	 * 
	 * @param bean 帶入有在 xml 註冊的 JournalizeHisHandler
	 * @param beanName
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		Long sysTime = System.currentTimeMillis();
		LOG.debug("=====> Request elapse time: ${}", sysTime);

		// 寫入資料庫
		if(bean instanceof JournalizeHisHandler) {
			insertJournal((JournalizeHisHandler) bean, sysTime, "out");
		}

		return bean;
	}

	/**
	 * 寫入 JournalizeHis
	 */
	private void insertJournal(JournalizeHisHandler bean, Long sysTime, String orient) {
		
		// 寫入歷史紀錄
		JournalizeHis journalizeHis = new JournalizeHis();
		journalizeHis.setLastChngTm(new Timestamp(sysTime));
		journalizeHis.setSvcCd("PstPrcsSvc");
		journalizeHis.setUuid(UUID.randomUUID().toString());
		journalizeHis.setOrient(orient);

		journalizeHisRepo.save(journalizeHis);
		
		// 將值塞進 JournalizeHisHandler
		bean.setSvcCd("PstPrcsSvc");
		bean.setSystime(new Timestamp(sysTime));
		bean.setOrient(orient);
		
	}
}
