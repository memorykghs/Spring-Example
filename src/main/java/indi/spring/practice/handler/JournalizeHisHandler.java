package indi.spring.practice.handler;


import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import indi.spring.practice.entity.JournalizeHis;
import lombok.Data;

@Component
@Data
public class JournalizeHisHandler {
	
	private String svcCd;
	
	private Timestamp systime;
	
	private String orient;

	public JournalizeHis createJounal() {
		
		JournalizeHis journalizeHis = new JournalizeHis();
		return journalizeHis;
	}
	
	public void initBean()
    {
        System.out.println("JournalizeHis is Initialized.");
    }
 
    public void destroyBean()
    {
        System.out.println("JournalizeHis is Destroyed.");
    }
}
