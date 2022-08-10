package indi.spring.practice.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostProcessorTranrq implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "LastChangeTime")
	Timestamp lastChngTm;

	@JsonProperty(value = "serviceCode")
	String svcCd;
}
