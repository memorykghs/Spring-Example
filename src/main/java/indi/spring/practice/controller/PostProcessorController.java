package indi.spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import indi.spring.practice.dto.PostProcessorTranrs;
import indi.spring.practice.service.PostProcessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Spring Boot Test")
@RestController
@RequestMapping(value = "/beanpost")
public class PostProcessorController {
	
	@Autowired
	private PostProcessorService postProcessorService;

	/**
	 * 測試 beanPostProcessor
	 * @param req
	 * @return
	 */
	@ApiOperation(value = "test")
	@PostMapping(value = "/test")
	public PostProcessorTranrs test() {
		
		return postProcessorService.test();
	}
}
