package indi.spring.practice.service;

import indi.spring.practice.dto.PostProcessorTranrs;
import indi.spring.practice.entity.JournalizeHisPK;

/**
 * 測試 beanPostProcessor
 * 
 * @author memorykghs
 */
public interface PostProcessorService {
	
	PostProcessorTranrs test();
	
	void select(JournalizeHisPK journalizeHisPK);
}
