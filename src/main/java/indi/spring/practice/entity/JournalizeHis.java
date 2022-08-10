package indi.spring.practice.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "JRNL_HIS")
@IdClass(value = JournalizeHisPK.class)
@Data
public class JournalizeHis implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "UUID")
	String uuid;
	
	@Id
	@Column(name = "LAST_CHNG_TM")
	Timestamp lastChngTm;
	
	@Column(name = "SVC_CD")
	String svcCd;
	
	@Column(name = "ORIENT")
	String orient;
}
