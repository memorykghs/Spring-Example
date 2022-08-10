package indi.spring.practice.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class JournalizeHisPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "UUID")
	String uuid;

	@Column(name = "LAST_CHNG_TM")
	Timestamp lastChngTm;
}
