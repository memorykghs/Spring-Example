package indi.spring.practice.service.impl;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import indi.spring.practice.dto.PostProcessorTranrs;
import indi.spring.practice.entity.JournalizeHis;
import indi.spring.practice.entity.JournalizeHisPK;
import indi.spring.practice.handler.JournalizeHisHandler;
import indi.spring.practice.service.PostProcessorService;

/**
 * 測試 beanPostProcessor
 * 
 * @author memorykghs
 */
@Service
@SuppressWarnings("resource")
public class PostProcessorServiceImpl implements PostProcessorService {

//	@Autowired
//	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private JournalizeHisHandler handler;

	@Override
	public PostProcessorTranrs test() {

		// 確保對要存入 redis 的資料做過序列化處理
//		setSerializer();

//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-practice.xml");
//		JournalizeHisHandler handler = (JournalizeHisHandler) context.getBean("journalizeHisHandler");
		JournalizeHis journalizeHis = handler.createJounal();

		PostProcessorTranrs resp = new PostProcessorTranrs();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
		resp.setLastChngTm(formatter.format(journalizeHis.getLastChngTm().toLocalDateTime()));
		resp.setSvcCd(journalizeHis.getSvcCd());
		resp.setOrient(journalizeHis.getOrient());

		return resp;
	}

	@Override
	public void select(JournalizeHisPK journalizeHisPK) {

	}

	/**
	 * 對 redis 進行初始序列化
	 */
//	private void setSerializer() {
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setValueSerializer(new StringRedisSerializer());
//	}
}
