package indi.spring.practice.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostProcessorTranrs implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "LastChangeTime")
	String lastChngTm;

	@JsonProperty(value = "serviceCode")
	String svcCd;
	
	@JsonProperty(value = "orient")
	String orient;
}
